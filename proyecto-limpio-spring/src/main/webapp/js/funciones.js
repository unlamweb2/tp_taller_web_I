
//VALIDACION Seleccion de Curso
function validacionCurso() {
   
  var idCurso = $('select[id=IdCurso]').val();
    
  var todoOk = false;
       
  if (idCurso == 0) {
      alert('Debe seleccionar un curso');      
  } else  {
	   todoOk = true;
  }
     
  return todoOk;
   
}


$(document).ready(function() {
    $("#verExamen").click(function(event) {
    	
    	var todoOk = false;
   	 var idCurso = $('select[id=IdCurso]').val();
   	
	   	 todoOk = validacionCurso();
	   	 
	   if 	(todoOk==true)
	   	{ 		   
		   //$("#verExamen").attr('href',"\"<c:url value='/verExamenesDocente/'\" + idCurso + "/>");
	   	}
	
    	
        var href = $('#verExamen').attr('href');
        alert(href);        
        //event.preventDefault();
    });
});