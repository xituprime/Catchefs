import greenfoot.*;

public class Jugador extends Actor
{
    private String lado;

    public Jugador(String imagen, String lado) {
        this.lado = lado;
        setImage(new GreenfootImage("images/" + imagen));
    }

    public String getLado() {
        return lado;
    }
}
