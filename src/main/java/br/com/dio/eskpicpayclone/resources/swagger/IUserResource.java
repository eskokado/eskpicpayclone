package br.com.dio.eskpicpayclone.resources.swagger;

import br.com.dio.eskpicpayclone.dto.ErrorDTO;
import br.com.dio.eskpicpayclone.dto.UserDTO;
import io.swagger.annotations.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "/users",  description = "Operações relacionadas a Usuários")
public interface IUserResource {

    @ApiOperation(value = "Consultar saldo de um usuário por login", nickname = "consultBalance", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saldo consultado com sucesso", response = UserDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping("/{login}/balance")
    public ResponseEntity<UserDTO> consultBalance(@PathVariable String login);

    @ApiOperation(value = "Consultar contatos de um usuário por login", nickname = "list", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "basicAuth") }, tags = { "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contatos encontrado com sucesso", response = UserDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrados") })
    @GetMapping("/contacts")
    public ResponseEntity<List<UserDTO>> list(@RequestParam String login);

    @ApiOperation(value = "Consultar usuário por login", nickname = "consultUsers", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "basicAuth") }, tags = { "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário encontrado com sucesso", response = UserDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> find(@PathVariable String login);


}
