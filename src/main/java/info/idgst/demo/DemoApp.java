package info.idgst.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main Application controller.
 *
 * @author Aliaksei Bahdanau
 */
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = "info.idgst.*")
public class DemoApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}
