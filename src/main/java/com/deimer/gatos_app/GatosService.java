/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deimer.gatos_app;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author deime
 */
public class GatosService {
    
    public static void verGatos() throws IOException{
        //1. vamos a traer los datod de la API
        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
        
        Response response = client.newCall(request).execute();
        
        String elJson = response.body().string();
        //Quitar los corchetes con los que la API envía los datos
        elJson = elJson.substring(1, elJson.length()-1);
        
        //crear objeto de la clase Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);
        
        //redimensionar en caso de necesitar
        Image image = null;
        try{
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            
            ImageIcon fondoGato = new ImageIcon(image);
            
            if (fondoGato.getIconWidth() > 800){
                // redimensionamos
                Image fondo = fondoGato.getImage();
                Image modificada =  fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            
            String menu = "Opciones: \n"
                    +"1. Ver otra imagen \n"
                    +"2. Favorito \n"
                    +"3. Volver \n";
            
            String[] botones = {"Ver otra imagen", "Favorito", "Volver"};
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);
            
            int seleccion = -1;
            
            for(int i=0; i<botones.length; i++){
                if (opcion.equals(botones[i])){
                    seleccion = i;
                }
            }
            
            switch (seleccion){
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;                
            }
            
        } catch(IOException e){
            System.out.println(e);
            
        }
        
        
        
    }

    public static void favoritoGato(Gatos gatos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
