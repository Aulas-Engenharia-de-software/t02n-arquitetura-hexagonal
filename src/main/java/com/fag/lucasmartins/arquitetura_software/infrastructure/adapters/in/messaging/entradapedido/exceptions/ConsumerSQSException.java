package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradapedido.exceptions;

public class ConsumerSQSException extends RuntimeException {

    public ConsumerSQSException() {
        super();
    }

    public ConsumerSQSException(String message) {
        super(message);
    }

    public ConsumerSQSException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsumerSQSException(Throwable cause) {
        super(cause);
    }
}