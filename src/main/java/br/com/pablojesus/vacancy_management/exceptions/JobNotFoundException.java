package br.com.pablojesus.vacancy_management.exceptions;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException() {
        super("Job not found");
    }
}
