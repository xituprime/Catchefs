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
    
    //teclas permitidas
    private String[] teclasIzquierda = {"w","a","s","d"};
    private String[] teclasDerecha = {"up","down","left","right"};
    
    public JuegoFinal(List<String> personajes)
    {
        super(900, 700, 1);
        setBackground(new GreenfootImage("images/background_principal.jpeg"));

        jugador1 = new Jugador(personajes.get(0), "izquierda");
        jugador2 = new Jugador(personajes.get(1), "derecha");

        addObject(jugador1, 225, 500);
        addObject(jugador2, 675, 500);

        enemigo1 = new Enemigo("Enemigo1.png", "izquierda", "Jugador 1", 225, 150);
        enemigo2 = new Enemigo("Enemigo2.png", "derecha", "Jugador 2", 675, 150);

        addObject(enemigo1, 225, 250);
        addObject(enemigo2, 675, 250);
        
        // Mostrar ingredientes iniciales
        enemigo1.actualizarTextoIngredientes();
        enemigo2.actualizarTextoIngredientes();

        // Agregar teclas iniciales
        agregarTecla("izquierda", 225, 620);
        agregarTecla("derecha", 675, 620);
    }

    public void act() {
        // Verificar quién completó todos los ingredientes primero
        if (enemigo1.getIngredientesNecesarios() <= 0 && enemigo2.getIngredientesNecesarios() > 0) {
            Greenfoot.setWorld(new Ganador("¡" + enemigo1.getNombre() + " completó la receta primero!"));
        } else if (enemigo2.getIngredientesNecesarios() <= 0 && enemigo1.getIngredientesNecesarios() > 0) {
            Greenfoot.setWorld(new Ganador("¡" + enemigo2.getNombre() + " completó la receta primero!"));
        } else if (enemigo1.getIngredientesNecesarios() <= 0 && enemigo2.getIngredientesNecesarios() <= 0) {
            Greenfoot.setWorld(new Ganador("¡Empate! Ambos completaron la receta"));
        }
    }

    public void agregarTecla(String lado, int x, int y) {
        String letra = generarLetraAleatoria(lado);
        if(letra != null){
            letrasEnUso.add(letra);
            addObject(new Tecla(lado,letra), x,y);
        }
    }

    public void liberarLetra(String letra) {
        letrasEnUso.remove(letra);
    }

    private String generarLetraAleatoria(String lado) {    
        if(lado.equals("izquierda")) {
        String[] letrasValidas = {"w", "a", "s", "d"};
        return letrasValidas[Greenfoot.getRandomNumber(letrasValidas.length)];
        }
        else if(lado.equals("derecha")) {
            String[] flechasValidas = {"up", "down", "left", "right"};
            return flechasValidas[Greenfoot.getRandomNumber(flechasValidas.length)];
        }
        return null;  // En caso de que el lado no sea válido
    }
}

