package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;


	@SuppressWarnings("unused")
	public class farmaciasDeTurnoDiaMartes extends SpringTest{

	
		@SuppressWarnings({ "unchecked" })
		@Test
		@Transactional @Rollback(true)
		
		public void consultarFarmaciaDiaMartes()
		{		
			
			List <Farmacia> Farmacia = new ArrayList <Farmacia>();
			Farmacia = getSession().createCriteria(Farmacia.class)
					.add(Restrictions.eq("diaDeTurno", "martes"))
					.list();
	   		
			for(Farmacia f : Farmacia){
			Assert.assertEquals(f.getDiaDeTurno(), "martes");
			
		}
    }
}
