package br.com.pablojesus.vacancy_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.pablojesus.vacancy_management.exceptions.UserFoundException;
import br.com.pablojesus.vacancy_management.modules.candidate.CandidateEntity;
import br.com.pablojesus.vacancy_management.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    
    @Autowired
    private CandidateRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.repository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException();
            });
    
        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);
        
        return this.repository.save(candidateEntity);
    }
}
