import greenfoot.*;
import java.util.*;

public class JuegoFinal extends World {
    private Jugador jugador1;
    private Jugador jugador2;
    private Enemigo enemigo1;
    private Enemigo enemigo2;

    private int ronda = 1;
    private int puntajeJugador1 = 0;
    private int puntajeJugador2 = 0;

    private List<String> enemigos = Arrays.asList("Enemigo1.png", "Enemigo2.png", "Enemigo3.png", "Enemigo4.png");
    private String personaje1;
    private String personaje2;

    private Set<String> letrasEnUso = new HashSet<>();

    public JuegoFinal(List<String> personajes) {
        super(900, 700, 1);
        personaje1 = personajes.get(0);
        personaje2 = personajes.get(1);
        iniciarRonda();
    }

    public JuegoFinal(List<String> personajes, int ronda, int p1, int p2) {
        super(900, 700, 1);
        this.ronda = ronda;
        personaje1 = personajes.get(0);
        personaje2 = personajes.get(1);
        puntajeJugador1 = p1;
        puntajeJugador2 = p2;
        iniciarRonda();
    }

    private void iniciarRonda() {
        // Fondo con línea divisoria
        GreenfootImage fondo = new GreenfootImage("images/background_principal.jpeg");
        fondo.setColor(Color.WHITE);
        fondo.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        setBackground(fondo);

        letrasEnUso.clear();

        jugador1 = new Jugador(personaje1, "izquierda");
        jugador2 = new Jugador(personaje2, "derecha");

        addObject(jugador1, 225, 500);
        addObject(jugador2, 675, 500);

        String enemigoImg = enemigos.get(ronda - 1);
        enemigo1 = new Enemigo(enemigoImg, "izquierda", "Jugador 1", 225, 150);
        enemigo2 = new Enemigo(enemigoImg, "derecha", "Jugador 2", 675, 150);

        addObject(enemigo1, 225, 250);
        addObject(enemigo2, 675, 250);

        enemigo1.actualizarTextoIngredientes();
        enemigo2.actualizarTextoIngredientes();

        agregarTecla("izquierda", 225, 620);
        agregarTecla("derecha", 675, 620);
    }

    public void act() {
        if (enemigo1.getIngredientesNecesarios() <= 0 && enemigo2.getIngredientesNecesarios() > 0) {
            puntajeJugador1 += 3;
            puntajeJugador2 += 1;
            mostrarPantallaGanador("Jugador 1 ganó la ronda " + ronda);
        } else if (enemigo2.getIngredientesNecesarios() <= 0 && enemigo1.getIngredientesNecesarios() > 0) {
            puntajeJugador2 += 3;
            puntajeJugador1 += 1;
            mostrarPantallaGanador("Jugador 2 ganó la ronda " + ronda);
        } else if (enemigo1.getIngredientesNecesarios() <= 0 && enemigo2.getIngredientesNecesarios() <= 0) {
            puntajeJugador1 += 2;
            puntajeJugador2 += 2;
            mostrarPantallaGanador("Empate en la ronda " + ronda);
        }
    }

    private void mostrarPantallaGanador(String mensaje) {
        Greenfoot.setWorld(new PantallaIntermedia(mensaje, this));
    }

    public void continuarRonda() {
        ronda++;
        if (ronda <= 4) {
            Greenfoot.setWorld(new JuegoFinal(Arrays.asList(personaje1, personaje2), ronda, puntajeJugador1, puntajeJugador2));
        } else {
            String ganador = "Empate";
            if (puntajeJugador1 > puntajeJugador2) ganador = "Jugador 1 es el ganador final";
            else if (puntajeJugador2 > puntajeJugador1) ganador = "Jugador 2 es el ganador final";
            Greenfoot.setWorld(new Ganador(ganador));
        }
    }

    public void agregarTecla(String lado, int x, int y) {
        String letra = obtenerLetraUnica();
        letrasEnUso.add(letra);
        addObject(new Tecla(lado, letra), x, y);
    }

    public void liberarLetra(String letra) {
        letrasEnUso.remove(letra);
    }

    private String obtenerLetraUnica() {
        String[] todasLetras = {
            "a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z",
            "up","down","left","right","space","enter","shift","control","alt"
        };

        List<String> disponibles = new ArrayList<>();
        for (String letra : todasLetras) {
            if (!letrasEnUso.contains(letra)) {
                disponibles.add(letra);
            }
        }

        if (disponibles.isEmpty()) return "z"; // fallback
        return disponibles.get(Greenfoot.getRandomNumber(disponibles.size()));
    }

    public int getPuntajeJugador1() {
        return puntajeJugador1;
    }

    public int getPuntajeJugador2() {
        return puntajeJugador2;
    }
}
