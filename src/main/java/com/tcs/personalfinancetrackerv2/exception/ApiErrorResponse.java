package com.tcs.personalfinancetrackerv2.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiErrorResponse {

    private boolean success;

    private String message;

    private Map<String, String> errors;

    private LocalDateTime timestamp;

}