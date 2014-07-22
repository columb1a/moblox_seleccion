package Ejercicio1_Moblox;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Ejercicio1_Moblox_sel eje = new Ejercicio1_Moblox_sel();
		Scanner in = new Scanner(System.in);
		int opc; 
        String entrada;
		
        do { 
        System.out.println ("\nPrograma Moblox 1.0 Por favor elije una opción, luego presiona ENTER:\n");        
        System.out.println ("1) Calcular combinaciones posibles de una cadena de caracteres.");         
        System.out.println ("2) Salir."); 
        opc = in.nextInt(); 
        switch(opc) { 
            case 1: 
            	System.out.println("Ingresa una cadena de caracteres que incluya solo 1's, 0's o símbolos asteriscos.");
            	System.out.println("Por ejemplo: 111*001*, o **1001*, etc...");
            	entrada = in.next();
             	ArrayList<String> resultado = eje.CombinacionesPosibles1(entrada.toCharArray());
             	if(resultado.size()>0){
            		System.out.println("Se obtuvieron "+resultado.size()+" resultados, listados a continuación:");
            		System.out.println("----------------------------------------------------");
            		for (int i = 0; i < resultado.size(); i++) {
            			System.out.println(i+1+") "+resultado.get(i));			
            		}             		
             	}
             	else{
             		System.out.println("No se obtuvieron resultados para la cadena ingresada!!");
             	}
            break;
        } 
    } while (opc != 2); 
        
	}

}
