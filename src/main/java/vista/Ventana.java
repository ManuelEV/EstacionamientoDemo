package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import modelo.Caja;
import modelo.ControladorEstacionamiento;

public class Ventana extends JFrame {

    private PanelInformacion panelInformacion;
    private PanelBotonesRegistro panelRegistros;
    private PanelEstacionamientos panelEstacionamientos;
    private final int precioPorMinuto;
    private final int cantidadEstacionamientos;

    public Ventana(int precioPorMinuto, int cantidadEstacionamientos) {
        this.precioPorMinuto = precioPorMinuto;
        this.cantidadEstacionamientos = cantidadEstacionamientos;
        inicializarComponente();
    }

    private void inicializarComponente() {

        Caja caja = new Caja(this.precioPorMinuto);

        this.panelEstacionamientos = new PanelEstacionamientos(this.cantidadEstacionamientos);
        this.panelInformacion = new PanelInformacion();
        this.panelRegistros = new PanelBotonesRegistro();

        this.setTitle("Estacionamiento");

        ArrayList<JButton> estacionamientos = this.panelEstacionamientos.getEstacionamientos();

        ControladorEstacionamiento controlador = new ControladorEstacionamiento(90);

        this.setSize(950, 450);

        this.add(this.panelEstacionamientos, BorderLayout.NORTH);

        this.add(this.panelRegistros, BorderLayout.CENTER);

        this.add(this.panelInformacion, BorderLayout.SOUTH);

        this.setVisible(true);

        //por hacer: idealmente dejar esto en la clase PanelBotonesRegistro
        //----------------------------------------------------------------------
        panelRegistros.getRegistroIngreso().addActionListener(
                (ActionEvent) -> {
                    int indiceActual = panelEstacionamientos.estActual;
                    if (indiceActual != -1) {
                        JButton actual = estacionamientos.get(indiceActual);

                        controlador.ocuparEstacionamiento(actual, panelEstacionamientos.estActual);
                        panelInformacion.puestosVacios.setText("" + controlador.getPuestosVacios());
                    }
                }
        );

        panelRegistros.getRegistroSalida().addActionListener(
                (ActionEvent) -> {
                    int indiceActual = panelEstacionamientos.estActual;
                    if (indiceActual != -1) {
                        JButton actual = estacionamientos.get(indiceActual);

                        controlador.desocuparEstacionamiento(actual, indiceActual, caja);
                        panelInformacion.puestosVacios.setText("" + controlador.getPuestosVacios());
                        PanelInformacion.valorCaja.setText("$" + caja.getTotalDinero());
                    }
                }
        );

        //----------------------------------------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
