import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class ArchVeterinaria {
	private String nom;
	private Veterinaria ve;
	
	public ArchVeterinaria(String nom) {
		this.nom = nom;
	}
	
	public void crear()throws ClassNotFoundException,IOException{
		ObjectOutputStream arch =new ObjectOutputStream(new FileOutputStream(nom));
		arch.close();
	}
	
	public void adicionar()throws ClassNotFoundException,IOException{
		String op;
		Scanner lee=new Scanner(System.in);
		ObjectOutputStream arh=null;
		try{
			arh=new ObjectOutputStream(new FileOutputStream(nom));
			
			do{
				ve=new Veterinaria();
				ve.leer();
				arh.writeObject(ve);
				System.out.println("\n desea continuar s/n");
				op=lee.next();
			}while(op.equals("s"));
				arh.close();
		}catch (Exception e) {
			System.out.println("\n fin de adiciona");
		}
		
	}
	public void listar()throws ClassNotFoundException, IOException{
		ObjectInputStream arch=null;
		try{
			arch=new ObjectInputStream(new FileInputStream(nom));
			int n=0;
			while(true){
				ve=new Veterinaria();
				ve=(Veterinaria)arch.readObject();
				ve.mostrar();
			}
			
		}catch (Exception e){
			System.out.println("\n fin listado");
		}finally{
			arch.close();
		}
	}
	public void listar(String x,int y)throws ClassNotFoundException, IOException{
		ObjectInputStream arch=null;
		boolean sw=false;
		try{
			arch=new ObjectInputStream(new FileInputStream(nom));
			while(true){
				ve=new Veterinaria();
				ve=(Veterinaria)arch.readObject();
				if(ve.buscar(x, y)){
					sw=true;
				}
			}
			
		}catch (Exception e){
			System.out.println("\n fin listado");
		}finally{
			arch.close();
			if(!sw)
				System.out.println("no existe la mascota con esas caracterisiticas");
		}
	}	
	public void listar(String x)throws ClassNotFoundException, IOException{
		ObjectInputStream arch=null;
		boolean sw=false;
		try{
			arch=new ObjectInputStream(new FileInputStream(nom));
			while(true){
				ve=new Veterinaria();
				ve=(Veterinaria)arch.readObject();
				if(ve.getNombreDueño().equals(x)){
					ve.mostrarMascotas();
					sw=true;
					System.out.println(" ");
				}
			}
			
		}catch (Exception e){
			System.out.println("\n fin listado");
		}finally{
			arch.close();
			if(!sw)
				System.out.println("no existe el dueño");
		}
	}	
	
}
