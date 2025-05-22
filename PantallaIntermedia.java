import greenfoot.*;

public class PantallaIntermedia extends World {
    private JuegoFinal juego;

    public PantallaIntermedia(String mensaje, JuegoFinal juego) {
        super(900, 700, 1);
        this.juego = juego;
        setBackground(new GreenfootImage("images/background_principal.jpeg"));

        showText(mensaje, getWidth() / 2, getHeight() / 2 - 60);
        showText("Presiona ENTER para continuar a la siguiente ronda", getWidth() / 2, getHeight() / 2);

        // Mostrar puntajes de los jugadores
        showText("Puntaje Jugador 1: " + juego.getPuntajeJugador1(), getWidth() / 2, getHeight() / 2 + 60);
        showText("Puntaje Jugador 2: " + juego.getPuntajeJugador2(), getWidth() / 2, getHeight() / 2 + 100);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            juego.continuarRonda();
        }
    }
}
