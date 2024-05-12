import java.util.Scanner;
public class Principal {
    static Scanner scanner = new Scanner(System.in);
    static Moneda moneda;
    static MonedaBusqueda busqueda = new MonedaBusqueda();
    public static void main(String[] args) {
        String entrada;
        int opcion;

        do{
            System.out.println("**************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano)");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("**************************************************");
            System.out.println();

            entrada = scanner.nextLine();

            if(isNumeric(entrada)){
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1 -> generarString("USD", "ARS");
                    case 2 -> generarString("ARS", "USD");
                    case 3 -> generarString("USD", "BRL");
                    case 4 -> generarString("BRL", "USD");
                    case 5 -> generarString("USD", "COP");
                    case 6 -> generarString("COP", "USD");
                    case 7 -> System.out.println("Saliendo...");
                    default -> System.out.println("Seleccione una opción válida");
                }
            }else{
                opcion = 0;
            }
        }while(opcion != 7);
    }
    public static void generarString(String nombreMoneda, String monedaConversion){
        double valor = ingresarValor();
        moneda = busqueda.consulta(nombreMoneda);
        moneda.setNombre(nombreMoneda);
        moneda.setValor(valor);
        moneda.setMonedaConversion(monedaConversion);
        moneda.establecerConversion();
        System.out.println(moneda);
    }
    public static boolean isNumeric(String cadena){
        boolean verdad;
        try{
            Integer.parseInt(cadena);
            verdad = true;
        }catch(NumberFormatException e){
            verdad = false;
            System.out.println("Ingrese únicamente números. " + e.getMessage());
        }
        return verdad;
    }
    public static double ingresarValor(){
        String cadena;
        do{
            System.out.println("Ingrese el valor que desea convertir:");
            cadena = scanner.nextLine();
            if(isNumeric(cadena)){
                return Double.parseDouble(cadena);
            }
        }while(true);
    }
}
