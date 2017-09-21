package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Repository("FarmaciaDao")
public class FarmaciaDaoImpl implements FarmaciaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	
	/*- Hacer con junit un test que busque todas las farmacias de turno los días martes.*/
	@Override
	public Farmacia consultarFarmaciaDiaMartes(Farmacia farmacia){	
		final Session session = sessionFactory.getCurrentSession();		
		return (Farmacia) session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("DiaDeTurno", "martes"))				
				.list();		
    }	
	
		
		
	/*Hacer con junit un test que busque todas las farmacias de una calle.*/
	@Override
	public Farmacia farmaciasDeUnaCalle(Farmacia farmacia, Direccion direccion){
		final Session session = sessionFactory.getCurrentSession();
		return (Farmacia) session.createCriteria(Farmacia.class) 
				.createAlias("Direccion", "direccion")
				.add(Restrictions.eq("direccion.calle","Einstein"))
				.list();
	
	}

	
	/*Hacer con junit un test que busque todas las farmacias de un barrio*/
	@Override
	public Farmacia farmaciasDeUnBarrio(Farmacia farmacia, Barrio barrio){
		final Session session = sessionFactory.getCurrentSession();
		return (Farmacia) session.createCriteria(Farmacia.class)  
				.createAlias("Direccion", "dir")
				.createAlias("dir.Barrio", "barrio")
				.add (Restrictions.eq("barrio.nombre","Hurlingham"))
				.list();
	}



	@Override
	public Farmacia consultarFarmacia(Farmacia farmacia) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void consultarFarmaciaDiaMartes() {
		// TODO Auto-generated method stub
		
	}
}