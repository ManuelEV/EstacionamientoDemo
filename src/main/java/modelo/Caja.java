package modelo;

public class Caja {

    private int totalDinero;
    private final int precioPorMinuto;

    public Caja(int precioPorMinuto) {
        this.totalDinero=0;
        this.precioPorMinuto = precioPorMinuto;
    }

    public int calcularTarifa(int minutos) {
        
        int tarifa = minutos*this.precioPorMinuto;
        
        this.totalDinero+=tarifa;
        
        return tarifa;
    }

    public int getTotalDinero() {
        return this.totalDinero;
    } 
    
}
