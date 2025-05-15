import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo principal del juego MiniDiversión.
 * Este es el menú de inicio donde puedes comenzar a jugar.
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        super(900, 700, 1); 
        setBackground(new GreenfootImage("images/background_principal.jpeg"));
        
        // Agregar botón al centro de la pantalla
        BotonIniciar boton = new BotonIniciar();
        addObject(boton, getWidth() / 2, getHeight() / 2);
    }
}
