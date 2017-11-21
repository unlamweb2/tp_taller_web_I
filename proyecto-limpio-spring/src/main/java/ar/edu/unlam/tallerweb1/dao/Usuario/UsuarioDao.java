package ar.edu.unlam.tallerweb1.dao.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	public void grabarUsuario(Usuario usuario);
	public Usuario UsuarioporId(long idUsuario);
	//public ArrayList<Curso> consultarCursosAlumno(Long id);
}
