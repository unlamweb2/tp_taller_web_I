package ar.edu.unlam.tallerweb1.servicios.Usuario;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("ServicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{

	@Inject
	private UsuarioDao usuarioDao;
	
	@Transactional
	public void grabarUsuario(Usuario usuario){
		usuarioDao.grabarUsuario(usuario);
	}
	
	@Transactional
	public void actualizarUsuario(Usuario usuario){
		usuarioDao.actualizarUsuario(usuario);
	}
	
	/*public ArrayList<Curso> consultarCursosAlumno(Long id){
	
	return usuarioDao.consultarCursosAlumno(id);
	}*/
	
	
	
	public Usuario UsuarioporId(long idUsuario){
		return usuarioDao.UsuarioporId(idUsuario);
	}
}

