import greenfoot.*;

/**
 * Botón para iniciar el juego.
 */
public class BotonIniciar extends Actor
{
    public BotonIniciar() {
        // Texto como imagen del botón
        setImage(new GreenfootImage("Iniciar Partida", 36, Color.WHITE, new Color(0, 0, 0, 160)));
        
        // Si prefieres usar una imagen personalizada, puedes usar esta línea en su lugar:
        // setImage(new GreenfootImage("images/boton_iniciar.png"));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MundoJuego());  // Cambia al mundo del juego
        }
    }
}
