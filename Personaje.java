import greenfoot.*;

/**
 * Representa un personaje seleccionable con imagen.
 */
public class Personaje extends Actor
{
    private String imagen;

    public Personaje(String imagen) {
        this.imagen = imagen;
        setImage(new GreenfootImage("images/" + imagen));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("Seleccionaste al personaje: " + imagen);
            // Aquí puedes hacer algo como iniciar el juego con este personaje
        }
    }
}
