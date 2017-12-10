package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.Login.*;



import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;


import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;


public class TestLogin extends SpringTest{
     
    Usuario usuario;

   @Test
    @Transactional @Rollback(false)
    public void LoginUsuarioDocente()  
    {   
	   Usuario usuarioMock = mock(Usuario.class);
	   Usuario usuarioMock2 = mock(Usuario.class);
	   ServicioLogin serviciologinmock =  mock(ServicioLogin.class);
	   
	   when (usuarioMock2.getPassword()).thenReturn("1234");
	   when (usuarioMock2.getEmail()).thenReturn("test@test"); 
	   when (usuarioMock2.getRol()).thenReturn("docente");
	   
	 when (serviciologinmock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock2); 

	 assertThat (usuarioMock2.getRol()).isEqualTo("docente");	

   	
          	    	    	      	         	
    }
    
   @Test
   @Transactional @Rollback(false)
   public void LoginUsuarioAlumno()  
   {   
	   Usuario usuarioMock = mock(Usuario.class);
	   Usuario usuarioMock3 = mock(Usuario.class);
	   ServicioLogin serviciologinmock =  mock(ServicioLogin.class);
	   
	   when (usuarioMock3.getPassword()).thenReturn("1234");
	   when (usuarioMock3.getEmail()).thenReturn("1"); 
	   when (usuarioMock3.getRol()).thenReturn("Alumno");
	   
	 when (serviciologinmock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock3); 

	 assertThat (usuarioMock3.getRol()).isEqualTo("Alumno");	  	
         	    	    	      	         	
   }
    
}