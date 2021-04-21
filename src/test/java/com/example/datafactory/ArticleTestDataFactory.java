package com.example.datafactory;

import com.example.Controller.model.Article;
import com.example.Controller.model.User;
import com.example.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.example")
public class ArticleTestDataFactory {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserTestDataFactory userTestDataFactory;


    public void saveArticleWithAuthor(Article article) {
        User user = userTestDataFactory.saveUser();
        article.setAuthor(user);
        articleRepository.save(article);
    }


}
