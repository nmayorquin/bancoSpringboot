package com.bank.bancoDemo.exceptions;

import lombok.Data;

import java.util.UUID;

@Data
public class ErrorResponse {
    private String errorMessage;
    private UUID transactionId;
}