package com.student.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "gender")
    public String gender;

    @Column(name = "birthday")
    public Date birthday;

    @Column(name = "email")
    public String email;

    @Column(name = "mobile_phone")
    public String mobilePhone;

    @Column(name = "is_active")
    public Boolean isActive;

    @Column(name = "created_at")
    public Date createdAt;
}
