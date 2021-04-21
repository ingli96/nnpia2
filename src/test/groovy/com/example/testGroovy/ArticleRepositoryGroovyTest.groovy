package com.example.testGroovy


import com.example.Controller.model.Article;
import com.example.dao.ArticleRepository;
import com.example.datafactory.ArticleTestDataFactory
import org.junit.Test
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ArticleTestDataFactory.class)
class ArticleRepositoryGroovyTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    ArticleTestDataFactory articleTestDataFactory;

    @Test
    void saveArticleTest() {

        Article article = new Article(title: "Test Title");
        articleTestDataFactory.saveArticleWithAuthor(article);

        Article articleInDb = articleRepository.findById(article.getId()).get();
        Assertions.assertTrue(articleInDb.getTitle() == "Test Title")
    }
}
