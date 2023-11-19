import java.lang.Math;
public class NodoSeno extends NodoOperador{
 /**
     *
     * @param izq
     * @param der
     */
    public NodoSeno(CompositeEA izq, CompositeEA der) {
        super(null, der);
        precedence = 1;
    }


    /**
     
La evaluación del seno del nodo derecho 
@return*/@Override
public double evalua() {
     return Math.sin(der.evalua());}
}