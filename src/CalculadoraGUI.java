import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculadoraGUI extends JFrame {
    private JTextField display;
    static Compilador comp;

    public CalculadoraGUI() {
        super("Calculadora");

        // Alo esta es la ventana de la calculadora
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(true);
        add(display, BorderLayout.NORTH);
        //aqui se configuran los botones 
        JPanel panelBotones = new JPanel(new GridLayout(6, 4));

        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "s", "t", "c", "r",
                "CE", "C"
        };

        for (String textoBoton : botones) {
            JButton boton = new JButton(textoBoton);
            boton.addActionListener(new BotonClickListener());
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    private class BotonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            String textoBoton = src.getText();

            switch (textoBoton) {
                case "=":
                    calcularResultado();
                    break;
                case "CE":
                    display.setText("");
                    break;
                case "C":
                    borrarUltimoCaracter();
                    break;
                default:
                    display.setText(display.getText() + textoBoton);
                    break;
            }
        }

        private void calcularResultado() {
            try {
                String cadena = display.getText();
                StringTokenizer lexemas = comp.analisisLexico(cadena);
                CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
                display.setText(String.valueOf(nodo.evalua()));
            } catch (ErrorDeSintaxisException ese) {
                display.setText("Error de sintaxis");
            }
        }

        private void borrarUltimoCaracter() {
            String textoActual = display.getText();
            if (textoActual.length() > 0) {
                display.setText(textoActual.substring(0, textoActual.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        comp = new Compilador(); // Crear una instancia de Compilador
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculadoraGUI = new CalculadoraGUI();
            calculadoraGUI.setVisible(true);
        });
    }
}


