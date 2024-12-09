package br.com.pablojesus.vacancy_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pablojesus.vacancy_management.modules.company.repositories.JobRepository;
import br.com.pablojesus.vacancy_management.modules.job.entities.JobEntity;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }    
}