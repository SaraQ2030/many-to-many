package org.example.teacheradress.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    @Column (columnDefinition = "varchar(10) not null")
    private String name ;
    @NotNull(message = "age cannot be empty")
    @Column (columnDefinition = "int not null")
    private Integer age;
    @Email
    @NotEmpty(message = "email cannot be empty")
    @Column (columnDefinition = "varchar(20) not null")
    private String email;
    @NotNull(message = "salary cannot be empty")
    @Min(value = 5000 ,message = "less value enterd 5000")
    @Column (columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

@OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set <Course>  courses;


}
