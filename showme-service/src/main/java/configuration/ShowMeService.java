package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "${scan.packages}")
@EntityScan("domain")
@ImportResource("my-jpa-config.xml")
public class ShowMeService {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShowMeService.class, args);
    }
}
