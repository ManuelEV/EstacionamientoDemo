package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesRegistro extends JPanel {

    private JButton registroIngreso;
    private JButton registroSalida;

    public PanelBotonesRegistro() {
        inizializarComponente();
    }

    private void inizializarComponente() {
        
        registroIngreso = new JButton("Registrar Ingreso");
        registroSalida = new JButton("Registrar Salida");

        this.setLayout(new FlowLayout());

        this.add(this.registroIngreso);
        this.add(this.registroSalida);
        
        
        
    }

    public JButton getRegistroIngreso() {
        return registroIngreso;
    }

    public JButton getRegistroSalida() {
        return registroSalida;
    }
    
    
    
}
