package newPackage;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@RestController
public class SpringRestController {

    @GetMapping("/connect")
    public void connect(){
        System.out.println("Spring Boot Application Connected.");
    }

    @GetMapping("/")
    String index() {
        return "Hello world! Welcome to Donald's page.";
    }
}