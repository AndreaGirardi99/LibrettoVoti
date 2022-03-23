package model;

public class TestLibretto {
	public static void main(String[] args) {
		libretto lib = new libretto();
		lib.add(new voto("Analisi 1", 30));
		lib.add(new voto ("Fisica 1", 18));
		lib.add(new voto("Informatica", 25));
		lib.add(new voto("Algebra lineare", 24));
		
		System.out.println(lib);
		
		System.out.println("Voti pari a 25:");
	}
	
}
