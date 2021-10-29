package vn.cloud.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import third.party.hello.HelloService;

@Component
public class HelloCommandLineRunner implements CommandLineRunner {

    private final HelloService helloService;

    public HelloCommandLineRunner(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void run(String... args) throws Exception {
        String word = this.helloService.sayHello("World");
        System.out.println(word);
    }
}
