package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.Login.*;
import javassist.expr.Cast;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;


public class TestLogin extends SpringTest{
      /*
    Usuario usuario;
	    
	  //SUT subject under test
    //el test depende de usuario, servicio y http request
    //mookin tecnica para reemplazar dependencias (mok ito)
    //mocito tiene espias verify(t1,times(i)).girar(); verifica que al menos 1 ves se haya llamado al metodo girar
    //
   @Test
    @Transactional @Rollback(false)
    public void LoginUsuario()  
    {   
	   Usuario usuarioMock = mock(Usuario.class);
	   Usuario usuarioMock2 = mock(Usuario.class);
	   ServicioLogin serviciologinmock =  mock(ServicioLogin.class);
	   HttpServletRequest req = mock(HttpServletRequest.class);
	   
	   when (serviciologinmock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock2); 
	  
	   ControladorLogin controlador = new ControladorLogin();
	   
	   
	   when (usuarioMock2.getRol()).thenReturn("docente");
	      
	   ModelAndView mod = new ModelAndView();
	   
	   
	   mod = controlador.validarLogin(usuarioMock2, req);
	   
	   assertThat (mod.getViewName()).isEqualTo("homeDocente");
	   
	  
	   
	  //mod.getView().equals("login");
   	
   	  	
   	
          	    	    	      	         	
    }
    
   */
    
}