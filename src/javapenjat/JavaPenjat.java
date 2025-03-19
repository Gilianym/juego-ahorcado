/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javapenjat;

import java.io.IOException;

/**
 *
 * @author gmmdl
 */
public class JavaPenjat {

    public static void main(String[] args) {
        
        final String[] paraules = {"patata","armari","bicicleta",
                            "advocat","ascensor","astronauta","autopista",
                            "avinguda","bigoti","carretera","castanya",
                            "cervell","civada","cultura","dentista","esquena",
                            "estrella","formatge","gendre","genoll",
                            "infermera","internet","maduixa","malaltia",
                            "maluc","mandarina","maquinista","motocicleta",
                            "nebot","pastanaga","patinet","perruqueria",
                            "pissarra","professor","quadrat","taronja",
                            "tramvia","trapezi","tricicle","violeta"};
        
        
String[][] penjat =   {
            { "   ____", "", "", ""},
            { "  |", "   |", "", "", ""},
            { "  |", "   0", "", ""},
            { "  |", "  /", "|", "\\"},
            { "  |", "", "", ""},
            { "  |", "", "", ""},
            { " _|_", "", "", ""},
            {"|   |______", "", "", ""},
            {"|          |", "", "", ""},
            {"|__________|", "", "", ""},
        };
    
    int totalError = 0;
    for(int i = 0; i< penjat.length; i++) {
        System.out.print(penjat[i][0]);
        for(int j = 0; j < penjat[i].length; j++) {
            String valora = penjat[i][j];
            if(valora == printarErrores(totalError)) {
                System.out.print(printarErrores(totalError));
            }
        }
        System.out.println("");
        
    }
    }
    
    
    
    static String printarErrores(int numeroError) {
        String[] errores = { "|", "0", "|", "/", "\\", "|", "/", "\\", };
        return errores[numeroError];
    }
    
    
    static void netejaPantalla() {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
    	       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
    		System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {}     
    }
    
}
