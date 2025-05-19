import greenfoot.*;
import java.util.*;

public class JuegoFinal extends World
{
    private Jugador jugador1;
    private Jugador jugador2;
    private Enemigo enemigo1;
    private Enemigo enemigo2;
    
    private Set<String> letrasEnUso = new HashSet<>();
    private Random rand = new Random();

    public JuegoFinal(List<String> personajes)
    {
        super(900, 700, 1);
        setBackground(new GreenfootImage("images/background_principal.jpeg"));

        jugador1 = new Jugador(personajes.get(0), "izquierda");
        jugador2 = new Jugador(personajes.get(1), "derecha");

        addObject(jugador1, 225, 500);
        addObject(jugador2, 675, 500);

        enemigo1 = new Enemigo("Enemigo1.png", "izquierda");
        enemigo2 = new Enemigo("Enemigo2.png", "derecha");

        addObject(enemigo1, 225, 250);
        addObject(enemigo2, 675, 250);

        // Agregar teclas iniciales
        agregarTecla("izquierda", 225, 620);
        agregarTecla("derecha", 675, 620);
    }

    public void act() {
        if (enemigo1.getVida() <= 0 && enemigo2.getVida() > 0) {
            Greenfoot.setWorld(new Ganador("¡Jugador 1 ganó!"));
        } else if (enemigo2.getVida() <= 0 && enemigo1.getVida() > 0) {
            Greenfoot.setWorld(new Ganador("¡Jugador 2 ganó!"));
        }
    }

    public void agregarTecla(String lado, int x, int y) {
        String letra = generarLetraUnica();
        letrasEnUso.add(letra);
        addObject(new Tecla(lado, letra), x, y);
    }

    public void liberarLetra(String letra) {
        letrasEnUso.remove(letra);
    }

    private String generarLetraUnica() {
        List<String> disponibles = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String s = String.valueOf(c);
            if (!letrasEnUso.contains(s)) {
                disponibles.add(s);
            }
        }

        if (disponibles.isEmpty()) return "z"; // fallback
        return disponibles.get(rand.nextInt(disponibles.size()));
    }
}
