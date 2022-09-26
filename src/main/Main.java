package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

	
	/**
	 * 	
	 * @param args
	 * @throws Exception
	 */
	/*
	 * En el main se leen las variables para crear el arreglo de los pisos
	 * y el piso inicial, y se procede a llamar el metodo donde esta el
	 * funcionamiento del elevador
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Arreglo de pisos: ");
		String floors = bf.readLine();
		String[] medium = floors.split(",");
		PriorityQueue<Integer> floorsArray = new PriorityQueue<Integer>();
		
		//metodo para convertir los pisos de String a int y pasarlos a un arreglo
		for(int i = 0; i < medium.length;i++) {
			floorsArray.add(Integer.parseInt(medium[i]));
		}
		
		
	    
	    //Se recibe el piso inicial
		System.out.println("Piso inicial de Ejecuciòn: ");
		int initialFloor = Integer.parseInt(bf.readLine());
		
		elevatorFunction(floorsArray, initialFloor);
		
	}
	
	/**
	 * 
	 * @param floorsArray
	 * @param initialFloor
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	/* 
	 * En este metodo se hace el funcionamiento del elevador
	 * se implementa un HashMap donde se almacenan y actualizan los valores de acuerdo 
	 * a los nuevos valores ingresados, y los pisos restantes
	 */
	public static void elevatorFunction(PriorityQueue<Integer>floorsArray, int initialFloor) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> floorsToMove = new HashMap<Integer, Integer>();
		int finalFloor = floorsArray.peek();
		while(!floorsArray.isEmpty()){

			floorsToMove.put(initialFloor, finalFloor);
			System.out.println("Elevador en piso: " + initialFloor);
			if(initialFloor < finalFloor){
				System.out.println("Elevador subiendo");
			}else {
				System.out.println("Elevador bajando");
			}
			System.out.println("Elevador en piso: " +  finalFloor);
			floorsArray.poll();
			System.out.println("Elevador se detiene");
			
			if(!floorsArray.isEmpty()) {
				System.out.println("piso ingresado: ");
			int floorJoined = Integer.parseInt(bf.readLine());
			if(floorJoined != 0) {
				floorsArray.add(floorJoined);
				
			}
			initialFloor = finalFloor;
			finalFloor = floorsArray.peek();
			}
			
			
		}
	}
		
}


