package com.company.config;

import com.company.enums.ProfileRole;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailServise customUserDetailServise;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailServise).passwordEncoder(getPasswordEncoder());
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123admin").roles("admin")
                .and().withUser("user").password("{noop}123user").roles("user");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return DigestUtils.md5Hex(String.valueOf(rawPassword));
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return rawPassword.equals(encodedPassword);
//            }
//        };
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests().
                antMatchers("/auth/**").hasRole(ProfileRole.User.name()).
//                antMatchers("/profile/**").hasRole("BANK_ROLE").
//                antMatchers("/Transaction/create/**").hasAnyRole("BANK_ROLE", "PAYMENT_ROLE").
//                antMatchers("/Transaction/getTransactionByCardId/**").hasAnyRole("BANK_ROLE", "PAYMENT_ROLE").
//                antMatchers("/Transaction/getAllTransaction/**").hasRole("admin").
//                antMatchers("/Transaction/getAllTransactionByProfileId/**").hasRole("BANK_ROLE").
        anyRequest().authenticated().and().httpBasic();

    }

}
