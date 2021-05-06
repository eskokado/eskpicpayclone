package br.com.dio.eskpicpayclone.services;

import br.com.dio.eskpicpayclone.dto.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransactionService {
    TransactionDTO process(TransactionDTO transactionDTO);

    Page<TransactionDTO> listPerPage(Pageable pagination, String login);
}
