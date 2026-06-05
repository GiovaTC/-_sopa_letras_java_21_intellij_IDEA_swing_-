import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SopaDeLetrasGUI extends JFrame {

    private final String[][] tablero = {
            {"J","A","V","A","X","P","L","M","N","O"},
            {"Q","W","E","R","T","Y","U","I","O","P"},
            {"S","W","I","N","G","A","B","C","D","E"},
            {"L","K","J","H","G","F","D","S","A","Q"},
            {"M","Y","S","Q","L","Z","X","C","V","B"},
            {"N","M","A","V","E","N","H","J","K","L"},
            {"P","O","R","A","C","L","E","R","T","Y"},
            {"A","S","D","F","G","H","J","K","L","Z"},
            {"C","O","D","I","G","O","X","Y","Z","W"},
            {"T","E","C","N","O","L","O","G","I","A"}
    };

    private final Set<String> palabras = new HashSet<>();
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    
    private JTextField txtPalabra;
    private JList<String> listaEncontradas;
    
    public SopaDeLetrasGUI() {
        
        palabras.add("JAVA");
        palabras.add("SWING");
        palabras.add("MYSQL");
        palabras.add("MAVEN");
        palabras.add("ORACLE");
        palabras.add("CODIGO");
        palabras.add("TECNOLOGIA");
        
        setTitle("Sopa de LETRAS");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        setLayout(new FlowLayout());

        JPanel panelTablero = new JPanel(new GridLayout(10, 10));

        Font fuente = new Font("Arial", Font.BOLD, 18);
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                JLabel letra = new JLabel(
                        tablero[fila][col],
                        SwingConstants.CENTER
                );
                letra.setBorder(
                        BorderFactory.createLineBorder(Color.GRAY)
                );

                letra.setFont(fuente);
                panelTablero.add(letra);
            }
        }
        
    }


}