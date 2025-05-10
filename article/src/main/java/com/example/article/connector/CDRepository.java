package com.example.article.connector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.article.component.structure.CD;

@Repository
public interface CDRepository extends JpaRepository<CD, Integer> {
    // Du kannst hier auch spezielle Abfragen hinzufügen, falls erforderlich
}
