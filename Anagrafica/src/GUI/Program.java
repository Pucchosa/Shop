package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import java.awt.event.*;

public class Program{
	public static void main(String[] args) {
		MyReadM.carica();
		MyReadF.carica();
		MyReadC.carica();
		Home prova=new Home();
		prova.setVisible(true);
	}
	
	public static class Home extends Frame{
		public Home(){
			super("HOME");
			setLayout(new BorderLayout(100,10));
			setLocation(150,150);
			setBackground(Est.chiaro);
			
			// ISTANZIO TUTTI I FRAME SECONDARI
			
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(3,2));
			
			Etichetta tx=new Etichetta("<html>Benvenuti nel database, cosa si desidera fare? ");
			add("North",tx);
			
			Pulsante b1=new Pulsante("Consulta DataBase Persone");
			b1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ConsultaPersone consultaP=new ConsultaPersone();
			    	consultaP.setVisible(true);
			    	setVisible(false);
				}
			});
	        contenuto.add(b1);
			
	        Pulsante b2=new Pulsante("Consulta DataBase Merci");
			b2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ConsultaMerci consultaM=new ConsultaMerci();
			    	consultaM.setVisible(true);
			    	setVisible(false);
			    	dispose();
				}
			});
	        contenuto.add(b2);
			
	        Pulsante b3=new Pulsante("--ACQUISTO RAPIDO--");
	        b3.setBackground(Est.medio);
			b3.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	Spesa aggg=new Spesa(new Guest());
					aggg.setVisible(true);
			    	setVisible(false);
			    	dispose();
				}
			});
	        contenuto.add(b3);
			
			add("Center",contenuto);
			
			
			Panel bott=new Panel();
			bott.setLayout(new GridLayout(1,2));
			
			
			Pulsante bex=new Pulsante("-ESCI-");
			bex.setBackground(Est.rosso);
			bex.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	MyReadM.scarica();
	    			MyReadF.scarica();
	    			MyReadC.scarica();
	            	setVisible(false);
	            	dispose();
	            	System.exit(0);
	        	}
			});
			bott.add(bex);
			
			Pulsante bes=new Pulsante("-STORICO-");
			bes.setBackground(Est.medio);
			bes.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Storico stor=new Storico();
	            	stor.setVisible(true);
			    	setVisible(false);
			    	dispose();
	        	}
			});
			bott.add(bes);
			
	        add("South",bott);
	        
			pack();
		}
	}
}