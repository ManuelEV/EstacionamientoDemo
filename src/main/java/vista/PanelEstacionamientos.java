package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelEstacionamientos extends JPanel {

    public int estActual;
    private ArrayList<JButton> estacionamientos;
    private final int cantidadEstacionamientos;

    public PanelEstacionamientos(int cantidadEstacionamientos) {
        this.cantidadEstacionamientos=cantidadEstacionamientos;
        estActual = -1;
        inicializarComponente();
    }

    private void inicializarComponente() {
        this.estacionamientos = new ArrayList();

        this.setBorder(BorderFactory.createTitledBorder("Estacionamiento"));
        
        //por hacer: idear una mejor manera de distrubuir en el panel los estacionamientos (de forma variable)
        int ancho = (int) this.cantidadEstacionamientos/5;
        int alto = 5;
        this.setLayout(new GridLayout(alto, ancho));

        //Se inicializan los botones con sus respectivos eventos
        for (int i = 0; i < cantidadEstacionamientos; i++) {

            JButton est = new JButton("" + (i + 1));
            est.setForeground(Color.WHITE);

            est.setBackground(Color.BLUE);
            this.estacionamientos.add(est);

            this.add(estacionamientos.get(i));

            this.estacionamientos.get(i).addActionListener(
                    (ActionEvent) -> {
                        
                        estacionamientoActual(est.getText());//el estacionamiento actualmente escogido

                    }
            );

        }

    }

    private void estacionamientoActual(String estacionamiento) {
        this.estActual = (int) Integer.parseInt(estacionamiento);
        this.estActual--;
        //System.out.println(this.estActual);
    }

    public ArrayList<JButton> getEstacionamientos() {
        return estacionamientos;
    }

}
