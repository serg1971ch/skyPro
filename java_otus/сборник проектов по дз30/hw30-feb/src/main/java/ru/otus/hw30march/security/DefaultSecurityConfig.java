package ru.otus.hw30march.security;


import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
@AllArgsConstructor
@Configuration
public class DefaultSecurityConfig {

    @Bean
    @ConditionalOnProperty(prefix = "app.security", name = "type", havingValue = "inMemory")
    public AuthenticationManager inMemoryAuthenticationManager(HttpSecurity http, UserDetailsService inMemoryDetailService) throws Exception {
        var authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.userDetailsService(inMemoryDetailService);
        return authManagerBuilder.build();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception{
        http
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/books/**").hasAnyRole("ADMIN")
                            .requestMatchers("/exchange/**").permitAll();

                })
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement((httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .authenticationManager(authenticationManager);

//                .csrf(csrf -> {
//                    csrf.csrfTokenRequestHandler(csrfRequestHandler);
//                    csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
//                })
//                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        String generatedPassword = "1234";
        return new InMemoryUserDetailsManager(User.withUsername("user")
                .password(generatedPassword).roles("USER").build());
    }


    @Bean
    @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
    DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(ApplicationEventPublisher delegate) {
        return new DefaultAuthenticationEventPublisher(delegate);
    }

    @Bean
    PasswordEncoder defaultPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }
}
