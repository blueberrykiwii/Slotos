package com.example.article.connector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.article.component.structure.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Du kannst hier auch benutzerdefinierte Abfragen hinzufügen, falls erforderlich
}
