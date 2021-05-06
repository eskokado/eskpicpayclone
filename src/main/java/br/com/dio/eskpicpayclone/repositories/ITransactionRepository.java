package br.com.dio.eskpicpayclone.repositories;

import br.com.dio.eskpicpayclone.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findBySource_LoginOrDestination_Login(String login, String login1, Pageable pagination);
}
