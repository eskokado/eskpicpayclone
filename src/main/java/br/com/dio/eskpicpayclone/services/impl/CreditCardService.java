package br.com.dio.eskpicpayclone.services.impl;

import br.com.dio.eskpicpayclone.converters.ConverterCreditCard;
import br.com.dio.eskpicpayclone.dto.CreditCardDTO;
import br.com.dio.eskpicpayclone.models.CreditCard;
import br.com.dio.eskpicpayclone.repositories.ICreditCardRepository;
import br.com.dio.eskpicpayclone.services.ICreditCardService;
import br.com.dio.eskpicpayclone.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditCardService implements ICreditCardService {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Autowired
    private ConverterCreditCard converterCreditCard;

    @Autowired
    private IUserService userService;

    @Override
    public CreditCardDTO save(CreditCardDTO creditCardDTO) {
        CreditCardDTO creditCardReturn = null;
        if (creditCardDTO.getIsSave()) {
            CreditCard creditCard = converterCreditCard.convertDtoToEntity(creditCardDTO);
            userService.validate(creditCard.getUser());
            CreditCard creditCardSalvo = creditCardRepository.save(creditCard);
            creditCardReturn = converterCreditCard.convertEntityToDto(creditCardSalvo);
        }
        return creditCardReturn;
    }
}
