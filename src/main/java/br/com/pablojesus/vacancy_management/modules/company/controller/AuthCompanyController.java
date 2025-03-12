package br.com.pablojesus.vacancy_management.modules.company.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablojesus.vacancy_management.modules.company.useCases.AuthCompanyUseCase;
import br.com.pablojesus.vacancy_management.modules.dto.AuthCompanyDTO;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {
    
    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/company")
    public ResponseEntity create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {   
            var result = this.authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
