package br.com.dio.eskpicpayclone.resources;

import br.com.dio.eskpicpayclone.dto.UserDTO;
import br.com.dio.eskpicpayclone.resources.swagger.IUserResource;
import br.com.dio.eskpicpayclone.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource extends ResourceBase<UserDTO> implements IUserResource {

    @Autowired
    private IUserService userService;

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> find(@PathVariable String login) {
        UserDTO userDTO = userService.consult(login);
        return responseSuccessWithItem(userDTO);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<UserDTO>> list(@RequestParam String login) {
        List<UserDTO> userDTOList = userService.list(login);
        return responseItemList(userDTOList);
    }

    @GetMapping("/{login}/balance")
    public ResponseEntity<UserDTO> consultBalance(@PathVariable String login) {
        UserDTO userDTO = userService.consult(login);
        return responseSuccessWithItem(userDTO);
    }
}
