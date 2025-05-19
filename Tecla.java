import greenfoot.*;

public class Tecla extends Actor
{
    private String letra;
    private String lado;
    private boolean presionada = false;

    public Tecla(String lado, String letra) {
        this.lado = lado;
        this.letra = letra;
        mostrarLetra();
    }

    public void act() {
    if (!presionada && Greenfoot.isKeyDown(letra)) {
        presionada = true;

        Actor enemigo = getWorld().getObjects(Enemigo.class).stream()
            .filter(e -> ((Enemigo)e).getLado().equals(lado))
            .findFirst().orElse(null);

        if (enemigo != null) {
            ((Enemigo)enemigo).reducirVida();
        }

        // GUARDAR REFERENCIA AL MUNDO ANTES DE REMOVER
        JuegoFinal mundo = (JuegoFinal)getWorld();
        int x = getX();
        int y = getY();

        mundo.liberarLetra(letra);
        mundo.removeObject(this);  // ahora sí es seguro
        mundo.agregarTecla(lado, x, y);
    }
}


    private void mostrarLetra() {
        setImage(new GreenfootImage(letra.toUpperCase(), 36, Color.YELLOW, new Color(0, 0, 0, 160)));
    }
}
