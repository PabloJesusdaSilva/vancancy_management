package br.com.pablojesus.vacancy_management.modules.company.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pablojesus.vacancy_management.modules.job.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
