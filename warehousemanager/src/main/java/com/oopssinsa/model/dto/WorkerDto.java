package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkerDto {
    private String id;
    private String name;
    private char status;
}
