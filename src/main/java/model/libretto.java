package model;

import java.util.List;

import db.LibrettoDA0;

public class libretto {
	
	public libretto() {
	}
	
	public boolean add(voto v) {
		LibrettoDA0 da0 = new LibrettoDA0();
		 boolean result = da0.creaVoto(v);
		 return result;
	}
	
	public List<voto> getVoti(){
		LibrettoDA0 da0 = new LibrettoDA0();
		return da0.readAllVoto();
	}
}
