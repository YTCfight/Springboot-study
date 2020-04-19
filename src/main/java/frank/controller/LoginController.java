package frank.controller;


import frank.model.Duck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public Duck login(String username, String password) {
        System.out.printf("username = %s, password = %s\n", username, password);
        return new Duck("LadyGaga", 2);
    }

    @RequestMapping("/login2")
    public String login2() {
        return "login.html";
    }
}
