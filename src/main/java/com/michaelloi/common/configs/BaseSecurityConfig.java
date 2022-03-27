package com.michaelloi.common.configs;

import com.michaelloi.common.constants.RequestHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import java.util.Collections;

public class BaseSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> authorizationUserDetailsService;

    @Bean
    public RequestHeaderAuthenticationFilter preAuthenticationFilter(){
        RequestHeaderAuthenticationFilter preAuthenticationFilter = new RequestHeaderAuthenticationFilter();
        preAuthenticationFilter.setPrincipalRequestHeader(RequestHeaders.channel);
        preAuthenticationFilter.setCredentialsRequestHeader(RequestHeaders.session);
        preAuthenticationFilter.setAuthenticationManager(authenticationManager());
        preAuthenticationFilter.setExceptionIfHeaderMissing(false);

        return preAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.headers().contentSecurityPolicy("script-src 'self'");
        http.antMatcher("/**")
            .addFilterAfter(preAuthenticationFilter(), RequestHeaderAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authenticationProvider()));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        PreAuthenticatedAuthenticationProvider authenticationProvider = new PreAuthenticatedAuthenticationProvider();
        authenticationProvider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
        authenticationProvider.setThrowExceptionWhenTokenRejected(false);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> userDetailsServiceWrapper(){
        return authorizationUserDetailsService;
    }
}
