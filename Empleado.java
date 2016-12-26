public class Empleado {

	public Empleado(String nombre, double sueldobruto){
		
		
		this.sueldobruto = sueldobruto;
		this.nombre = nombre;
		
	}
	
	double sueldobruto;
	String nombre;
	double sueldoNeto;
	
	String getName(){
		
		return nombre;
	}
	
	double getSueldoBruto(){
		
		return sueldobruto;
	}
	
	double getSueldoNeto(){
				
		return sueldoNeto;
	}
	
	void CalcSueldoNeto(){
		
		double irpf = 0, ss;
				
		ss = sueldobruto / 100 * 6;
				
			if (sueldobruto >= 700){
				irpf = sueldobruto / 100 * 8;
			} else if (sueldobruto > 700 && sueldobruto <= 1100){
				irpf = sueldobruto / 100 * 11;
			} else if (sueldobruto > 1100 && sueldobruto <= 1500){
				irpf = sueldobruto / 100 * 13;
			} else if (sueldobruto > 1500 && sueldobruto <= 2100){
				irpf = sueldobruto / 100 * 17;
			} else if (sueldobruto > 2100 && sueldobruto <= 3000){
				irpf = sueldobruto / 100 * 20;
			} else if (sueldobruto > 3000){
				irpf = sueldobruto / 100 * 25;
			}
						
				sueldoNeto = sueldobruto - irpf - ss;
	}
	
	void setSueldo(double sueldobruto){
		
		this.sueldobruto = sueldobruto;
		
		CalcSueldoNeto();
		
	}
	
	void upSueldo(double porcent){
		
		sueldobruto = sueldobruto + (sueldobruto / 100 * porcent);
		
		CalcSueldoNeto();
	}
	
}
