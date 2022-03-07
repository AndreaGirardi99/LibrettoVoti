package model;

import java.util.ArrayList;
import java.util.List;

public class libretto {

	private List<voto> voti;
	
	public libretto() {
		this.voti=new ArrayList<voto>();
	}
	
	public void add(voto v) {
		this.voti.add(v);
	}
	
	public libretto filtraPunti(int punti) {
		libretto result = new libretto();
		for(voto v: this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	/**
	 * Restituisce il punteggio ottenuto all'esame di cui specifico il nome
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure un'eccezione se l'esame non esiste
	 */
	public int puntiEsame(String nome) {
		for(voto v: this.voti) {
			if(v.getNome().equals(nome)) {
				return v.getPunti();
			}
		}
    throw new IllegalArgumentException("Corso non trovato");
	}
	
	public boolean isDuplicato(voto v) {
		for(voto v1: this.voti) {
			if(v1.equals(v)) {
				return true;
			}
		}
			return false;
	}
	
	public boolean isConflitto(voto v) {
		Integer punti = this.puntiEsame(v.getNome());
		if(punti!=null && punti!=v.getPunti()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.voti.toString();
	}
}
