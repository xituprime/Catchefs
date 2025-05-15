import greenfoot.*;

/**
 * Este es el mundo del juego que se carga al iniciar partida.
 */
public class MundoJuego extends World
{
    public MundoJuego()
    {    
        super(900, 700, 1); 
        setBackground(new GreenfootImage("images/background_principal.jpeg"));
        // Mostrar texto "Elige un personaje"
        showText("Elige un personaje", getWidth() / 2, 50);

        // Agregar varios personajes con distintas imágenes
        addObject(new Personaje("Gato1.png"), 200, 400);
        addObject(new Personaje("Gato2.png"), 450, 400);
    }
}
