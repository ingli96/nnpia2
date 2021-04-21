package com.example.Controller;

import com.example.Service.ArticleService;
import com.example.Service.UserService;
import com.example.Controller.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @GetMapping(value = "articles")
    public String getAll(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "article-list";
    }

    @GetMapping("/article-create")
    public String createArticleForm(Article article){
        return "article-create";
    }

    @PostMapping("/article-create")
    public String createUser(Article article){
        articleService.create(article);
        return "redirect:/articles";
    }



}
