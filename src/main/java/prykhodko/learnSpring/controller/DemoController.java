///////////////////////////////////////////////////////////////////
// The Shopping List app is a simple application that will manage
// the items in the shopping list.
//
// The Shopping List will be represented by a simple class with the
// fields: item, details, amount, price.
//
// The main requirements is performing CRUD operations
// (Create, Read, Update, Delete).
//
// There are 4 pages to interact with the user:
// - A page to check all the Shopping List items
// - A page to check a single Shopping List item including its details
// - A page to update a single Shopping List item
// - A page to create a single item with details
//
// The is also opportunity to delete a single item from the Shopping List.
//
// There is a Welcome page with a welcome message and a link to the Shopping List items.
// To make it simple, all data will be stored in a memory.
///////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
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

    //user=Maryna is a query parameter that we are passing to the controller method through the browser
    //http://localhost:8080/shopping-list/welcome?user=Maryna

    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam String familyName, Model model){

        //To display Hello message with the user's name
        //http://localhost:8080/shopping-list/welcome?user=Maryna&familyName=Pryx //multiply query param
        model.addAttribute("helloMessage", demoService.getHelloMessage(user)); //adding key value pair to the model
        model.addAttribute("familyName", familyName);
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
