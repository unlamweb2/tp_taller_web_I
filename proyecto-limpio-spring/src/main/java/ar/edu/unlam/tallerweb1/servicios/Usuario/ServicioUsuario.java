package ar.edu.unlam.tallerweb1.servicios.Usuario;


import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	public void grabarUsuario(Usuario usuario);
	public void actualizarUsuario(Usuario usuario);
	//public ArrayList<Curso> consultarCursosAlumno(Long id);
	public Usuario UsuarioporId(long idUsuario);
}
