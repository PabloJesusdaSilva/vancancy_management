package br.com.pablojesus.vacancy_management.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablojesus.vacancy_management.modules.company.useCases.CreateJobUseCase;
import br.com.pablojesus.vacancy_management.modules.job.entities.JobEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;
    
    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createJobUseCase.execute(jobEntity);
    }
}
