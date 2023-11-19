import java.lang.Math;
public class NodoTangente extends NodoOperador {
    /**
     *
     * @param izq
     * @param der
     */
    public NodoTangente(CompositeEA izq, CompositeEA der) {
        super(null, der);
        precedence = 1;
    }


    /**
     
La evaluación de la tangente del nodo derecho 
@return*/@Override
public double evalua() {
     return Math.tan(der.evalua());}
}
