package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		boolean skrevet = false;
		
		try {
			PrintWriter writer = new PrintWriter(MAPPE +filnavn);
			for(int i=0; i<samling.getAntall(); i++) {
				writer.print(samling.getSamling()[i].toString());
			}
			writer.close();
			skrevet = true;
		} catch (FileNotFoundException e) {
			
		}
		
		return skrevet;
	}
}
