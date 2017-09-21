package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class farmaciasDeUnBarrio {

	@Test
	@Transactional @Rollback(true)
	public void farmaciasDeUnBarrio(){
		
		assertEquals(Farmacia. getDireccion () . getBarrio () . getNombre (), " Hurlingham " );
	}

}
