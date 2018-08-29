package prykhodko.learnSpring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {


    //http://localhost:8080/shopping-list/welcome
    //prefix+name+suffix
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
