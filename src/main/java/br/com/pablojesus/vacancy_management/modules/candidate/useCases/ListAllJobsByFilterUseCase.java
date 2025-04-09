package br.com.pablojesus.vacancy_management.modules.candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pablojesus.vacancy_management.modules.company.repositories.JobRepository;
import br.com.pablojesus.vacancy_management.modules.job.entities.JobEntity;

@Service
public class ListAllJobsByFilterUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContaining(filter);
    }
}
