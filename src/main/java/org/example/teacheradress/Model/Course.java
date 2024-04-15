package org.example.teacheradress.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
@ManyToOne
@JsonIgnore
@JoinColumn(name = "teacher_id",referencedColumnName = "id")
private Teacher teacher;

@ManyToMany
@JsonIgnore
private Set<Student> students;
}
