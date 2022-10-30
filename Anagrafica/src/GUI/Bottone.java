package GUI;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Bottone extends JPanel{
	public NewButt but;
	public Bottone(String x){
		super();
		but=new NewButt(x);
		setBorder(Est.vuoto);
		setLayout(new GridBagLayout());
		setBorder(Est.bordo);
		setBackground(Est.sfondo);

		but.setMinimumSize(Est.piccolo);
		but.setMaximumSize(Est.piccolo);
		but.setPreferredSize(Est.piccolo);
		
		add(but);
	}
	public Bottone(String x,int y){
		super();
		but=new NewButt(x);
		setBorder(Est.vuoto);
		setLayout(new GridBagLayout());
		setBorder(Est.bordo);
		setOpaque(false);

		but.setMinimumSize(Est.grosso);
		but.setMaximumSize(Est.grosso);
		but.setPreferredSize(Est.grosso);
		
		add(but);
	}

}
