package com.example.ingli.datafactory;

import com.example.ingli.Controller.model.Article;
import com.example.ingli.Controller.model.User;
import com.example.ingli.dao.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleTestDataFactory {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserTestDataFactory userTestDataFactory;

    @Test
    public void saveArticleTest() {
        Article article = new Article();
        article.setText("text");
        article.setTitle("Title");
        articleRepository.save(article);
    }

    @Test
    public void saveArticleGroovyTest(Article article) {
        if (article.getText() == null) article.setText("Test text");
        if (article.getTitle() == null) article.setTitle("Test title");
        User user = new User();
        user.setFirstName("Test Name");
        userTestDataFactory.saveUserGroovyTest(user);
        article.setAuthor(user);
        articleRepository.save(article);
    }

}
