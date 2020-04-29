package frank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ControllerAdvice
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    // 拦截器
    // 根据 url 进行拦截，调用配置的拦截器进行处理
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 除了 /login.html 和 /user/login，其他都拦截
        // 所有的拦截器依次执行，interceptor.preHandle() -> controller.映射方法()
        // -> interceptor.postHandle()
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/error"); // 对应  LoginController 的 throw new RuntimeException("用户名为 a，出错了");
    }
}
