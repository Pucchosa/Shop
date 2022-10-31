package GUI;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import Negozio.Anagrafica;
import Negozio.Merce;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;

public class MyChoice extends JPanel{
	JList<String> jList;
	ArrayList<String> elenco=new ArrayList<String>();
	
	public MyChoice(HashMap<Integer,Merce> lis){
		super();
		populate(lis);
		setBorder(Est.bordo);
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		jList = new JList<String>(createDefaultListModel());
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setVisibleRowCount(6);
		
		add(createTextField());
		add(new JScrollPane(jList));
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public MyChoice(ArrayList<Anagrafica> lis){
		super();
		populate(lis);
		setBorder(Est.bordo);
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		jList = new JList<String>(createDefaultListModel());
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setVisibleRowCount(6);
		
		add(createTextField());
		add(new JScrollPane(jList));
	}
	
	private void populate(ArrayList<Anagrafica> sor) {
		for (Anagrafica a:sor) {
			String fin=a.getIntestazione();
			elenco.add(fin);
		}
		
	}
	
	private void populate(HashMap<Integer,Merce> sor) {
		for (Merce a:sor.values()) {
			String fin=a.getCod()+" "+a.getNome();
			elenco.add(fin);
		}
		
	}

	private JTextField createTextField() {
        final JTextField field = new JTextField(15);
        field.setPreferredSize(Est.fil);
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = field.getText();
                filterModel((DefaultListModel<String>)jList.getModel(), filter);
            }
        });
        return field;
    }
	
	private ListModel<String> createDefaultListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : elenco) {
            model.addElement(s);
        }
        return model;
    }
	public void filterModel(DefaultListModel<String> model, String filter) {
        for (String s : elenco) {
        	if (s.toLowerCase().contains(filter)) {
        		if (!model.contains(s)) {
                    model.addElement(s);
                }
            } else {
            	if (model.contains(s)) {
                    model.removeElement(s);
                }
                
            }
        }
    }
}
