package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;


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
	
}

