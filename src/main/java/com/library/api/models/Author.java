package com.library.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private List<Book> books;
    private String name;

    @Override
    public String toString() {
        return "Author{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
