package de.predic8.oauth2jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off

//        auth.ldapAuthentication()
//                .userDnPatterns("uid={0},ou=People")
//				.groupSearchBase("ou=Groups")
//				.contextSource()
//					.url("ldap://localhost:8389/dc=springframework,dc=org") // Ursprünglich LDAPS auf predic8 ldap, siehe auch InitHelloWorld Zeile 23
//					.and()
//				.passwordCompare()
//                    .passwordEncoder(null)
//        ;


	auth.inMemoryAuthentication()
	  .withUser("tobias").password("{noop}123").roles("USER").and()
	  .withUser("till").password("{noop}123").roles("ADMIN").and()
	  .withUser("thomas").password("{noop}123").roles("USER");

    }// @formatter:on

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
		http.authorizeRequests()
                .antMatchers("/.well-known/openid-configuration").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/oauth/token/revokeById/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll();
		// @formatter:on
    }
}
