import greenfoot.*;

public class Enemigo extends Actor
{
    private int vida = 5;
    private String lado;

    public Enemigo(String imagen, String lado) {
        setImage(new GreenfootImage("images/" + imagen));
        this.lado = lado;
    }

    public int getVida() {
        return vida;
    }

    public void reducirVida() {
        vida--;
        System.out.println("[" + lado + "] Vida restante del enemigo: " + vida);
    }

    public String getLado() {
        return lado;
    }
}
