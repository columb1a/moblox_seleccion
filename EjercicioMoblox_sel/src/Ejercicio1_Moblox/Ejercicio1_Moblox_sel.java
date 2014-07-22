package Ejercicio1_Moblox;

import java.util.ArrayList;

public class Ejercicio1_Moblox_sel {

	
	public ArrayList<Integer> Posicion_asteriscos(String str){
		 boolean salida = false;
		 ArrayList<Integer> pos_asteriscos = new ArrayList<>();
		 int pos_aux =-1;
		 
		 while(salida == false){
			 if(str.indexOf("*")!= -1){
				 
				 if(pos_aux==-1 && str.indexOf("*")!=0){
					 pos_aux = str.indexOf("*");
				 }
				 else{
					 pos_aux = str.indexOf("*")+pos_aux+1;
				 }
				 pos_asteriscos.add(pos_aux);
				 //System.out.println(pos_aux);
				 str = str.substring(str.indexOf("*")+1, str.length());
			 }
			 else{
				 salida = true;
			 }
		 }		 
		return pos_asteriscos;		
	}
	
	public ArrayList<String> CombinacionesPosibles1(char[] Arreglo){
		
		String Arreglo_str = new String(Arreglo);
		ArrayList<Integer> pos_asteriscos = Posicion_asteriscos(Arreglo_str); 
		ArrayList<String> combinaciones = new ArrayList<>();
		int cant_combi =(int)Math.pow(2, pos_asteriscos.size());
		
		boolean uno_cero = true;
		int cont = 0;
		int aux_rep = 0;
		for(int i = 0; i<pos_asteriscos.size(); i++) //columna
		{
			aux_rep = (int)Math.pow(2,i);
			
			for(int j = 0; j<cant_combi; j++) //fila
			{
				if(uno_cero == true  ){
					Arreglo[pos_asteriscos.get(i)] = '1';
					if(i == 0){
						combinaciones.add( new String(Arreglo));
						cont = cont+1;
					}
					else{
						char[] arreglo_parcial = combinaciones.get(j).toCharArray();
						arreglo_parcial[pos_asteriscos.get(i)] = '1';
						combinaciones.set(j, new String(arreglo_parcial));
						cont = cont+1;						
					}						
					
					if(cont < aux_rep){
						uno_cero = true;
						//cont = cont+1;
					}
					else{
						cont = 0;
						uno_cero = false;
					}				
				}
				else if(uno_cero == false){
					Arreglo[pos_asteriscos.get(i)] = '0';
					if(i == 0){
						combinaciones.add( new String(Arreglo));
						cont = cont+1;
					}
					else{
						char[] arreglo_parcial = combinaciones.get(j).toCharArray();
						arreglo_parcial[pos_asteriscos.get(i)] = '0';
						combinaciones.set(j, new String(arreglo_parcial));
						cont = cont+1;
					}						
					
					if(cont <aux_rep){
						uno_cero = false;
					}
					else{
						cont = 0;
						uno_cero = true;
					}
				}
			}
		}		
		return combinaciones;				
	}
}
