package com.afroalko.employee.security;

import com.afroalko.employee.manager.EmployeeManager;
import com.afroalko.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private EmployeeManager employeeManager;

    @Autowired
    public SecurityConfiguration(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        Employee employeeAdmin = employeeManager.findyByName("Tomek");

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(employeeAdmin.getName())
                .password(employeeAdmin.getPassword())
                .roles(employeeAdmin.getRole())
                .build();

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user1);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/vote","/").authenticated()
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}
