import greenfoot.*;
import java.util.Arrays;
import java.awt.Color;

public class Tecla extends Actor
{
    private String letra;
    private String lado;
    private boolean presionada = false;
    private static final String[] TECLAS_IZQUIERDA = {"w", "a", "s", "d"};
    private static final String[] TECLAS_DERECHA = {"up", "down", "left", "right"};

    public Tecla(String lado, String letra) {
        // Validar que la tecla corresponda al lado correcto
        if (lado.equals("izquierda") && !Arrays.asList(TECLAS_IZQUIERDA).contains(letra.toLowerCase())) {
            throw new IllegalArgumentException("Tecla no válida para el jugador izquierdo: " + letra);
        }
        else if (lado.equals("derecha") && !Arrays.asList(TECLAS_DERECHA).contains(letra.toLowerCase())) {
            throw new IllegalArgumentException("Tecla no válida para el jugador derecho: " + letra);
        }
        
        this.lado = lado;
        this.letra = letra;
        mostrarLetra();
    }

    public void act() {
        if (!presionada && Greenfoot.isKeyDown(letra)) {
            presionada = true;

            Actor enemigo = getWorld().getObjects(Enemigo.class).stream()
                .filter(e -> ((Enemigo)e).getLado().equals(lado))
                .findFirst().orElse(null);

            if (enemigo != null) {
                ((Enemigo)enemigo).reducirIngredientes();
            }

            JuegoFinal mundo = (JuegoFinal)getWorld();
            int x = getX();
            int y = getY();

            mundo.liberarLetra(letra);
            mundo.removeObject(this);
            mundo.agregarTecla(lado, x, y);
        }
    }

    private void mostrarLetra() {
        // Mostrar las flechas como símbolos en lugar de texto
        String imagenLetra = letra;
        if (lado.equals("derecha")) {
            switch (letra.toLowerCase()) {
                case "up":    imagenLetra = "↑"; break;
                case "down":  imagenLetra = "↓"; break;
                case "left":  imagenLetra = "←"; break;
                case "right": imagenLetra = "→"; break;
            }
        }
        setImage(new GreenfootImage(imagenLetra.toUpperCase(), 36, greenfoot.Color.YELLOW, new greenfoot.Color(0, 0, 0, 160)));
    }
}