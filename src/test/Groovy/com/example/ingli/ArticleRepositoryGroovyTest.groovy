package com.example.ingli;

import com.example.ingli.Controller.model.Article;
import com.example.ingli.dao.ArticleRepository
import com.example.ingli.dao.UserRepository;
import com.example.ingli.datafactory.ArticleTestDataFactory;
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
    private UserRepository userRepository;

    @Autowired
    private ArticleTestDataFactory articleTestDataFactory;

    @Test
    void saveArticleTest() {
        Article article = new Article(title: "Test Title");
        articleTestDataFactory.saveArticleGroovyTest(article);

        Article articleInDb = articleRepository.findById(article.getId()).get();
        Assertions.assertTrue(articleInDb.getText() == "Test text")
        Assertions.assertTrue(articleInDb.getTitle() == "Test Title")
    }

}
