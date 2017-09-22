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

public class farmaciasDeUnBarrio extends SpringTest{

	@SuppressWarnings("unchecked")
	@Test
	@Transactional @Rollback(true)
	
	public void farmaciasDeUnBarrio()
	{
		
		
		List <Farmacia> Farmacia = new ArrayList <Farmacia>();
		Farmacia = getSession().createCriteria(Farmacia.class)
				.createAlias("Direccion", "dir")
				.createAlias("dir.Barrio", "barrio")
				.add (Restrictions.eq("barrio.nombre","Hurlingham"))
				.list();
				
		
		for(Farmacia f : Farmacia){
			Assert.assertEquals(f.getDireccion().getBarrio().getNombre(),"Hurlingham");
	}

 }

}