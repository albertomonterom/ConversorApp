import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Moneda {
    private String nombre ;
    private double valor;
    private String monedaConversion;
    private double conversion;
    @SerializedName("conversion_rates")
    private Map<String, Double> map;
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMonedaConversion(String monedaConversion) {
        this.monedaConversion = monedaConversion;
    }
    public Moneda(){}
    public void establecerConversion(){
        map.forEach((moneda, tasa) -> {
            if(moneda.equals(monedaConversion)){
                conversion = tasa * valor;
            }
        });
    }

    @Override
    public String toString(){
        return String.format("El valor %.1f [%s] corresponde al valor final de =>>> %.2f [%s]", valor, nombre, conversion, monedaConversion);
    }
}
