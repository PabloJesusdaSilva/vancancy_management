package br.com.pablojesus.vacancy_management.modules.candidate.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilesCandidateResponseDTO {
    
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String description;
}
