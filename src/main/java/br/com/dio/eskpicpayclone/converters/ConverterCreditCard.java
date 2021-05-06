package br.com.dio.eskpicpayclone.converters;

import br.com.dio.eskpicpayclone.dto.CreditCardDTO;
import br.com.dio.eskpicpayclone.models.CreditCard;
import br.com.dio.eskpicpayclone.services.IUserService;
import br.com.dio.eskpicpayclone.utils.CreditCardUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterCreditCard extends ConverterBase<CreditCard, CreditCardDTO>{
    @Autowired
    private IUserService userService;

    @Override
    public CreditCardDTO convertEntityToDto(CreditCard entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CreditCard, CreditCardDTO>() {
            @Override
            protected void configure() {}
        });
        return modelMapper.map(entity, CreditCardDTO.class);
    }

    @Override
    public CreditCard convertDtoToEntity(CreditCardDTO dto) {
        return CreditCard.builder()
                .ensignCard(dto.getEnsignCard())
                .number(CreditCardUtil.mask(dto.getNumber()))
                .numberToken(dto.getNumberToken())
                .user(userService.findEntity(dto.getUser().getLogin()))
                .build();
    }
}
