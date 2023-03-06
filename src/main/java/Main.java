
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import models.alumno;



public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        limpiaPantalla();	
        int opcion =1;
        while (opcion!=4) {
	imprimirMenu();
	
	opcion=leerEntrada();
    switch (opcion){
    case 0 : opcion= 0;
    		AñadirAlumno();
    		  break;
    
    case 1:  opcion = 1;
              listarTodo();			
             break;
    case 2:  opcion = 2;
               TodosLosSuspensos();
             break;
    case 3:  opcion = 3;
    		estadisticas();	
             break;
  
   
	case 4:
	
		System.out.println("Has salido del programa");
		break;
		default:{System.out.println("ese número no existe en el menu");}
			
	} 
		
	if (opcion!=6) 
	System.out.println();
	System.out.println("Pulse enter para continuar");
	esperaPulsacion();
		}
	}
	
public static void esperaPulsacion() {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
				
	}

public static int leerEntrada() {
Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();
                return numero;
	}
private static void limpiaPantalla() {
        for (int i=0;i<200;i++) {
                System.out.println();
        }
}
					

    public static void imprimirMenu() {
            System.out.println("************************************");
            System.out.println("************ Menu Principal ********");
            System.out.println("************ Menu de Programas ********");
             System.out.println("0 Añadir alumno");
             System.out.println("1 Ver todo los alumnos");
             System.out.println("2 Ver alumnos suspensos");
             System.out.println("3 Ver estadisticas");
            System.out.println("4 Salir ");
            System.out.println("************************************");
            System.out.println("Introduzca una opción:");
    }
      Scanner sc = new Scanner(System.in);
 
    
    
    private static void AñadirAlumno(){//Mejora adicional
         alumnoDAOHIB a = new alumnoDAOHIB();
         alumno alumnoAñadir = new alumno();
          Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del alumno ");
            String nombre = sc.nextLine();
              System.out.println("Introduce el email del alumno ");
            String email = sc.nextLine();
              System.out.println("Introduce el telefono del alumno ");
            String Telefono = sc.nextLine();
              System.out.println("Introduce la nota de AD");
            double AD = sc.nextDouble();
              System.out.println("Introduce la nota de DI");
            double DI = sc.nextDouble();
   
            alumnoAñadir.setEmail(email);
            alumnoAñadir.setNombre(nombre);
            alumnoAñadir.setTelefono(Telefono);
            alumnoAñadir.setAD(AD);
            alumnoAñadir.setDI(DI);
 
   a.insertarAlumno(alumnoAñadir);
   System.out.println(alumnoAñadir+" ha sido añadido a la lista de alumnos");
        }
        
             private static void  listarTodo(){
                   alumnoDAOHIB a = new alumnoDAOHIB();
                    for (var aa : a.listarTodo()){  System.out.println(aa); };
             }
              
            private static void TodosLosSuspensos() {
                  alumnoDAOHIB a = new alumnoDAOHIB();
                 for (var aa : a.listarSuspensos()){  System.out.println(aa); };
    }
                 private static void estadisticas() {
                  alumnoDAOHIB a = new alumnoDAOHIB();
                  a.estadisticas();
    }
       
}
    
    
        
    
    