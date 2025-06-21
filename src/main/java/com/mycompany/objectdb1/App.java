package com.mycompany.objectdb1;

import com.mycompany.objectdb1.modelo.vista.EstudianteFrame;

import javax.swing.*;
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        }catch(Exception e){
            System.out.println("Error al iniciar la aplicacion: " + e.getMessage());
        }
        //Ejecutar en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            EstudianteFrame estudianteFrame = new EstudianteFrame();
            estudianteFrame.setVisible(true);
        });
    }
    
}
