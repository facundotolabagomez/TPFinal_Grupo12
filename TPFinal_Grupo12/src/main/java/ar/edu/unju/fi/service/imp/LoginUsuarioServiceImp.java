package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;

@Service("LoginUsuarioServiceImp")
public class LoginUsuarioServiceImp implements UserDetailsService {
	private static final Log LOGGER = LogFactory.getLog(LoginUsuarioServiceImp.class);
	
	@Autowired
	IUsuarioRepository iUsuario;

	@Override
	public UserDetails loadUserByUsername(String emailUser) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = iUsuario.findByEmailUserAndExisteUsuario(emailUser, true).orElseThrow(()->new UsernameNotFoundException("Usuario No Existe"));
		LOGGER.info(usuarioEncontrado);
		LOGGER.info("USUARIO ENC");		
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		tipos.add(grantedAuthority);
		
		
		UserDetails user = (UserDetails) new User(emailUser, usuarioEncontrado.getPasswordUser(), tipos);
		return user;
	}

}
