package br.com.pablojesus.vacancy_management.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User is existed");
    }
}
