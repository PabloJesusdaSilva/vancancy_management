package br.com.pablojesus.vacancy_management.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pablojesus.vacancy_management.modules.candidate.entity.ApplyJobEntity;


public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {}

