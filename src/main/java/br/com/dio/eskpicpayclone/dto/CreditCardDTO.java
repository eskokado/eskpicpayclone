package br.com.dio.eskpicpayclone.dto;

import br.com.dio.eskpicpayclone.enums.EnsignCard;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreditCardDTO {

    @NotBlank
    private EnsignCard ensignCard;

    @NotBlank
    private String securityCode;

    @NotBlank
    private String expirationDate;

    @NotBlank
    private String titleName;

    private String number;

    private String numberToken;

    @NotNull
    private UserDTO user;

    private Boolean isSave = false;
}
