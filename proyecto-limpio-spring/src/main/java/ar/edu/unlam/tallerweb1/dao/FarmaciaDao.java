package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public interface FarmaciaDao {
	
	Farmacia consultarFarmacia (Farmacia farmacia);

	Farmacia consultarFarmaciaDiaMartes(Farmacia farmacia);

	Farmacia farmaciasDeUnaCalle(Farmacia farmacia, Direccion direccion);

	Farmacia farmaciasDeUnBarrio(Farmacia farmacia, Barrio barrio);

}
