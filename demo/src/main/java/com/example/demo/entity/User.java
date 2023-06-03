package com.example.demo.entity;

import com.example.demo.validator.annotation.ValidUsername;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",length = 50,nullable = false,unique = true)
    @NotBlank(message = "user is required")
    @Size(max = 50,message = "must be less 50 characters")
    @ValidUsername
    private String username;

    @Column(name = "password",length = 255,nullable = false)
    @NotBlank(message = "password required")
    private String password;

    @Column(name = "email",length = 50)
    @Size(max = 50,message = "less 50 character")
    @Email(message = "email should be valid")
    private String email;

    @Column(name = "name",length = 50, nullable = false)
    @Size(max = 50,message = "less 50 name character")
    @NotBlank(message = "name is required")
    private String name;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();





}
