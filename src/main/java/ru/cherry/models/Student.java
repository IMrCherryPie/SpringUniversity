package ru.cherry.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Student {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    int id;

    @Column(name = "NAME")
    @NotEmpty
    @NonNull
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    String name;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @NonNull
    @Email(message = "Email should be valid")
    private String email;

}
