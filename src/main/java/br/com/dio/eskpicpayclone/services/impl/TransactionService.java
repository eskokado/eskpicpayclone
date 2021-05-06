package br.com.dio.eskpicpayclone.services.impl;

import br.com.dio.eskpicpayclone.converters.ConverterTransaction;
import br.com.dio.eskpicpayclone.dto.TransactionDTO;
import br.com.dio.eskpicpayclone.models.Transaction;
import br.com.dio.eskpicpayclone.repositories.ITransactionRepository;
import br.com.dio.eskpicpayclone.services.ICreditCardService;
import br.com.dio.eskpicpayclone.services.ITransactionService;
import br.com.dio.eskpicpayclone.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ConverterTransaction converterTransaction;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private ICreditCardService creditCardService;

    @Override
    public TransactionDTO process(TransactionDTO transactionDTO) {
        Transaction transaction = save(transactionDTO);
        creditCardService.save(transactionDTO.getCreditCard());
        userService.updateBalance(transaction, transactionDTO.getIsCreditCard());
        return converterTransaction.convertEntityToDto(transaction);
    }

    private Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction = converterTransaction.convertDtoToEntity(transactionDTO);
        userService.validate(transaction.getDestination(), transaction.getSource());
        return transactionRepository.save(transaction);
    }

    @Override
    public Page<TransactionDTO> listPerPage(Pageable pagination, String login) {
        Page<Transaction> transactions =
                transactionRepository.findBySource_LoginOrDestination_Login(login, login, pagination);
        return converterTransaction.convertPageEntityToDto(transactions);
    }
}
