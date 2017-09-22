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
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class farmaciasDeUnaCalle extends SpringTest{

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	@Transactional @Rollback(true)
	
	public void farmaciasDeUnaCalle()
	{
		
		List <Farmacia> Farmacia = new ArrayList <Farmacia>();
		Farmacia = getSession().createCriteria(Farmacia.class)
				.createAlias("Direccion", "direccion")
				.add(Restrictions.eq("direccion.calle","Einstein"))
				.list();	
		
		
	
		for(Farmacia f : Farmacia){
			Assert.assertEquals(f.getDireccion().getCalle(),"Einstein");
	}

 }

}