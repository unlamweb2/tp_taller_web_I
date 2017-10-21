package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

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

	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional @Rollback(true)
	
	public void farmaciasDeUnaCalle1()
	{
		List <Farmacia> farmacia = new ArrayList <Farmacia>();
		farmacia = getSession().createCriteria(Farmacia.class)
				.createAlias("Direccion", "dir")
				.add(Restrictions.eq("dir.calle", "Arieta"))
				.list();
				
		for(Farmacia f : farmacia){
			Assert.assertEquals(f.getDireccion().getCalle(),"Arieta");
	}
 }
}