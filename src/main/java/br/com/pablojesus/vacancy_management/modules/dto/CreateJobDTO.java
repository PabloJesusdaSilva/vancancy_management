package br.com.pablojesus.vacancy_management.modules.dto;

import lombok.Data; 

@Data
public class CreateJobDTO {

    private String description;
    private String benefits;
    private String level;
}
