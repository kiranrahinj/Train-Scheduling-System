package com.org.DTO;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainDto {
    private int number;
    private String name;

    private List<String> stations;
}

