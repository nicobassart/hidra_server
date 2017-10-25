package hidra.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import hidra.com.dao.UsuarioDao;
import hidra.com.model.Usuario;

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				// Valida contra la base de datos.
				Usuario usuario = usuarioDao.findByUsuario(username);
				if (usuario != null) {
					return new User(usuario.getUsuario(), usuario.getUltimoPassword(), true, true, true, true,
							AuthorityUtils.createAuthorityList("USER"));
				} else {
					throw new UsernameNotFoundException("could not find the user '" + username + "'");
				}

				/*
				 * private Collection<? extends GrantedAuthority> getGrantedAuthorities(String
				 * username) { Collection<? extends GrantedAuthority> authorities; if
				 * (username.equals("John")) { authorities = asList(() -> "ROLE_ADMIN", () ->
				 * "ROLE_BASIC"); } else { authorities = asList(() -> "ROLE_BASIC"); } return
				 * authorities; }
				 */
			}

		};

	}
}
