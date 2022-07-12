package sia.tacocloud.tacos.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.exceptions.TemplateInputException;

@Slf4j
@Controller
@RequestMapping("/error")
public class MyErrorController implements ErrorController {

    @GetMapping
    public String handleAllErrors() {

        return "error";
    }

//    @GetMapping("/logon")
//    public String handleAuthError(Model model) {
//        model.addAttribute("error", true);
//        return "logon";
//    }
}
