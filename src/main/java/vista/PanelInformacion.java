package vista;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class PanelInformacion extends JPanel {
	private JLabel vCaja;
	private JLabel pVacios;
	public static JTextField valorCaja;
	public JTextField puestosVacios;

	public PanelInformacion() {
		inicializarComponente();
	}

	private void inicializarComponente() {
            
            this.setBorder(BorderFactory.createTitledBorder("Información"));
            
            this.setLayout(new GridLayout(2, 2));
            
            this.vCaja = new JLabel("VALOR CAJA");
            valorCaja = new JTextField("$0");
            valorCaja.setEditable(false);
            
            this.pVacios = new JLabel("PUESTOS VACIOS");
            this.puestosVacios = new JTextField("90");
            this.puestosVacios.setEditable(false);
            
            this.add(this.vCaja);
            this.add(PanelInformacion.valorCaja);
            this.add(this.pVacios);
            this.add(this.puestosVacios);
            
	}
}