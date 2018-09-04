package prykhodko.learnSpring.service;

import org.springframework.stereotype.Service;

@Service
//Service Layer of app holds the business logic and calculations
//We will get the message from DemoServiceImpl with the help of
// Service's logic that will retrieve the messages
public class DemoServiceImplementation implements DemoService {

    @Override
    public String getHelloMessage(String user) {
        return "Hello" + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to TestDemoPage";
    }
}
