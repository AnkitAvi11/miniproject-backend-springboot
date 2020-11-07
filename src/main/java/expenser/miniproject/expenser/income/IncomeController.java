package expenser.miniproject.expenser.income;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomeController {
    @RequestMapping("/")
    public String getHome() {
        return "hello world!";
    }
}
