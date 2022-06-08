package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import Negozio.Ogg;
import java.awt.event.*;

public class ConsultaPersone extends Frame {
	boolean tipp=true;
	public ConsultaPersone(DataB<Cliente> c,DataB<Fornitore> f){
		super("CONSULTA data base Persone");
		setBackground(new Color(217,243,248));
		setLocation(300,300);
		Font ft=new Font("Lucida",Font.PLAIN,24);

		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(3,3));
		
/*comp1*/  JLabel tx1=new JLabel();
		tx1.setBorder(BorderFactory.createEmptyBorder(30, 5, 5, 70));
		String testo="Consulta Fornitori";
		tx1.setText(testo);
		tx1.setFont(ft);
		contenuto.add(tx1);
		
/*comp2*/Choice ele1=new Choice();
		ele1.add("Scegli");
		try{
			for (Fornitore a:f.elenco){
				ele1.add(a.getCognome()+" "+a.getNome());
			}
		}
		catch (Exception e){
			ele1.add("Lista vuota");
		}
		ele1.setFont(ft);
		contenuto.add(ele1);

/*comp6*/Button bent1=new Button("-INVIO-");
		bent1.setBackground(new Color(26,200,219));
		bent1.setPreferredSize(new Dimension(80,50));
//		bent.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		    	setVisible(false);
//			}
//		});
		contenuto.add(bent1);

/*comp4*/  JLabel tx=new JLabel();
		tx.setBorder(BorderFactory.createEmptyBorder(30, 5, 5, 70));
		tx.setText("Consulta Clienti");
		tx.setFont(ft);
		contenuto.add(tx);
		
/*comp5*/Choice ele=new Choice();
		ele.add("Scegli");
		try{
			for (Cliente a:c.elenco){
				ele.add(a.getCognome()+" "+a.getNome());
			}
		}
		catch (Exception e){
			ele.add("Lista vuota");
		}
		ele.setFont(ft);
		contenuto.add(ele);

/*comp6*/Button bent=new Button("-INVIO-");
		bent.setBackground(new Color(26,200,219));
		bent.setPreferredSize(new Dimension(80,50));
//		bent.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		    	setVisible(false);
//			}
//		});
		contenuto.add(bent);
		
/*comp7*/Button bex=new Button("-ESCI-");
		bex.setBackground(new Color(2,146,183));
		bex.setPreferredSize(new Dimension(80,50));
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp8*/JLabel tv=new JLabel();
		tv.setText("           ");
		tv.setFont(ft);
		tv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(tv);
		
/*comp9*/Button b2=new Button("+ Aggiungi +");
		b2.setBackground(new Color(26,200,219));
		b2.setPreferredSize(new Dimension(80,50));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiPersona aggg=new AggiungiPersona(c,f);
				aggg.setVisible(true);
				dispose();
			}
		});
		contenuto.add(b2);
		
		add(contenuto);
		pack();
	}
	public void sett(boolean a){
		this.tipp=a;
	}
}