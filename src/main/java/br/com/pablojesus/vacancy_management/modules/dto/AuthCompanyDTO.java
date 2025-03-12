package br.com.pablojesus.vacancy_management.modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
    
    private String username;
    private String password;
}
