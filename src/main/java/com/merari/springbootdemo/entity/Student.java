package com.merari.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_table",
        uniqueConstraints = @UniqueConstraint(
                name = "emailID_unique",
                columnNames = "email_address"))
public class Student {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1,
            initialValue = 1000000
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    private Long studentID;

    private String firstName;
    private String lastName;

    @Column(name = "email_address",nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;

//    private String guardianName;
//    private String guardianEmail;
//    private String guardianNumber;
}
