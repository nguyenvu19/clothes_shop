package nguyenvu.clothes_shop.config;

import nguyenvu.clothes_shop.filter.JwtFilter;
import nguyenvu.clothes_shop.provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private CustomAuthenProvider authenticationProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }

    /**
     * /admin/save : ADMIN hoặc SAVE
     * /admin/delete : DELETE
     * JWT
     */

//    Đầy là filter dùng để custom rule liên quan tới link hoặc
//    cấu hình của security
//    Java 8, 11 : antMatchers
//    Java 17~ : requestAntMatchers
//    CORS
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors().and().csrf().disable() //Tắt cấu hình liên quan tới tấn công CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Khai báo không sử dụng session trong project
                .and()
                .authorizeHttpRequests() // Quy định lại các rule liên quan tới chứng thực cho link được gọi
                .antMatchers("/signin","/signup", "/file/**","/category/**","/product/**","/blog/**","/tag/**","/checkout/**").permitAll()
                .anyRequest().authenticated() //Tất cả các link còn lại đều phải chứng thực
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}