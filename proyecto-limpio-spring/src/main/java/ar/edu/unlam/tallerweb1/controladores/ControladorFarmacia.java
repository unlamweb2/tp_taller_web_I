package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Controller
public class ControladorFarmacia {
	@Inject
    private SessionFactory sessionFactory;
	
	@RequestMapping("/Farmacia")
	
	public ModelAndView Farmacia(){
		
		
		ModelMap modelo = new ModelMap();
		Farmacia Farmacia = new Farmacia();
		
		/*final Session session = sessionFactory.getCurrentSession();		
		 Criteria cr = (Criteria) session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("DiaDeTurno", "martes"))				
				.list();*/
		
		modelo.put("Farmacia", Farmacia);
		return new ModelAndView("Farmacia", modelo);
		
	}	
	
	/*@RequestMapping(path= "/obtener-Farmacias", method = RequestMethod.GET)
	
	public ModelAndView obtenerFarmacias(){
		ModelMap modelo = new ModelMap();
		
		
	}*/

}
