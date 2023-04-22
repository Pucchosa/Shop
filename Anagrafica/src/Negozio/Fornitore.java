package Negozio;
import java.util.HashMap;
import GUI.*;

public class Fornitore extends Anagrafica {
	public HashMap<Integer,Merce> elenco=new HashMap<Integer,Merce>();
	
	public Fornitore(int id,String nome,String cognome,String telefono,String email,String stato,String citta,String indirizzo,String iva,Double saldo){
		super( id, nome, cognome, telefono, email, stato, citta, indirizzo, iva, saldo);
	}
	public void consegnaMerci(Double costo){
		setSaldo(getSaldo()-costo);
	}
	
	public HashMap<Integer,Merce> getMerc(){
		return elenco;
	}
	
	public void addMerc(Merce m){
		int x=m.getCod();
		elenco.put(x,m);
	}
	
	public void addMerc(int x){
		elenco.put(x,DataM.get(x));
	}
	
	public void removeMerc(int x){
		elenco.remove(x);
	}
	
	public void removeMerc(String name){
		int x=DataM.trovaNome(name);
		elenco.remove(x);
	}
	
	public void ordina(double quant, int index){
		double saldo=quant*DataM.get(index).getPrezzoA();
		consegnaMerci(saldo);
		DataM.get(index).aggiungi(quant);
		MyReadA.salva(this, saldo, index);
	}
}