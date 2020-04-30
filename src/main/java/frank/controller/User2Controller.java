package frank.controller;

import frank.model.Article;
import frank.model.User;
import frank.service.ArticleService;
import frank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user2")
public class User2Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/insert")
    @ResponseBody
    private User insert(User user) {
        int num = userService.insert(user);
        return user;
    }

    @RequestMapping("/query")
    @ResponseBody
    public User queryById(Long id) {
        return userService.queryById(id);
    }

    @RequestMapping("/query/article")
    public String queryArticleById(Long id, Model model) {
        Article article = articleService.queryArticleById(id);
        model.addAttribute("article", article);
        return "/info";
    }
}
