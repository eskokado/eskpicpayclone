package br.com.dio.eskpicpayclone.converters;

import br.com.dio.eskpicpayclone.dto.UserDTO;
import br.com.dio.eskpicpayclone.models.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ConverterUser extends ConverterBase<User, UserDTO> {
    @Override
    public UserDTO convertEntityToDto(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {}
        });
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User convertDtoToEntity(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {}
        });
        return modelMapper.map(dto, User.class);
    }
}
