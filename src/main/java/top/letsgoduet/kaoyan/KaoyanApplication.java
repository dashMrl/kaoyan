package top.letsgoduet.kaoyan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import top.letsgoduet.kaoyan.model.User;
import top.letsgoduet.kaoyan.repo.UserRepo;

@SpringBootApplication
public class KaoyanApplication {
    @Value("${spring.admin.uname}")
    private  String uname;
    @Value("${spring.admin.pwd}")
    private  String pwd;
    @Value("${spring.admin.phone}")
    private  String phone;
    private static final Logger LOGGER = LoggerFactory.getLogger(KaoyanApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(KaoyanApplication.class, args);
    }

    @Bean
    public  CommandLineRunner createAdmin(UserRepo userRepo) {
        return (args)->{
            User u = new User();
            u.uname = uname;
            u.pwd = pwd;
            u.phone = phone;
            u.role = User.ROLE_MANAGER;
            if (userRepo.findByPhone(phone) == null) {
                userRepo.save(u);
            }else {
                LOGGER.info("Admin already exists,no need to recreate");
            }
            uname=null;
            pwd = null;
            phone = null;
        };
    }
}
