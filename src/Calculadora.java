import java.util.Scanner;
import java.util.StringTokenizer;



/**
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class Calculadora {
    static Compilador comp;
   

    public static void calculadora() throws ErrorDeSintaxisException{
        boolean continuar=true;
        comp=new Compilador();
        
        while (continuar) {
            boolean respuesta2=true;
        Scanner sc1=new Scanner(System.in);
           System.out.println("Ingresa la operacion a realizar: \nrecuerda que los operadores son +,-,*,/,s,t,c,r" );
           try{
                String cadena=sc1.nextLine();
                StringTokenizer lexemas = comp.analisisLexico(cadena);
                CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
                System.out.println(nodo);
                System.out.println(nodo.evalua());
           } catch(ErrorDeSintaxisException ese){
                System.out.println("El formato usado no es valido  ");
                continuar=true;
           }
           
            while (respuesta2) {
                System.out.println("Quieres realizar otra operacion? \n-yes\n-no");
                String respuesta=sc1.nextLine();
                switch (respuesta) {
                case "yes":
                    continuar=true;
                    respuesta2=false;
                    break;
                case "no":
                    continuar=false;
                    respuesta2=false;
                    break;
                default:
                    System.out.println("Por favor ingresa yes o no ");
                    respuesta2=true;
                    break;
                }
            }
            
            
            
            
                
            
        }
        


    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ErrorDeSintaxisException {
        calculadora();
    }
}