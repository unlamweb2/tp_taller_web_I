package ar.edu.unlam.tallerweb1.servicios.Alumno;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Alumno.AlumnoDao;
import ar.edu.unlam.tallerweb1.dao.Usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;



@Service("ServicioAlumno")
@Transactional
public class ServicioAlumnoImpl implements ServicioAlumno{

	@Inject
	private AlumnoDao alumnoDao;
	
	@Transactional
	public void anotarAlumno(Usuario id2){
		alumnoDao.anotarAlumno(id2);
	}
}