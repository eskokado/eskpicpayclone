package br.com.dio.eskpicpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotBlank
    private String login;

    private String password;

    private String email;

    private String fullName;

    private String cpf;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private Double balance;
}
