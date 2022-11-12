package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.User;
import tacos.data.UserRepository;

//password encryption
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return userName -> {
            User user = userRepo.findByUsername(userName);
            if (user != null) return user;

            throw new UsernameNotFoundException("User '" + userName + " 'not found");
        };
    }

}
