package RA6.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        OperacionesCRUD crud = new OperacionesCRUD();
        Menu menu = new Menu(crud);
        menu.iniciar();
    }
}