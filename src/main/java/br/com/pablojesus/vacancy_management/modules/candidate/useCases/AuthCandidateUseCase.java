package br.com.pablojesus.vacancy_management.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.pablojesus.vacancy_management.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.pablojesus.vacancy_management.modules.candidate.dto.AuthCandidateResponseDTO;
import br.com.pablojesus.vacancy_management.modules.candidate.repository.CandidateRepository;

@Service
public class AuthCandidateUseCase {
    
    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidate) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCandidate.username())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Username/Password incorrect");
            });

        var passwordMatches = this.passwordEncoder.matches(authCandidate.password(), candidate.getPassword());

        if(!passwordMatches) {
            throw new AuthenticationException();   
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(15));
        var token = JWT.create()
            .withIssuer("javagas")
            .withSubject(candidate.getId().toString())
            .withClaim("roles", Arrays.asList("CANDIDATE"))
            .withExpiresAt(expiresIn)
            .sign(algorithm);

        var AuthCandidateResponse = AuthCandidateResponseDTO.builder()
            .access_token(token)
            .expires_in(expiresIn.toEpochMilli())
            .build();

        return AuthCandidateResponse;
    }
}
