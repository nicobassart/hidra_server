package hidra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties"})
public class Application {
    public static void main(String[] args) {
//    	ApplicationContext context = 
//        		new ClassPathXmlApplicationContext("resources/Spring-Module.xml");
    	System.setProperty("http.keepAlive", "false");
        SpringApplication.run(Application.class, args);
    }
}
