package com.example.article.connector;

import com.example.article.component.structure.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {}

