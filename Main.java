import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args)throws ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		ArchVeterinaria a=new ArchVeterinaria("veterinaria.dat");		
		Scanner lee = new Scanner(System.in);
		int op3;
		do {
			System.out.print("\n MENU ARCHIVO ATENCION");
			System.out.print("\n 1. Crear" + 
							 "\n 2. Adicionar"+
							 "\n 3. Listar"+
							 "\n 4. b)	Buscar la(s) mascota(s) tipo X cuya edad es Y, mostrando el nombre de la veterinaria donde se encuentra y los datos de la mascota(s)"+
							 "\n 5. c)	Mostrar las mascotas de la Veterinaria cuyo dueño es X");
			System.out.println("");
			op3 = lee.nextInt();
			switch (op3) {
			case 1:
				a.crear();
				break;
			case 2:
				a.adicionar();
				break;
			case 3:
				a.listar();
				break;
			case 4:
				System.out.println("Introdzca el tipo x : ");
				String x=lee.next();
				System.out.println("Introduzca la edad y");
				int y=lee.nextInt();
				a.listar(x,y);
				break;
			case 5:
				System.out.println("Introdzca el tipo x: ");
				String r=lee.next();
				a.listar(r);
				break;
		 }
		} while (op3 != 0);
	
	}

}
