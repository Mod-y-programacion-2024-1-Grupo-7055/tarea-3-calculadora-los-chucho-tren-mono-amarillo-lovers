import java.lang.Math;
public class NodoCoseno extends NodoOperador{
    /**
     *
     * @param izq
     * @param der
     */
    public NodoCoseno(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence = 1;
    }


    /**
     
La evaluación del seno del nodo derecho 
@return*/@Override
public double evalua() {
     return Math.cos(der.evalua());}
}
