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
    === weas de producto=== Parametros de entrada
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
    11 Extra Azucar(se maneja con cantidad de cucharadas, si extra azucar es seleccionada, la cantidad del stock se descuenta al doble del valos de azucar)
    
    ===Lechita ===
    12 Sin Leche
    13 leche entera
    14 leche descremada
    15 leche soya
    *********FALTA MODIFICAR BASE DE DATOS SEGUN ESTA ESTRUCTURA***************
    tabla productos:
    id=1 producto=cafe stock=1000(gr)
    id=2 producto=chocolate stock=1000(gr)
    id=3 producto=vaso S stock=100(vasos)
    id=4 producto= vaso M stock= 100(vasos)
    id=5 producto= vaso L stock= 100(vasos)
    id=6 producto= azucar stock=1000(gr)
    id=7 producto= lecheEntera stock=1000(gr en polvo)
    id=8 producto= lecheDescremada stock=1000(gr en polvo)
    id=9 producto= lechesoya stock=1000(ml)
    */
    
    
    public boolean modificarInventario(int bebida, int idVaso, int idLeche, int idAzucar){
        int aux=0;
        double mult=0;
        double propCafe=0;
        double propChoc=0;
        double propLeche=0;
        int cucharada=1;
        //preguntamos por cada codigo de producto enviados desde el controlador Maquina, y lo reemplazamos por cada codigo de producto en la base de datos
        if(idAzucar==11){//extra azucar seleccionada
            idAzucar=6;
            cucharada=2;
        }
        if(idAzucar==9){//sin azucar
            idAzucar=6;
            cucharada=0;
        }
        if(idAzucar==11){//azucar seleccionada
            idAzucar=6;            
        }
        if(idVaso == 6){//vaso S
            idVaso=3;
            mult=1;
            }
        if(idVaso == 7){//vaso M
            idVaso=4;
                mult=1.5;
            }
        if(idVaso == 8){//vaso L
            idVaso=4;
                mult=2;
            }
        //proporciones de cafe segun tipo de bebida
        if(bebida==2){
           propCafe = 0.3;
           propLeche= 0.7;
        } 
        if(bebida==1){
           propCafe = 1;
        }
        if(bebida==3){
           propCafe = 0.4;
           propLeche= 0.6;
        } 
        if(bebida==4){
            propChoc=0.17;
            propCafe = 0.33;
            propLeche= 0.5;
             
         }
        if(bebida==5){
            propChoc=1;
        }
        if(idLeche==12){//sin leche
            idLeche=7;
            propLeche=0;
        }
        if(idLeche==13){//leche Entera
            idLeche=7;
        }
        if(idLeche==14){//leche Descremada
            idLeche=8;
        }
        if(idLeche==15){//leche soya
            idLeche=9;
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
    
    
    // Crear metodo de verificacion de inventario de cada materia prima en la base de datos, queda pendiente por reestruccturacion de base de datos.
    }