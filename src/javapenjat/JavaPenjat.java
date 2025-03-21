/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this
 * template
 */
package javapenjat;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gmmdl
 */
public class JavaPenjat {
    
  static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        final String[] paraules = {"patata", "armari", "bicicleta", "advocat",
            "ascensor", "astronauta", "autopista", "avinguda", "bigoti",
            "carretera", "castanya", "cervell", "civada", "cultura", "dentista",
            "esquena", "estrella", "formatge", "gendre", "genoll", "infermera",
            "internet", "maduixa", "malaltia", "maluc", "mandarina", "maquinista",
            "motocicleta", "nebot", "pastanaga", "patinet", "perruqueria",
            "pissarra", "professor", "quadrat", "taronja", "tramvia", "trapezi",
            "tricicle", "violeta"};

        int errores = 0;
        Random random = new Random();
        int indexRandom = random.nextInt(paraules.length);
        String palabraRandom = paraules[indexRandom];

        char[] letrasEncontradas = new char[palabraRandom.length()];
        int contador = 0;

        System.out.println(palabraRandom);
        boolean salir = false;
        while (!salir) {
            mostrarDibujo(errores);
            mostrarLetraUsada(letrasEncontradas);
            mostrarPalabraOculta(palabraRandom, letrasEncontradas);
            char letraActual = leerLetra();

            if (letraEncontrada(palabraRandom, letraActual)) {
                int totalLetras = contarLetraEncontrada(palabraRandom, letraActual);
                contador += totalLetras;
            } 
            else{
                errores++;
            }

            letrasEncontradas = insertarOrdenado(letrasEncontradas, letraActual);
            mostrarDibujo(errores);
            netejaPantalla();
            System.out.println(palabraRandom.length());
            System.out.println("ccc" + contador);
            System.out.println("eee"+errores);
            if(errores == 8 || contador >= palabraRandom.length()) {
                salir = true;
            }
        }
        netejaPantalla();
        mostrarDibujo(errores);

        if (errores == 8) {
            System.out.println("OOOOOoooohhhh! Has perdut!!");
            System.out.println("La paraula secreta era: " + palabraRandom);
        } 
        if(contador == palabraRandom.length()) {
            System.out.println("OOOOOoooohhhh! Has Ganat!!");
            System.out.println("La paraula secreta era: " + palabraRandom);
        }
    }

    static void mostrarLetraUsada(char[] arrLetras) {
            
        String resultado = "";
        for (int i = 0; i < arrLetras.length; i++) {
            resultado += arrLetras[i];
        }
        System.out.println("Lletres: " + resultado);
    }

    static char[] insertarOrdenado(char[] array, char nuevaLetra) {
        
        char[] nuevoArray = new char[array.length + 1];
        int i = 0, j = 0;
        
        while (i < array.length && array[i] < nuevaLetra) {
            nuevoArray[j++] = array[i++];
        }        
        nuevoArray[j++] = nuevaLetra;

        while (i < array.length) {
            nuevoArray[j++] = array[i++];
        }

        return nuevoArray;
    }

    static void mostrarPalabraOculta(String palabra, char[] letrasEncontradas) {
        
        String resultado = "";

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            boolean existe = false;
            for (int j = 0; j < letrasEncontradas.length; j++) {
                if (Character.toLowerCase(letrasEncontradas[j]) == Character.toLowerCase(letra)) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                resultado += letra;
            } 
            else {
                resultado += "*";
            }
          }
          System.out.println("Paraula: " + resultado);
    }

    static char leerLetra() {
        
        System.out.print("Introdueix lletra: ");
        return sc.nextLine().charAt(0);
    }

    static int contarLetraEncontrada(String palabraActual, char letraActual) {
        int contador = 0;
        for (int i = 0; i < palabraActual.length(); i++) {
            if (Character.toLowerCase(palabraActual.charAt(i)) == Character.toLowerCase(letraActual)) {
                contador ++;
            }
        }
        return contador;
    }
        
    static Boolean letraEncontrada(String palabraActual, char letraActual) {
        
        for (int i = 0; i < palabraActual.length(); i++) {
            if (Character.toLowerCase(palabraActual.charAt(i)) == Character.toLowerCase(letraActual)) {
                return true;
            }
        }
        return false;
    }

    static void mostrarDibujo(int totalErrores) {

        char[][] dibujo = {
                {' ', ' ', ' ', '_', '_', '_', '_', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '_', '|', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'|', ' ', ' ', ' ', '|', '_', '_', '_', '_', '_', '_', ' '},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '|'}
        };

        if (totalErrores >= 1) {
            dibujo[1][7] = '|';
        }
        if (totalErrores >= 2) {
            dibujo[2][7] = 'O'; 
        }
        if (totalErrores >= 3) {
            dibujo[3][7] = '|'; 
        }
        if (totalErrores >= 4) {
            dibujo[3][6] = '/'; 
        }
        if (totalErrores >= 5) {
            dibujo[3][8] = '\\';
        }
        if (totalErrores >= 6) {
            dibujo[4][7] = '|'; 
        }
        if (totalErrores >= 7) {
            dibujo[5][6] = '/';
        }
        if (totalErrores == 8) {
            dibujo[5][8] = '\\'; 
        }
        String resultado = "";
        for(int i = 0; i < dibujo.length; i++) {
            for(int j = 0; j < dibujo[0].length; j++){
                resultado += dibujo[i][j];
            }
            resultado += "\n";
        }
        
        System.out.println(resultado);
    }

    static void netejaPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
              new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            else{
              System.out.print("\033[H\033[2J");
              System.out.flush();
            }
        } 
        catch (IOException | InterruptedException ex) {
        }
    }
}