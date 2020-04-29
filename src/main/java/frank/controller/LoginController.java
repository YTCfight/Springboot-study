package frank.controller;


import frank.model.Duck;
import frank.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
// ("/user")可以加或者不加
@RequestMapping("/user")
public class LoginController {

    // 设置为可以使用 POST 和 GET 方法请求
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(User user, HttpServletRequest request) {
        System.out.printf("username = %s, password = %s\n", user.getUsername(), user.getPassword());
        // 校验用户名和密码,校验通过，设置用户身份信息到 session
        if ("abc".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            // 默认是 true,如果获取不到 session，就创建
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // 登录成功，返回首页
            return "redirect:/user/login7";
        } else if ("a".equals(user.getUsername())) {
            throw new RuntimeException("用户名为 a，出错了");
        } else {
            return "/login.html";
        }
    }

    @RequestMapping(value = "/login_0", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Duck login_0(User user) {
        System.out.printf("username = %s, password = %s\n", user.getUsername(), user.getPassword());
        return new Duck("LadyGaga", 2);
    }

    // 默认是 GET 方法
    @RequestMapping("/login2")
    public String login2(HttpServletRequest request, HttpServletResponse response) {
        return "/login.html";
    }

    @RequestMapping("login3")
    public String login3() {
        // 先做一部分业务操作
        // 重定向
        return "redirect:/user/login";
    }

    @RequestMapping("login4")
    public String login4() {
        // 先做一部分业务操作
        // 转发
        return "forward:/user/login";
    }

    // 访问路径：http://localhost:8080/user/111/login5
    @RequestMapping(value = "/{id}/login5", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Duck login5(@PathVariable("id") Integer id) {
        System.out.printf("id=%s\n", id);
        return new Duck("LadyGaga", 2);
    }


    @RequestMapping(value = "/login6", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Duck login6(@RequestBody User user) {
        System.out.printf("username = %s, password = %s\n", user.getUsername(), user.getPassword());
        return new Duck("LadyGaga", 2);
    }


    @RequestMapping("/login7")
    // 返回 freemarker 动态网页模板生成的网页内容
    public String login7(Model model) {
        model.addAttribute("duck", new Duck("LadyGaga", 2020));
        return "/index";
    }

}
