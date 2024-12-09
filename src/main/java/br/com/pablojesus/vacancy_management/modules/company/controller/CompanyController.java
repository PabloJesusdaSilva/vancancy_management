package br.com.pablojesus.vacancy_management.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablojesus.vacancy_management.modules.company.entities.CompanyEntity;
import br.com.pablojesus.vacancy_management.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;

@RestController("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase companyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = companyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result); 
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}