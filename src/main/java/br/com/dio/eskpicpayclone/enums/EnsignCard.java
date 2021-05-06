package br.com.dio.eskpicpayclone.enums;

public enum EnsignCard {

    VISA("Visa"), MASTERCARD("Master Card"), ELO("Elo");

    private String description;

    EnsignCard(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
