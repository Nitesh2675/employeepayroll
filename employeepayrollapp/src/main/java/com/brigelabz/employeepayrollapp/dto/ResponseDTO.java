package com.brigelabz.employeepayrollapp.dto;


import lombok.*;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    // Getters and setters
}

