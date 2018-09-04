package prykhodko.learnSpring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import prykhodko.learnSpring.service.DemoService;

//The Simple Logging Facade for Java (SLF4J)
// serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.
@Slf4j
@Controller
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    //request methods

    //http://localhost:8080/shopping-list/welcome

    @GetMapping("welcome")
    public String welcome(Model model){

        //To display Hello message with the user's name
        model.addAttribute("helloMessage", demoService.getHelloMessage("Maryna")); //adding key value pair to the model
        //prefix+name+suffix
        // /WEB-INF/view/welcome.jsp

        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        //return "Welcome to this Demo applications";
        return demoService.getWelcomeMessage();


    }
}