package com.github.princeflaco.template.scf.ct.adapter.controller.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Data
public class ErrorDTO {
    private String id;
    private LocalDateTime timestamp;
    private Object details;

    public ErrorDTO(Object details) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now(ZoneOffset.UTC);
        this.details = details;
    }
}
