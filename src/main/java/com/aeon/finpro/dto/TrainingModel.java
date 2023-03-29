package com.aeon.finpro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingModel {
    private UUID id;
    private String topic;
    private String facilitator;
}
