package br.com.pablojesus.vacancy_management.modules.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data; 

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolvedora Júnior", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GYMPass, Vale Refeição", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "Júnior", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
