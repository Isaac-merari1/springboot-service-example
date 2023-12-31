package com.merari.springbootdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Department {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    private Long departmentID;
    @NotBlank(message = "Please add department name ")
//    @Length(max = 20, min = 1)
//    @Size(max = 10,min = 0) @Email
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
