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


}