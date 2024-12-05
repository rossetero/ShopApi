package org.example.Api;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Возвращает имя вашей страницы ошибки
        return "error"; // Убедитесь, что у вас есть соответствующий шаблон
    }
}