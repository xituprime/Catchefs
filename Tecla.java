import greenfoot.*;
import java.awt.Color;

public class Tecla extends Actor {
    private String letra;
    private String lado;
    private boolean presionada = false;

    public Tecla(String lado, String letra) {
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
        String mostrar = letra;
        switch (letra.toLowerCase()) {
            case "up": mostrar = "↑"; break;
            case "down": mostrar = "↓"; break;
            case "left": mostrar = "←"; break;
            case "right": mostrar = "→"; break;
        }
        setImage(new GreenfootImage(mostrar.toUpperCase(), 36, greenfoot.Color.YELLOW, new greenfoot.Color(0, 0, 0, 160)));
    }
}
