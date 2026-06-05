# -_sopa_letras_java_21_intellij_IDEA_swing_- :.
# Sopa de Letras en Java 21 + IntelliJ IDEA + Swing:

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/9447da14-5492-4eab-834d-fa70fab921cb" />  

```
Proyecto completo desarrollado en **Java 21** utilizando **Swing (Interfaz Gráfica)** para implementar una **Sopa de Letras** interactiva.

## Características

- Interfaz gráfica desarrollada con Swing.
- Matriz de letras de 10x10.
- Palabras ocultas predefinidas.
- Campo de texto para buscar palabras.
- Botón para verificar coincidencias.
- Lista dinámica de palabras encontradas.
- Mensajes emergentes de éxito o error.
- Compatible con IntelliJ IDEA y Java 21.

---

# Estructura del Proyecto

```text
SopaDeLetras/
│
└── src/
    │
    └── SopaDeLetrasGUI.java
```

---

# Código Completo

```java
import javax.swing.*;
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

        setTitle("Sopa de Letras");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        setLayout(new BorderLayout());

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

        add(panelTablero, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());

        JLabel lblBuscar = new JLabel("Palabra:");

        txtPalabra = new JTextField(15);

        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.addActionListener(e -> buscarPalabra());

        panelInferior.add(lblBuscar);
        panelInferior.add(txtPalabra);
        panelInferior.add(btnBuscar);

        add(panelInferior, BorderLayout.SOUTH);

        JPanel panelDerecho = new JPanel(new BorderLayout());

        JLabel lblEncontradas = new JLabel("Encontradas");

        listaEncontradas = new JList<>(modeloLista);

        panelDerecho.add(lblEncontradas, BorderLayout.NORTH);
        panelDerecho.add(
                new JScrollPane(listaEncontradas),
                BorderLayout.CENTER
        );

        add(panelDerecho, BorderLayout.EAST);
    }

    private void buscarPalabra() {

        String palabra = txtPalabra.getText()
                .trim()
                .toUpperCase();

        if (palabra.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una palabra."
            );

            return;
        }

        if (palabras.contains(palabra)) {

            if (!modeloLista.contains(palabra)) {

                modeloLista.addElement(palabra);

                JOptionPane.showMessageDialog(
                        this,
                        "Palabra encontrada: " + palabra
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "La palabra ya fue encontrada."
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Palabra no encontrada."
            );
        }

        txtPalabra.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            SopaDeLetrasGUI ventana =
                    new SopaDeLetrasGUI();

            ventana.setVisible(true);

        });
    }
}
```

---

# Palabras Ocultas

Las palabras disponibles dentro de la sopa de letras son:

```text
JAVA
SWING
MYSQL
MAVEN
ORACLE
CODIGO
TECNOLOGIA
```

---

# Cómo Ejecutarlo en IntelliJ IDEA

## 1. Abrir IntelliJ IDEA

Inicie IntelliJ IDEA y seleccione:

```text
New Project
```

---

## 2. Crear Proyecto Java 21

Configure:

```text
Language: Java
JDK: 21
Build System: IntelliJ
```

---

## 3. Crear la Clase Principal

Dentro de la carpeta `src`, cree la clase:

```text
SopaDeLetrasGUI
```

---

## 4. Ejecutar la Aplicación

Desde IntelliJ IDEA:

```text
Run > Run 'SopaDeLetrasGUI'
```

O utilizando el atajo:

```text
Shift + F10
```

---

# Resultado Esperado

La aplicación mostrará una ventana similar a la siguiente:

```text
+--------------------------------------+
| J A V A X P L M N O                  |
| Q W E R T Y U I O P                  |
| S W I N G A B C D E                  |
| ...                                  |
|                                      |
|                  Encontradas         |
|                  JAVA                |
|                  SWING               |
|                                      |
+--------------------------------------+

Palabra: [___________] [Buscar]
```

---

# Funcionamiento

1. El usuario escribe una palabra en el campo de texto.
2. Presiona el botón **Buscar**.
3. El sistema valida si la palabra pertenece al conjunto de palabras ocultas.
4. Si existe:
   - Se agrega a la lista de encontradas.
   - Se muestra un mensaje de éxito.
5. Si ya fue encontrada:
   - Se muestra una advertencia.
6. Si no existe:
   - Se informa que la palabra no fue encontrada.
7. La lista lateral se actualiza automáticamente.

---

# Tecnologías Utilizadas

- Java 21
- Swing
- IntelliJ IDEA
- Colecciones (`HashSet`)
- Componentes GUI (`JFrame`, `JPanel`, `JButton`, `JLabel`, `JList`)
- Layout Managers (`BorderLayout`, `GridLayout`, `FlowLayout`)

---

# Autor

Proyecto académico de ejemplo para la implementación de una **Sopa de Letras con Interfaz Gráfica en Java Swing**, utilizando Java 21 e IntelliJ IDEA .
:. . / .
