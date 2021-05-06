package br.com.dio.eskpicpayclone.services;

import br.com.dio.eskpicpayclone.dto.UserDTO;
import br.com.dio.eskpicpayclone.models.Transaction;
import br.com.dio.eskpicpayclone.models.User;

import java.util.List;

public interface IUserService {
    void updateBalance(Transaction transaction, Boolean isCreditCard);

    void validate(User... users);

    User findEntity(String login);

    UserDTO consult(String login);

    List<UserDTO> list(String login);
}
