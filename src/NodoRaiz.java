import java.lang.Math;
public class NodoRaiz extends NodoOperador {
    /**
     *
     * @param izq
     * @param der
     */
    public NodoRaiz(CompositeEA izq, CompositeEA der) {
        super(null, der);
        precedence = 1;
    }


    /**
     
La evaluación del seno del nodo derecho 
@return*/@Override
public double evalua() {
     return Math.sqrt(der.evalua());}
}
