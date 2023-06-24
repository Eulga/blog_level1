package sparta.sparta_spring_level_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaSpringLevel1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpringLevel1Application.class, args);
    }

}
