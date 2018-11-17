package modelo;

import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControladorEstacionamiento {

    private int puestosVacios;
    private final long registroIngreso[];

    public ControladorEstacionamiento(int cantidadEstacionamientos) {
        puestosVacios = cantidadEstacionamientos;
        registroIngreso = new long[cantidadEstacionamientos];
    }

    public int getPuestosVacios() {
        return puestosVacios;
    }

    public void ocuparEstacionamiento(JButton est, int indice) {
            if (est.getBackground() == Color.blue) {
                est.setBackground(Color.red);

                Date fecha = new Date();

                this.registroIngreso[indice] = fecha.getTime();
                this.puestosVacios--;

                dialogoIngreso(indice);
            }
    }

    public void desocuparEstacionamiento(JButton est, int indice, Caja caja) {
            if (est.getBackground() == Color.RED) {
                est.setBackground(Color.blue);

                Date fecha = new Date();
                long time = fecha.getTime();

                long ingreso = this.registroIngreso[indice];

                int tarifa = caja.calcularTarifa(calcularMinutos(ingreso, time));

                dialogoSalida(indice, tarifa);

                this.puestosVacios++;
            }
    }

    //pasar de diferencia de 2 fechas a minutos
    private int calcularMinutos(long ingreso, long salida) {

        int diferencia = (int) ((salida - ingreso) / 1000);

        int minutos = (int) Math.floor(diferencia / 60);

        return minutos;
    }

    public void dialogoIngreso(int estActual) {
        JOptionPane.showMessageDialog(null, "El estacionamiento " + (estActual + 1) + " ha sido ocupado");
    }

    public void dialogoSalida(int estActual, int tarifa) {
        JOptionPane.showMessageDialog(null, "El estacionamiento " + (estActual + 1) + " ha sido desocupado"
                + "\nSe ha agregado a la caja: $" + tarifa);
    }

}
