package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;


public class Modelo extends Conexion {
    
    public boolean agregarRegistro(int cafe, int tamano, int leche, int azucar, int total, String fecha){
        String query="insert into taller4.registro( idCafe, idLeche, idAzucar, idVaso, totalVenta, fechaVenta) values"
                + "('"+cafe+"','"+leche+"','"+azucar+"','"+tamano+"','"+total+"','"+fecha+"');";
        try{
            PreparedStatement pstm = this.getConexion().prepareStatement(query);
            pstm.execute();
            pstm.close();
            return true;            
        }catch(SQLException e){
                System.err.println( e.getMessage() );}
        return false;
        
    }
    /*
    === weas de producto===
    1 cafe Expresso
    2 cafe Latte
    3 cafe  Capuchino
    4 cafe Moka
    5 Chocolate Caliente
    
    ===weas de tamaño===
    6 Pequeño vaso S
    7 Mediano vaso M
    8 Grande vaso L
    
    ====azucar ====
    9 Sin azucar
    10 Con Azucar
    11 Extra Azucar(no pertenece al inventario) equivale al item azucar
    
    ===Lechita ===
    12 Sin Leche
    13 leche entera
    14 leche descremada
    15 leche soya
    */
    
    
    public boolean modificarInventario(String bebida, int idVaso, int idLeche, int idAzucar){
        int aux=0;
        double mult=0;
        double propCafe=0;
        double propChoc=0;
        double propLeche=0;
        int cucharada=1;
        if(idAzucar==13){
            idAzucar=5;
            cucharada=2;
        }
        if(idVaso == 10){
               mult=1;
            }
        if(idVaso == 11){
                mult=1.5;
            }
        if(idVaso == 12){
                mult=2;
            }
        if(bebida.equals("latte")){
           propCafe = 0.3;
           propLeche= 0.7;
        } 
        if(bebida=="Expresso"){
           propCafe = 1;
        }
        if(bebida=="Capuchino"){
           propCafe = 0.4;
           propLeche= 0.6;
        } 
        if(bebida=="Moka"){
            propChoc=0.17;
            propCafe = 0.33;
            propLeche= 0.5;
             
         }
        if(bebida=="Chocolate"){
            propChoc=1;
        }
        String query="UPDATE taller4.producto SET stock=stock-"+propCafe*mult+" WHERE idProducto=1; "
                +"UPDATE taller4.producto SET stock=stock-"+propChoc*mult+" WHERE idProducto=2; "
                + "UPDATE taller4.producto SET stock=stock-"+propLeche*mult+" WHERE idProducto="+idLeche+";"
                + "UPDATE taller4.producto SET stock=stock-1 WHERE idProducto="+idVaso+";"
                + "UPDATE taller4.producto SET stock=stock-20*"+cucharada+" WHERE idProducto="+idAzucar+" ;";
        try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);
                pstm.execute();
                pstm.close();
                return true;
             }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
    }