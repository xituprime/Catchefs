import greenfoot.*;

public class Ganador extends World
{
    public Ganador(String mensaje)
    {
        super(900, 700, 1);
        setBackground(new GreenfootImage("images/background_principal.jpeg"));
        showText(mensaje, getWidth()/2, getHeight()/2);
    }
}
