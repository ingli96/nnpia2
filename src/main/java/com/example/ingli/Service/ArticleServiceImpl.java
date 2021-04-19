package com.example.ingli.Service;

import com.example.ingli.Controller.model.Article;
import com.example.ingli.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article create(Article object) {
        return articleRepository.save(object);
    }

    @Override
    public Article update(Article object) {
        return articleRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }

}
