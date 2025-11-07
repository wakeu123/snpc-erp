package com.gaia.snpc_erp.dtos;

public record ApiResponse<T>(

        boolean success,

        String message,

        T data) {}
