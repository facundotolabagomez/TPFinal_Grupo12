package ar.edu.unju.fi.service.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import java.util.Optional;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

@Service("UsuarioServiceImpSql")
public class UsuarioServiceImpSql implements IUsuarioService {
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioServiceImpSql.class);
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public void crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if (usuarioRepository.findByEmailUserAndExisteUsuario(usuario.getEmailUser(), true)!=null) {
			LOGGER.error("EL USUARIO YA EXISTE");
		}else {
			LOGGER.error("ENCRIPTANDO PASS");
			String pw = usuario.getPasswordUser();
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
			usuario.setPasswordUser(bCryptPasswordEncoder.encode(pw));
			usuarioRepository.save(usuario);}
		
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if (usuarioRepository.save(usuario)!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void eliminarUsuario(long usuario_id) {
		// TODO Auto-generated method stub
		Optional <Usuario> usuario_elim = usuarioRepository.findById(usuario_id);
		Usuario usu = usuario_elim.get();
		usu.setExisteUsuario(false);
		usuarioRepository.save(usu);
		//usuarioRepository.deleteById(usuario_id);

	}

	@Override
	public Usuario buscarUsuario(String emailUser, boolean existeUsuario)  {
		// TODO Auto-generated method stub
		Optional <Usuario> usuario_busc = usuarioRepository.findByEmailUserAndExisteUsuario(emailUser, existeUsuario);
		Usuario usu = usuario_busc.get();
		return usu;
	}

	@Override
	public Usuario encontrarUsuario(String emailUser, boolean existeUsuario) throws Exception {
		return usuarioRepository.findByEmailUserAndExisteUsuario(emailUser, existeUsuario).orElseThrow(()-> new Exception("El Usuario no Existe"));
	}
	
	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return new Usuario();
	}

}
