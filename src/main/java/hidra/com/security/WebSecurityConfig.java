package hidra.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsUtils;

import hidra.com.session.WebSecurityCorsFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	public static final String REMEMBER_ME_KEY = "rememberme_key";
	/*
	 * @Autowired private RestUnauthorizedEntryPoint
	 * restAuthenticationEntryPoint;
	 */
	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
  protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.anonymous();
		
		
		
		/*	  *** 
 * 			Login normal, valida /login y el resto le pone una capa de seguridad.
	  http
		.httpBasic().and()
		.logout().and().formLogin().loginPage("/login").successHandler(authenticationSuccessHandler).and()
      .authorizeRequests()
      //.requestMatchers(CorsUtils::isCorsRequest).permitAll()
      .anyRequest().authenticated()
      .and().httpBasic().and()
		.csrf()
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	      .and().addFilterBefore(new WebSecurityCorsFilter(), ChannelProcessingFilter.class);
*/
	  
	  
/*		http
			.httpBasic().and()
			.logout().and().formLogin().loginPage("/login").and()
			.authorizeRequests(	)
				.antMatchers("/index.html", "/home.html",  "/").permitAll()
				.anyRequest().authenticated();*/
/*		.and()
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());*/
		
		http.csrf().disable();
		// @formatter:on
/*    http.authorizeRequests().anyRequest().fullyAuthenticated().and().
    httpBasic().and().
    csrf().disable();*/
    
   /* AuthenticationEntryPoint autenticatioEntry = new AuthenticationEntryPoint() {
		
		@Override
		public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
				throws IOException, ServletException {

			
		}
	};
	AuthenticationEntryPoint restAuthenticationEntryPoint = new AuthenticationEntryPoint() {
		
		@Override
		public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
				throws IOException, ServletException {
			return;
			
		}
	};
	
	AccessDeniedHandler restAccessDeniedHandler= new AccessDeniedHandler() {
		
		@Override
		public void handle(HttpServletRequest arg0, HttpServletResponse arg1, AccessDeniedException arg2)
				throws IOException, ServletException {
			return ;
			
		}
	};
	
	
	
	
    AuthenticationSuccessHandler restAuthenticationSuccessHandler= new AuthenticationSuccessHandler() {
		
		@Override
		public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
				throws IOException, ServletException {
			return;
			
		}
	};
	RememberMeServices rememberMeServices = new RememberMeServices() {
		
		@Override
		public void loginSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) {
			// TODO Auto-generated method stub
			return;
		}
		
		@Override
		public void loginFail(HttpServletRequest arg0, HttpServletResponse arg1) {
			// TODO Auto-generated method stub
			return;
		}
		
		@Override
		public Authentication autoLogin(HttpServletRequest arg0, HttpServletResponse arg1) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	
	http
    .headers().disable()
    .csrf().disable()
    .authorizeRequests()
     .antMatchers("/v2/api-docs").hasAnyAuthority("admin")
     .antMatchers("/users/**").hasAnyAuthority("admin")
     .anyRequest().authenticated()
     .and()
    .exceptionHandling()
     .authenticationEntryPoint(restAuthenticationEntryPoint)
     .accessDeniedHandler(restAccessDeniedHandler)
     .and()
    .formLogin()
     .loginProcessingUrl("/authenticate")
     .successHandler(restAuthenticationSuccessHandler)
    // .failureHandler(restAuthenticationFailureHandler)
     .usernameParameter("username")
     .passwordParameter("password")
     .permitAll()
     .and()
    .logout()
     .logoutUrl("/logout")
     .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
     .deleteCookies("JSESSIONID")
     .permitAll()
     .and()
    .rememberMe()
     .rememberMeServices(rememberMeServices)
     .key(REMEMBER_ME_KEY)
     .and();*/
  }

}