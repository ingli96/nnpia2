package com.example.testGroovy


import com.example.Controller.model.Article;
import com.example.dao.ArticleRepository;
import com.example.datafactory.ArticleTestDataFactory
import com.example.datafactory.Creator
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
@Import(Creator.class)
class ArticleRepositoryGroovyTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private Creator creator;

    @Test
    void saveArticleTest() {

        Article article = new Article(title: "Test Title");
        creator.save(article);

        Article articleInDb = articleRepository.findById(article.getId()).get();
        println(articleInDb.getTitle())
        Assertions.assertTrue(articleInDb.getTitle() == "Test Title")

        println(articleInDb.getTitle())
        println(articleInDb.getAuthor().getFirstName())
        Assertions.assertTrue(articleInDb.getAuthor().firstName == "Test firstName")
    }
}
