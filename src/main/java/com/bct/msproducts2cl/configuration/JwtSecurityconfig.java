package com.bct.msproducts2cl.configuration;

import com.bct.msproducts2cl.security.JwtAuthenticationEntryPoint;
import com.bct.msproducts2cl.security.JwtAuthenticationProvider;
import com.bct.msproducts2cl.security.JwtAuthenticationTokenFilter;
import com.bct.msproducts2cl.security.JwtSuccesHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityconfig extends WebSecurityConfigurerAdapter {

    private JwtAuthenticationProvider autheticationProvider;
    private JwtAuthenticationEntryPoint entryPoint;

    public JwtSecurityconfig(JwtAuthenticationProvider autheticationProvider, JwtAuthenticationEntryPoint entryPoint) {
        this.autheticationProvider = autheticationProvider;
        this.entryPoint = entryPoint;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(autheticationProvider));
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccesHandler());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("**/rest/**")
                .authenticated()
                .and().authorizeRequests().antMatchers("**/h2-console/**").permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().disable();

        http.headers().cacheControl();



    }
}
