package vn.edu.iuh.fit.se.thubonggiareapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class ThuBongGiaReRestApisSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThuBongGiaReRestApisSpringBootApplication.class, args);
    }
    

}
