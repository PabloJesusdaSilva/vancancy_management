package br.com.pablojesus.vacancy_management.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "Pablo Aquino")
    private String name;

    @Schema(example = "pabloaquino")
    private String username;

    @Schema(example = "pabloaquino@gmail.com")
    private String email;

    @Schema(example = "Desenvolvedor Java")
    private String description;
}
