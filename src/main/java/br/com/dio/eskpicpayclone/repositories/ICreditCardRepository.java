package br.com.dio.eskpicpayclone.repositories;

import br.com.dio.eskpicpayclone.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditCardRepository extends JpaRepository<CreditCard, Long> {
}
