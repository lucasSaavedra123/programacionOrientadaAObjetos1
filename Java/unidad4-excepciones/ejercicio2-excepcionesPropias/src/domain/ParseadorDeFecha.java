package domain;

import exceptions.*;

public class ParseadorDeFecha{
	
	public static void parsearFecha(String fecha) throws FormatoInvalidoDeFecha{
		String [] partesDeLaFecha = fecha.split("/");
		int dia;
		int mes;
		int año;

		try{
			dia = Integer.parseInt(partesDeLaFecha[0]);
			mes = Integer.parseInt(partesDeLaFecha[1]);
			año = Integer.parseInt(partesDeLaFecha[2]);
		}
		catch(Exception cualquierExcepcion) {
			throw new FormatoInvalidoDeFecha();
		}
		
		if( !esFechaValida(dia, mes, año) )
			throw new FormatoInvalidoDeFecha();	
	}
	
	private static boolean esFechaValida(int dia, int mes, int año) {
		boolean esValida = false;
		
		if(esDiaValido(dia) && esMesValido(mes) && esAñoValido(año)) {
			
			if(mes == 2) {
				if(esAñoBisiesto(año) && dia == 29)
					esValida = true;
				if(!esAñoBisiesto(año) && dia <= 28)
					esValida = true;
			}
			if(dia == 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11 ) )
				esValida = true;
			if(dia == 31 && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) )
				esValida = true;
			
			
		}
	
		return esValida;
	}
	
	private static boolean esAñoBisiesto(int año) {
		boolean esBisiesto = false;
		
		if((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0)))
			esBisiesto = true;
		
		return esBisiesto;
	}
	
	private static boolean esDiaValido(int dia) {
		boolean esValido = false;
		
		if( 1 <= dia && dia <= 31 )
			esValido = true;
		
		return esValido;
	}
	
	private static boolean esAñoValido(int año) {
		boolean esValido = false;
		
		if(año >= 0)
			esValido = true;
		
		return esValido;
	}
	
	private static boolean esMesValido(int mes) {
		boolean esValido = false;
		
		if(mes > 0 && mes <= 12)
			esValido = true;
		
		return esValido;
	}
	
}