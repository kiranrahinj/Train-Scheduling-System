package com.org.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity(name="Train")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Train {
    @Id
    private int number;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "train_stations", joinColumns = @JoinColumn(name = "train_number"))
    private List<String> stations;
}
