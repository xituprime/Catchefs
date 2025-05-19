import greenfoot.*;

/**
 * Representa un personaje seleccionable.
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
            if (MundoJuego.personajesElegidos.size() < 2 &&
                !MundoJuego.personajesElegidos.contains(imagen)) {

                MundoJuego.personajesElegidos.add(imagen);
                System.out.println("Seleccionado: " + imagen);

                // Opcional: cambiar visualmente al personaje elegido
                setImage(new GreenfootImage("images/" + imagen)); // o mostrar marco o texto
            }
        }
    }
}
