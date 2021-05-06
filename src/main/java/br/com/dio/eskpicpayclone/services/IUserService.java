package br.com.dio.eskpicpayclone.services;

import br.com.dio.eskpicpayclone.models.Transaction;
import br.com.dio.eskpicpayclone.models.User;

public interface IUserService {
    void updateBalance(Transaction transaction, Boolean isCreditCard);

    void validate(User... users);

    User findEntity(String login);
}
