 
   
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.romen.controlador;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Romentoss
 */
public class Vista_ConversorController implements Initializable {
    public boolean Digito = false;
    public boolean Punto = false;
    public double numero;

   
    public double resultado1;
    @FXML
    private Label TextoSalida;
    @FXML
    private TextField TextoEntrada;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EuroDolar(ActionEvent event) {
        
        double resultado= convertirTextoEntrada()*1.17;
        String resultado1 = String.valueOf(resultado);
        TextoSalida.setText(resultado1);  
       
    }

    @FXML
    private void DolarEuro(ActionEvent event, double result) {
        this.resultado1 = result;
        double resultado= convertirTextoEntrada()/1.17;
        String resultado1 = String.valueOf(resultado);
        TextoSalida.setText(resultado1); 
       
    }
    @FXML
    private void Guardar(ActionEvent event) {
    }
    public void insertarConversion(){
         try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/historial","root","root");
            PreparedStatement pr = con.prepareStatement("Insert into operaciones values (null,?,?)");
            
            pr.setDouble(1, numero);
            pr.setDouble(2, resultado1);
            pr.executeUpdate();
        } 
        catch (SQLException e) {
            System.out.println(e.toString());
        } 
    }
    public double convertirTextoEntrada(){
        String texto = TextoEntrada.getText();
        double numer = Double.parseDouble(texto);
        return numer;
    }
    
   
}
    

