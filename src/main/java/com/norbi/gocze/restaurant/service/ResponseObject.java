package com.norbi.gocze.restaurant.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Builder
public class ResponseObject {
    private String message;
}
