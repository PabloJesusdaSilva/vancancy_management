package br.com.pablojesus.vacancy_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pablojesus.vacancy_management.modules.candidate.CandidateRepository;
import br.com.pablojesus.vacancy_management.modules.candidate.dto.ProfilesCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    private ProfilesCandidateResponseDTO candidateResponseDTO;

    public ProfilesCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var candidateDTO = candidateResponseDTO.builder()
            .description(candidate.getDescription())
            .email(candidate.getEmail())
            .name(candidate.getName())
            .username(candidate.getUsername())
            .id(idCandidate)
            .build();

        return candidateDTO;
    }
}
