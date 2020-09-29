/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.romen.modelo;

import es.iespuertodelacruz.romen.controlador.Vista_ConversorController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Romentoss
 */
public class DAWmvcRomenConversor extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
       FXMLLoader loader = new  FXMLLoader(getClass().getResource("/es/iespuertodelacruz/romen/vista/vista_conversor.fxml"));
        loader.setController(new Vista_ConversorController());
        Pane mainPane = loader.load(); 
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/imagenes/euro.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/historialconversor","root","root");
            
            Statement mySt = con.createStatement();
            ResultSet myRt = mySt.executeQuery("select * from conversiones");
            
        
            while (myRt.next()) {
                System.out.println(myRt.getString("Id")+".El valor a convertir: "+myRt.getString("Valor")+" con una conversión de "+myRt.getString("Conversion")+" da como resultado: "+
                        myRt.getString("Resultado"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
    
}
