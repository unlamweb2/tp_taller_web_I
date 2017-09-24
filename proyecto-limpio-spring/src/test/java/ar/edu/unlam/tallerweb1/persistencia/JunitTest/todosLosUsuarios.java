package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
//import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class todosLosUsuarios extends SpringTest{

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	@Transactional @Rollback(true)
	
	
	public void consultarTodosLosUsuarios()
	{		
		
		List <Usuario> usuario = new ArrayList <Usuario>();
		usuario = getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("password", "diego"))
				.list();
   	
		
		for(Usuario f : usuario){
		Assert.assertEquals(f.getPassword(), "diego");
		
	}

	}
}
