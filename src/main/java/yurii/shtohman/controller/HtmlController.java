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

    @RequestMapping("/employee")
    public String employee() {
        return "find_employee.html";
    }

    @RequestMapping("/work")
    public String work() {
        return "find_work.html";
    }
}
