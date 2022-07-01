package ar.edu.unju.fi;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ar.edu.unju.fi.service.imp.LoginUsuarioServiceImp;

@Configuration
public class WebSecurityConfiguration{
	
	@Autowired
	private AutenticacionSuccessHandler autenticacion;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**", "/assets/**",
			"/webjars/**" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/login")
				.permitAll().antMatchers("/", "/empleos/inicio", "/usuario/registro", "/usuario/guardar", "/provincia/guardar", "/provincia/nuevo_prov","/provincia/lista_prov").permitAll()
				.antMatchers(resources).permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/usuario/login")
				.permitAll()
				.defaultSuccessUrl("/ciudadano/lista_ciud")
				.successHandler(autenticacion)
				.failureUrl("/usuario/login?error=true")
				.usernameParameter("emailUser")
				.passwordParameter("passwordUser")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/empleos/inicio");
		

		http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}

	@Autowired
	LoginUsuarioServiceImp userDetailsService;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
