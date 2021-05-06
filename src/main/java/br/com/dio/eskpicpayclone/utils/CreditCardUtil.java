package br.com.dio.eskpicpayclone.utils;

public class CreditCardUtil {
    public static String mask(String numberCard) {
        return numberCard.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1XXXXXXXX$3");
    }
}
