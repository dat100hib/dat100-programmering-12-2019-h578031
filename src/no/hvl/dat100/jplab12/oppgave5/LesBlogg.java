package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Blogg blogg = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MAPPE+filnavn));
			
			String ant = reader.readLine();
			int antall = Integer.parseInt(ant);
			blogg = new Blogg(antall);
			String line;
			while((line = reader.readLine()) != null) {
				String type = line;
				String iden = reader.readLine();
				int id = Integer.parseInt(iden);
				
				String bruker = reader.readLine();
				String dato = reader.readLine();
				String like = reader.readLine();
				int likes = Integer.parseInt(like);
				String tekst = reader.readLine();
				
				if(type.equals(BILDE)) {
					String url = reader.readLine();
					Bilde bilde = new Bilde(id, bruker, dato,likes,tekst,url);
					blogg.leggTil(bilde);
				}
				else {
					Tekst t = new Tekst(id, bruker,dato,likes,tekst);
					blogg.leggTil(t);
				}	
			}
			reader.close();
			
		}catch(IOException e) {
			System.out.println("Noe gikk galt");
		}
		
		return blogg;
	}
}
