package comparators;

import java.util.Comparator;
import domain.Alumno;

public class comparadorDeNombre implements Comparator<Alumno> {
	
	public int compare(Alumno alumnoUno, Alumno alumnoDos){
		int resultadoDeComparacion;
		
		resultadoDeComparacion = (alumnoUno.getNombre()).compareTo(alumnoDos.getNombre());
		
		return resultadoDeComparacion;
	}
	
}