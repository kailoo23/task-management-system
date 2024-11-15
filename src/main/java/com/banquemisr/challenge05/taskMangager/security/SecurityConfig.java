//package com.banquemisr.challenge05.taskMangager.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select username, password, active from user where username=?");
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select username, role from roles where username=?");
//
//        // Optional: Remove the "ROLE_" prefix requirement if roles in DB don't include it
//        jdbcUserDetailsManager.setRolePrefix("");
//
//        System.out.println("UserDetailsManager configured with datasource: " + dataSource);
//
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/bm/tm/api/tasks").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/bm/tm/api/tasks").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/bm/tm/api/tasks").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/bm/tm/api/tasks/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//        );
//
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//}