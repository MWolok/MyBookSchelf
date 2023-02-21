package com.myBookSchelf.BookSchelf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private  String author;
}
