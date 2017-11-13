package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ExamenDao;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;

@Service("ServicioExamen")
@Transactional
public class ServicioExamenImpl implements ServicioExamen{

	@Inject
	private ExamenDao examendao;
	
	@Transactional
	public ArrayList<Examen> cargarExamen(){
		return examendao.cargarExamen();
	}
	
	@Transactional
	public Examen cargarExamen(long Idexamen){
		return examendao.cargarExamen(Idexamen);
	}

	@Transactional
	public ArrayList<Respuesta> corregirRta(String[] rta){
		return examendao.corregirRta(rta);
	}
	
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen){
		return examendao.cargarPreguntaPorExamen(Idexamen);		
	}
	
	public float GetNotaExamen(ArrayList <Pregunta>  preguntas, long[] respuestas){
		 List<Respuesta>  respuesta;
		 float aciertos=0;
		 float CantPreguntas =0;
		 float nota=0;
		 
		 CantPreguntas = preguntas.size();
		 
		for (int i=0; i< preguntas.size();i++){
			
			respuesta = preguntas.get(i).getRespuestas();
											
			for (int j=0; j< respuesta.size();j++){
				
				for (int z=0; z< respuestas.length;z++){
					
					if (respuesta.get(j).getId()==(long) respuestas[z] ){
						
						if (respuesta.get(j).getCorrecta()){
							aciertos++;
						}								
					}							
				}
			}		
		}
		
		nota= (aciertos/CantPreguntas)*100;
		
		
		
		return (float) nota;
	}
}