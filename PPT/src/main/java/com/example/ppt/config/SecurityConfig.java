package com.example.ppt.config;

import com.example.ppt.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/register/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and()
                .httpBasic();
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
//        configuration.setAllowedOrigins(Collections.singletonList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "OPTIONS"));
//        configuration.addAllowedMethod(HttpMethod.TRACE);
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//    @Bean
//    public AuthenticationEntryPoint entryPoint() {
//        return new BasicAuthenticationEntryPoint() {
//            @Override
//            public void commence(HttpServletRequest request, HttpServletResponse response,
//                                 AuthenticationException authException) throws IOException {
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                    response.setContentType("application/json");
//                    jsonObject.put("message", authException.getMessage());
//                    response.getWriter()
//                            .println(jsonObject);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void afterPropertiesSet() {
//                setRealmName("Auth");
//                super.afterPropertiesSet();
//            }
//        };
//    }

}