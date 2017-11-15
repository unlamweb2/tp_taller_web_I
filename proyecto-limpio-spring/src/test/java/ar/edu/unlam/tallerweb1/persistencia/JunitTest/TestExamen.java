package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import javassist.expr.Cast;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class TestExamen extends SpringTest{
      
    Examen examen;
    Examen examen2;
	Pregunta pregunta;
	Respuesta respuesta;
	    
	
    @Before
    @Transactional @Rollback(true)
    public void llenarDatos()  
    {   
    	ArrayList <Examen> examenes = new ArrayList();
    	
    	/*examen ingles */
    	ArrayList <Pregunta> preguntas = new ArrayList();
    	ArrayList <Respuesta> respuestas = new ArrayList();    	
    	respuestas.add(new Respuesta("No soy",false));
    	respuestas.add(new Respuesta("Yo soy",true));
    	respuestas.add(new Respuesta("Yo estoy",true));    	    	    	
    	
    	preguntas.add( new Pregunta("Significado de 'I am'",respuestas)); 
    	
    	ArrayList <Respuesta> respuestas2 = new ArrayList();  
    	respuestas2.add(new Respuesta("el esta",false));
    	respuestas2.add(new Respuesta("el es",true));
    	respuestas2.add(new Respuesta("el tiene",true));    	    	    	
    	
    	preguntas.add( new Pregunta("Significado de 'He Has'",respuestas2));     	    	    	
    	examen = new Examen("Examen Ingles","12/12/2018","final",preguntas,100);
    	
    	examenes.add(examen);
    	
    	/*examen historia*/
    	ArrayList <Pregunta> preguntas2 = new ArrayList();
    	ArrayList <Respuesta> respuestas3 = new ArrayList();    	
    	respuestas3.add(new Respuesta("Negro",false));
    	respuestas3.add(new Respuesta("blanco",true));    	   	    	    	
    	
    	preguntas2.add( new Pregunta("De que color fue el caballlo blanco de San Martin?",respuestas3)); 
    	
    	ArrayList <Respuesta> respuestas4 = new ArrayList();     
    	respuestas4.add(new Respuesta("Francia",true));
    	respuestas4.add(new Respuesta("Argentina",false));    	    	    	
    	
    	preguntas2.add( new Pregunta("Dondfe Murio san Martin'",respuestas4)); 
    	
    	
    	
    	examen2 = new Examen("Examen Historia","12/12/2018","final",preguntas2,100);
    	    	   	    	   	    	    	   	
    	examenes.add(examen2);
    	
    	/* fin carga de examenes*/
    	    	
    	Curso curso = new Curso(); 
    	curso.setExamen(examenes);
    	curso.setNombre("Curso 1");
       
    	ArrayList <Curso> cursos = new ArrayList();
    	
    	cursos.add(curso);
    	       	
    	Usuario usuario = new Usuario();
    	usuario.setEmail("test@test");
    	usuario.setNombre("test");
    	usuario.setRol("alumno");
    	usuario.setPassword("1234");
    	
    	usuario.setCursos(cursos);
    	
    	getSession().save(usuario);  
    	
    	
    } 	
   
    
   @Test
    @Transactional @Rollback(false)
    public void GetExamenes()  
    {   
    	
       List <Respuesta> res;
           	
    	res = getSession().createCriteria(Respuesta.class)
    			.add (Restrictions.eq("id", Long.parseLong( "31")))
    			.list();
    	
    	    	    	
   	for (Respuesta item : res) {
    		
    		System.out.println(item.getId());
			System.out.println(item.getNombre());
			
			Assert.assertEquals(item.getNombre(),"No soy");     	
    		}
   	
    List <Pregunta> pre;
   	
   	pre = getSession().createCriteria(Pregunta.class)
			.add (Restrictions.eq("id", Long.parseLong( "12")))
			.list();
   	
   	for (Pregunta item : pre) {
   		
		System.out.println(item.getId());
		System.out.println(item.getNombre());
		
		Assert.assertEquals(item.getExamen().getNombre(),"Ingles"); 		
		}
   	
   	List <Examen> ex;
   	ex = getSession().createCriteria(Examen.class)
			.add (Restrictions.eq("id", Long.parseLong( "7")))
			.list();
   	
	
   	for (Examen item : ex) {
   		
		System.out.println(item.getId());
		System.out.println(item.getNombre());
		Assert.assertEquals(item.getNombre(),"Ingles"); 
				
		for (Pregunta item2 : item.getPreguntas()){			
			System.out.println(item2.getId());
			System.out.println(item2.getNombre());
			
			for (Respuesta item3 : item2.getRespuestas()){			
				System.out.println(item3.getId());
				System.out.println(item3.getNombre());
			}
		}
		
		
				
		}
            	    	    	      	         	
    }
    
}
    