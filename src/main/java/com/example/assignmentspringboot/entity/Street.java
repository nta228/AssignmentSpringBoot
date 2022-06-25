package com.example.assignmentspringboot.entity;

import com.example.assignmentspringboot.entity.myEnum.StreetStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate foundingDate;
    private String description;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="district_id", nullable = false)
    private District district;
    @Column(updatable = false, insertable = false)
    private Integer district_id;
    @Enumerated(EnumType.ORDINAL)
    private StreetStatus status;
}
