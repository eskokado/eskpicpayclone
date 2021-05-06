package br.com.dio.eskpicpayclone.converters;

import br.com.dio.eskpicpayclone.dto.TransactionDTO;
import br.com.dio.eskpicpayclone.models.Transaction;
import br.com.dio.eskpicpayclone.services.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ConverterTransaction extends ConverterBase<Transaction, TransactionDTO>{

    @Autowired
    private IUserService userService;

    @Override
    public TransactionDTO convertEntityToDto(Transaction entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transaction, TransactionDTO>() {
            @Override
            protected void configure() {}
        });
        return modelMapper.map(entity, TransactionDTO.class);
    }

    public Transaction convertDtoToEntity(TransactionDTO dto) {
        return Transaction.builder()
                .code(dto.getCode())
                .dateTime(dto.getDateTime())
                .value(dto.getValue())
                .destination(userService.findEntity(dto.getDestination().getLogin()))
                .source(userService.findEntity(dto.getSource().getLogin()))
                .build();
    }

    public Page<TransactionDTO> convertPageEntityToDto(Page<Transaction> entities) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Page<Transaction>, Page<TransactionDTO>>() {
            @Override
            protected void configure() {}
        });
        return modelMapper.map(entities, Page.class);
    }
}
