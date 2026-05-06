package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.messaging.saidaestoque.exceptions;

public class PublisherSQSException extends RuntimeException {

    public PublisherSQSException(String message, Exception cause) {
        super(message, cause);
    }
}
