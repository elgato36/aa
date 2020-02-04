import java.util.Scanner;

public class Equipo {
	
	private String nombre;
	private int nroJugadores;
	private Jugador[] Jugadores = new Jugador[100];
	private Entrenador E;
	private int nroEsponsor;
	private Esponsor[] ListaEsponsor = new Esponsor[100];
	
	public Equipo() {
		for (int i = 0; i < Jugadores.length; i++) {
			Jugadores[i] = new Jugador();
		}
	}

	public void leer() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Introducir nombre, nroJugadores y jugadores del equipo");
		setNombre(leer.nextLine());
		setNroJugadores(Integer.parseInt(leer.nextLine()));
		for (int i = 0; i < nroJugadores; i++) {
			Jugadores[i].leer();
		}
	}
	
	public void mostrar() {
		System.out.println("**** DATOS DEL EQUIPO ****");
		System.out.println("Nombre: " + getNombre());
		System.out.println("Nro de Jugadores: " + getNroJugadores());
		for (int i = 0; i < nroJugadores; i++) {
			Jugadores[i].mostrar();
		}
	}
	
	public void agregaEntrenador(Entrenador x) {
		setE(x);
	}
	
	public void agregaEsponsor(Esponsor x) {
		ListaEsponsor[nroEsponsor] = x;
		nroEsponsor++;
	}
	
	public void agregaEsponsor(int n) {
		for (int i = 0; i < n; i++) {
			Esponsor x = new Esponsor();
			x.leer();
			agregaEsponsor(x);
		}
	}
	
	public void ordenar() {
		for (int i = 0; i < nroJugadores; i++) {
			for (int j = i+1; j < nroJugadores; j++) {
				if(Jugadores[i].getNombre().compareTo(Jugadores[j].getNombre()) > 0 ){
					Jugador	aux = getJugadores()[i];
					Jugadores[i] = Jugadores[j];
					Jugadores[j] = aux;
				}
			}
		}
	}
	
	
	public boolean verificar(String x) {
		for (int i = 0; i < nroEsponsor; i++) {
			if(getListaEsponsor()[i].getMarca().equals(x))
				return true;
		}
		return false;
	}
	
	public void mostrar(String x) {
		int max = 0;
		for (int i = 0; i < nroJugadores; i++){
			for (int j = 0; j < Jugadores[i].getNroHeroes(); j++){
				if(Jugadores[i].getHeroes()[j][1].equals(x)){
					max = Math.max(max, Integer.parseInt(Jugadores[i].getHeroes()[j][2]));
				}
			}
		}
			
		System.out.println("Heroes con mayor nro nro de victorias con un heroe de tipo " + x);
		for (int i = 0; i < nroJugadores; i++) {
			for (int j = 0; j < Jugadores[i].getNroHeroes(); j++) {
				if (Jugadores[i].getHeroes()[j][1].equals(x) && Integer.parseInt(Jugadores[i].getHeroes()[j][2]) == max){
					System.out.println(Jugadores[i].getNombre());
					break;
				}
			}
		}
	}
	
	public void mostrar(Equipo e) {
		String[][] m = new String[100][3];
		int nm = 0, ind;
		for (int i = 0; i < this.nroJugadores; i++) {
			for (int j = 0; j < this.getJugadores()[i].getNroHeroes()-1; j++) {
				ind = nm;
				String nombreHeroe = this.getJugadores()[i].getHeroes()[j][0];
				for (int k = 0; k < nm; k++) {
					if(m[k][0] != null &&nombreHeroe.equals(m[k][0])){
						ind = k;
					}
				}
				for (int k = 0; k < m.length; k++) {
					m[ind][1] = "0";
					m[ind][2] = "";
				}
				m[ind][0] = m[ind][0] == null? nombreHeroe: m[ind][0];
				m[ind][1] = m[ind][1] == "0" || m[ind][1] == null? "1" : Integer.toString(Integer.parseInt(m[ind][1])+1);
				m[ind][2] += this.Jugadores[i].getNombre()+" ";
				nm++;
			}
		}
		for (int i = 0; i < e.nroJugadores; i++) {
			for (int j = 0; j < e.getJugadores()[i].getNroHeroes(); j++) {
				ind = nm;
				String nombreHeroe = this.getJugadores()[i].getHeroes()[j][0];
				for (int k = 0; k < nm; k++) {
					if(m[k][0] != null &&nombreHeroe.equals(m[k][0])){
						ind = k;
					}
				}
				m[ind][0] = m[ind][0] == null? nombreHeroe: m[ind][0];
				m[ind][1] = m[ind][1] == "0" || m[ind][1] == null? "1" : Integer.toString(Integer.parseInt(m[ind][1])+1);
				m[ind][2] += e.Jugadores[i].getNombre() +" "; 
				nm++;
			}
		}
		
		System.out.println("\nJugadores con los mismos heroes:");
		for (int i = 0; i < m.length; i++) {
			if(m[i][1] != null && Integer.parseInt(m[i][1]) > 1)
				System.out.println(m[i][0] + " " + m[i][1] + " " + m[i][2]);
		}
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNroJugadores() {
		return nroJugadores;
	}

	public void setNroJugadores(int nroJugadores) {
		this.nroJugadores = nroJugadores;
	}

	public Jugador[] getJugadores() {
		return Jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		Jugadores = jugadores;
	}

	public Entrenador getE() {
		return E;
	}

	public void setE(Entrenador e) {
		E = e;
	}

	public int getNroEsponsor() {
		return nroEsponsor;
	}

	public void setNroEsponsor(int nroEsponsor) {
		this.nroEsponsor = nroEsponsor;
	}

	public Esponsor[] getListaEsponsor() {
		return ListaEsponsor;
	}

	public void setListaEsponsor(Esponsor[] listaEsponsor) {
		ListaEsponsor = listaEsponsor;
	}
	
}
