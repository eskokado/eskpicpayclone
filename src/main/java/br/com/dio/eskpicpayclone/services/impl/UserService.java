package br.com.dio.eskpicpayclone.services.impl;

import br.com.dio.eskpicpayclone.exceptions.BusinessException;
import br.com.dio.eskpicpayclone.models.Transaction;
import br.com.dio.eskpicpayclone.models.User;
import br.com.dio.eskpicpayclone.repositories.IUserRepository;
import br.com.dio.eskpicpayclone.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    @Async("asyncExecutor")
    public void updateBalance(Transaction transaction, Boolean isCreditCard) {
        decreaseBalance(transaction, isCreditCard);
        increaseBalance(transaction);
    }

    private void decreaseBalance(Transaction transaction, Boolean isCreditCard) {
        if (!isCreditCard) {
            userRepository.updateDecreaseBalance(transaction.getSource().getLogin(), transaction.getValue());
        }
    }

    private void increaseBalance(Transaction transaction) {
        userRepository.updateIncreaseBalance(transaction.getDestination().getLogin(), transaction.getValue());
    }

    @Override
    public void validate(User... users) {
        Arrays.asList(users).stream().forEach(user -> {
            if (user == null) {
                throw new BusinessException("O usuário informado não existe!");
            }
        });
    }

    @Override
    public User findEntity(String login) {
        return userRepository.findByLogin(login);
    }
}
