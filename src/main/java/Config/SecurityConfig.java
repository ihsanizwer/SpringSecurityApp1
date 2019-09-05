package Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import java.io.IOException;


@Configuration
@EnableWebSecurity
@ImportResource({"classpath:webSecurityConfig.xml"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    PasswordEncoder pf = new SCryptPasswordEncoder();

    private AuthenticationFailureHandler aFH = new AuthenticationFailureHandler() {
        public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        }
    };

    private LogoutSuccessHandler lSH = new LogoutSuccessHandler() {
        public void onLogoutSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        }
    };

    @Override
    protected void configure(final AuthenticationManagerBuilder authManB) throws Exception{
        authManB.inMemoryAuthentication()
            .withUser("l1_user").password(pf.encode("1ntern@SM")).roles("USER")
            .and()
            .withUser("app_admin").password(pf.encode("who'sTheB0ss")).roles("ADMIN");
    }

@Override
    protected void configure(final HttpSecurity htsec) throws Exception{
        htsec
                //.csrf().disable() Since this is commented we have CSRF enabled now :)
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/annonymous*").anonymous()
                .antMatchers("/signin*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/signin.jsp")
                .loginProcessingUrl("/signingin")
                .defaultSuccessUrl("index.jsp", true)
                .failureHandler(aFH)
                .and()
                .logout()
                .logoutUrl("/signing_out")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(lSH);
    }

}
