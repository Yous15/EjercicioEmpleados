import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner teclado = new Scanner(System.in);
		Empleado empl[] = new Empleado[10];
		int opcion, contador = 0;
		double sueldobruto;
		final int hola;

		while(contador < 25){
			
			System.out.print("\033[H\033[2J"); //Limpiarconsola
			  
			
		System.out.println("Introduce el número de la opción: ");
		System.out.println("1. Introducir sueldos. ");
		System.out.println("2. Calcular sueldo neto. ");
		System.out.println("3. Modificar sueldo. ");
		System.out.println("4. Subir sueldos. ");
		System.out.println("5. Salir. ");
		System.out.print("Opción --> ");
		
		opcion = teclado.nextInt();
		
		if (opcion == 1){
		
			System.out.println();
			
			System.out.println("Intoduce nombre y sueldo de los 10 empleados: ");
			
			for (int a = 0; a < empl.length; a++){
				
				String nombre;
				
				System.out.println("Empleado número "+(a+1)+"/10");
				System.out.print("Nombre del empleado: ");
				nombre = teclado.next();
				
				System.out.print("Sueldo bruto (entre 500 y 5000 euros) --> ");
				sueldobruto = teclado.nextDouble();
				
				System.out.println();
				
					if (sueldobruto > 500 || sueldobruto < 5000){				
						empl[a] = new Empleado(nombre, sueldobruto);
					} else {
						System.out.println("Introduce un sueldo válido, entre 500 y 5000 euros.");
					}
			}
			
			System.out.println("Carga de datos realizada.");	
			Thread.sleep(4000);
			
		} else if (opcion == 2){
			
			int numempl;
			
			System.out.println("¿De qué empleado deseas saber el sueldo neto? ");
			numempl = teclado.nextInt();
			
			empl[numempl].CalcSueldoNeto();
			
			System.out.print("El empleado número "+ numempl + ", que se llama "+empl[numempl].getName());
			System.out.print(" cobra " + empl[numempl].getSueldoNeto());
			
			Thread.sleep(4000);
			
		} else if (opcion == 3){
			
			int cual2; 
			String quieres;
			System.out.println("Introduce número de empleado: ");
			cual2 = teclado.nextInt();
			
			empl[cual2].CalcSueldoNeto();
			
			System.out.println("Nombre: " + empl[cual2].getName());
			System.out.println("Sueldo neto actual: " + empl[cual2].getSueldoNeto());
			
			System.out.println("Quieres cambiar el sueldo actual? (yes/no)");
			quieres = teclado.next();
			
			if (quieres.equalsIgnoreCase("yes")){
				
				double newsu;
				System.out.println("¿Qué sueldo debería tener? Debe ser mayor al actual");
				newsu = teclado.nextDouble();
				
				if (newsu > empl[cual2].getSueldoNeto()){
					
					empl[cual2].setSueldo(newsu);
					
					System.out.println("Sueldo actualizado.");
				} else{
					System.out.println("Hemos dicho que tenia que ser mas elevado que el actual...");
				}
				Thread.sleep(4000);
				
			} else {
				System.out.println("Pues nah.");
				Thread.sleep(4000);
				
			}
			
		} else if (opcion == 4){
			
			int cual;
			double porcent;
			
			System.out.println("Introduce el empleado al que quieras subir el sueldo: ");
			
			cual = teclado.nextInt();
			
			System.out.println("Introduce el porcentaje que quieras incrementar: ");
			porcent = teclado.nextDouble();
			
			empl[cual].upSueldo(porcent);
			
			System.out.println("Su sueldo neto ahora es: " + empl[cual].getSueldoNeto());
			
			Thread.sleep(4000);
			
		} else if (opcion == 5){
			
			System.out.println("Gracias!! Adiós!");
			break;
		} else {
			System.out.println("¡¡Introduce un valor que corresponda a una opción del menú!!");
			Thread.sleep(4000);
		}
		
		
		contador++;

		}
		
		teclado.close();
	}
}
