package org.example.teacheradress.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "area cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "street cannot be empty")
    @Column (columnDefinition = "varchar(20) not null")
    private String street;
    @NotNull(message = "building number cannot be empty")
    @Column (columnDefinition = "int not null")
    private Integer buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
