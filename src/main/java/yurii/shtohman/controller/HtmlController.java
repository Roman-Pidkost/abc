package yurii.shtohman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
    @RequestMapping("/about")
    public String about() {
        return "about_us.html";
    }
}
