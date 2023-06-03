package com.example.demo.entity;
import com.example.demo.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import javax.validation.Valid;

@Data
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author",length = 50)
    private String author;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValidUserId
    private User user;

}