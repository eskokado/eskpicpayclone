package br.com.dio.eskpicpayclone.exceptions;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Exception exception) {
        super(message, exception);
    }
}
