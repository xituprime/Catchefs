import greenfoot.*;

public class Enemigo extends Actor {
    private int vidas = 20; // Cambiamos "vida" por "ingredientesNecesarios"
    private String lado;
    private String nombre;
    private int textoX;
    private int textoY;
    private boolean primeraActualizacion = true;

    public Enemigo(String imagen, String lado, String nombre, int textoX, int textoY) {
        setImage(new GreenfootImage("images/" + imagen));
        this.lado = lado;
        this.nombre = nombre;
        this.textoX = textoX;
        this.textoY = textoY;
    }

    public void act() {
        if (primeraActualizacion) {
            actualizarTextoIngredientes();
            primeraActualizacion = false;
        }
    }

    public void reducirIngredientes() { // Cambiado de reducirVida()
        vidas--;
        actualizarTextoIngredientes();
        
        if (vidas <= 0) {
            // Lógica cuando se consiguen todos los ingredientes
            getWorld().showText(nombre + " ¡Receta completa!", textoX, textoY - 30);
        }
    }

    public void actualizarTextoIngredientes() {
        if (getWorld() != null) {
            getWorld().showText(nombre + ": " + vidas + " vidas", textoX, textoY);
        }
    }
    
    public String getNombre(){
        return nombre;
    }

    public int getIngredientesNecesarios() { return vidas; }
    public String getLado() { return lado; }
}