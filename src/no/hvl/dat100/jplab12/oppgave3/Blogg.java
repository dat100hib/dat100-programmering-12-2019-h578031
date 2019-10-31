package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.oppgave1.Innlegg;
import no.hvl.dat100.jplab12.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] innleggtabell;
	private int nesteledig;
	
	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int indeks = -1;
		int i = 0;
		while(indeks == -1 && i < nesteledig) {
			if(innleggtabell[i].erLik(innlegg))
				indeks = i;
			i++;
		}
		return indeks;
	}
	
	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		int i = 0;
		while(!finnes && i<nesteledig) {
			if(innleggtabell[i].erLik(innlegg)) {
				finnes = true;
			}
			i++;
		}
		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		if(nesteledig < innleggtabell.length) {
			ledig = true;
		}
		return ledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		if(!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			lagtTil = true;
		}
		return lagtTil;
	}
	
	public String toString() {
		String res = nesteledig + "\n";
		for(int i=0; i < nesteledig; i++) {
			res += innleggtabell[i].toString();
		}
		return res;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nytab = new Innlegg[innleggtabell.length*2];
		for(int i=0; i<nesteledig; i++) {
			nytab[i] = innleggtabell[i];
		}
		this.innleggtabell = nytab;		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = false;
		if(!finnes(innlegg)) {
			if(ledigPlass()) {
				innleggtabell[nesteledig] = innlegg;
				nesteledig++;
				lagtTil = true;
			}
			else {
				utvid();
				innleggtabell[nesteledig] = innlegg;
				nesteledig++;
				lagtTil = true;
			}
		}
		return lagtTil;
	}
	
	public void slett(Innlegg innlegg) {
		int inn = finnInnlegg(innlegg);
		innleggtabell[inn] = null;
		/*for(int i=inn; i<nesteledig; i++) {
			innleggtabell[inn] = innleggtabell[inn+1];
		}*/
		nesteledig--;
	}
	
	public int[] search(String keyword) {
		int[] tab = new int[nesteledig];
		Tekst[] tekstTab = new Tekst[nesteledig];
		int j = 0;
		//Tekst t = (Tekst)innleggtabell[0];
		
		for(int i=0; i<nesteledig; i++) {
			if(innleggtabell[i] instanceof Tekst) {
				Tekst a = (Tekst) innleggtabell[i];
				tekstTab[j] = a;
				j++;
			}
		}
		for(int i=0; i<nesteledig; i++) {
			if(tekstTab[i].getTekst().contains(keyword)) {
				tab[i] = tekstTab[i].getId();
			}
		}
		return tab;
	}
}