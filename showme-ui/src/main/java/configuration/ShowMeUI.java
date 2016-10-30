package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "${scan.packages}")
public class ShowMeUI {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShowMeUI.class, args);
    }
}