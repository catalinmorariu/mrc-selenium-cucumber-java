package net.metrosystems.mrc.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.user.name}")
    private String userName;

    @Value("${security.user.password}")
    private String userPassword;

    public static final String REALM_NAME = "MRC_SELENIUM_REALM";

    private final AuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(AuthenticationEntryPoint authenticationEntryPoint) {
        super();
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    public void configure(WebSecurity web)  {
        web.ignoring().antMatchers("/error*", "/.well-known/**", "/v2/api-docs", "/v3/api-docs", "/openapi.json");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/.well-known/live", "/.well-known/ready").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .realmName(REALM_NAME)
            .authenticationEntryPoint(authenticationEntryPoint);
        //.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @SuppressWarnings({"PMD.SignatureDeclareThrowsException"}) // because spring security does it
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(userName).password(passwordEncoder().encode(userPassword)).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

