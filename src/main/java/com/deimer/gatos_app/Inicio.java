/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deimer.gatos_app;

import javax.swing.JOptionPane;

/**
 *
 * @author deime
 */
public class Inicio {
    
    public static void main(String[] args) {
        int opcion_menu = -1;
        String[] botones = {"1. Ver gatos.", "2. Salir"};
        
        do {
            //Menú principal
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menu Principal", JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            
            //validamos que opcion selecciona el Usuario
            for (int i=0; i<botones.length; i++){
                if (opcion.equals(botones[i])){
                    opcion_menu = i;
                }
            }
            
            switch (opcion_menu){
                case 0:
                    break;
                default:
                    break;
            }
            
        } while (opcion_menu != 1);
    }
    
}
