import greenfoot.*;

public class Ganador extends World {

    public Ganador(String mensaje) {
        super(900, 700, 1);
        setBackground(new GreenfootImage("images/background_principal.jpeg"));

        // Mostrar mensaje en la parte superior
        showText(mensaje, getWidth() / 2, 100);

        // Agregar imagen del juez (debe existir en tu carpeta "images")
        GreenfootImage imgJuez = new GreenfootImage("images/jurado.png");
        Actor juez = new Actor() {
            { setImage(imgJuez); }
        };
        addObject(juez, getWidth() / 2, getHeight() / 2);
    }
}
