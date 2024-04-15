package org.example.teacheradress.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the name cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotNull(message = "the age cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "the major cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String major;


@ManyToMany(mappedBy = "students" )
    private Set<Course> courses;

}
