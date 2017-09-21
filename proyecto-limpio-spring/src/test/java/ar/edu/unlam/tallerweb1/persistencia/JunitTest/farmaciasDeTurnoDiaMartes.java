package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FarmaciaDaoImpl;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class farmaciasDeTurnoDiaMartes extends FarmaciaDaoImpl{

	@Test
	@Transactional @Rollback(true)
	public void farmaciasDeUnBarrio(){
		
		assertEquals(Farmacia.getDiaDeTurno(),"martes");
	}

}
