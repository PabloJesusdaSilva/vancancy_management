package br.com.pablojesus.vacancy_management.modules.company.useCases;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.pablojesus.vacancy_management.modules.company.repositories.CompanyRepository;
import br.com.pablojesus.vacancy_management.modules.dto.AuthCompanyDTO;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;
    
    @Autowired
    private CompanyRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = repository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("Username/Password incorrect");
            });

        var passwordMathes = passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMathes) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("javagas")
            .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
            .withSubject(company.getId().toString())
            .sign(algorithm);
        return token;
    }
}
