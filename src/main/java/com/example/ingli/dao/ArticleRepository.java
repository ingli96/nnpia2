package com.example.ingli.dao;

import com.example.ingli.Controller.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
