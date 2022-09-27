package demo.deploy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"demo","com.jinritemai"})
@MapperScan("demo.dal.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        initProfiles();
        defaultProfile();
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.run(args);
    }

    private static void defaultProfile() {
        String activeProfile = System.getProperty("spring.profiles.active");
        if (!StringUtils.hasText(activeProfile)) {
            System.setProperty("spring.profiles.active", "dev");
        }
    }

    private static void initProfiles() {
        String env = System.getenv("SPRING_PROFILES_ACTIVE");
        Optional.ofNullable(env).ifPresent((e) -> {
            System.setProperty("spring.profiles.active", env);
        });
    }
}
