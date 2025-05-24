import greenfoot.*;
import java.util.*;

public class MundoJuego extends World
{
    public static List<String> personajesElegidos = new ArrayList<>();

    public MundoJuego()
    {    
        super(900, 700, 1); 
        setBackground(new GreenfootImage("images/background_principal.jpeg"));

        showText("Elige 2 personajes", getWidth() / 2, 50);

        addObject(new Personaje("Gato1.png"), 200, 400);
        addObject(new Personaje("Gato2.png"), 700, 400);
    }

    public void act() {
        if (personajesElegidos.size() == 2) {
            Greenfoot.setWorld(new JuegoFinal(personajesElegidos));
            personajesElegidos.clear(); // Evita que se repita si vuelves a este mundo
        }
    }
}
