
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Cafematica;
import modelo.Modelo;


public class Maquina implements ActionListener,MouseListener {
    //vista
    private Cafematica vistaPrincipal ;
   
    //modelo
    private Modelo modelo = new Modelo();
   /** Constructores  de clase */
    public Maquina(){
        
    }
    
    public Maquina( JFrame padre ){
        this.vistaPrincipal = (Cafematica) padre;
    }
    
     //acciones que se ejecuta por los controles de cada VISTA
    public enum Accion{
        //Declara controles que se usaran
        //Radiobutton de tipo de producto
        Expresso,
        Latte,
        Capuchino,
        Moka,
        HotChoc,
        //Radiobutton de tipo de tamaño
        SizeS,
        SizeM,
        SizeL,
        //Radiobutton de tipo de Leche
        rdbSLeche,
        LecheE1,
        LecheD,
        LecheS,
        //Radiobutton de tipo de Azucar
        SAzucar,
        CAzucar,
        EAzucar,
        //Botones de precio
        btn50,
        btn100,
        btn500,
        btn1000,
        btn2000,
        btn5000,
        btn10000,
        btn20000,
        //Textbox de monto
        txtValor,
        txtVuelto,
        txtImporte,
        GrupoLeche,
        GrupoAzucar,
        GrupoCafe,
        GrupoSize
    }
    
    /** Inicia todos las acciones y listener de la vista */
    public void iniciar(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vistaPrincipal);            
            this.vistaPrincipal.setLocationRelativeTo(null);
            this.vistaPrincipal.setTitle("Dunkan Hill coffee");
            this.vistaPrincipal.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}

        //============Escuchamos radiobutton de opciones de producto
        //Cafe Expresso
        this.vistaPrincipal.Expresso.setActionCommand( "Expresso" );
        this.vistaPrincipal.Expresso.addActionListener(this);
        //Cafe con leche
        this.vistaPrincipal.Latte.setActionCommand( "Latte" );
        this.vistaPrincipal.Latte.addActionListener(this);
        //Capuchino
        this.vistaPrincipal.Capuchino.setActionCommand("Capuchino");
        this.vistaPrincipal.Capuchino.addActionListener(this);
        //Mocka
        this.vistaPrincipal.Moka.setActionCommand("Moka");
        this.vistaPrincipal.Moka.addActionListener(this);
        //Chocolate Caliente
        this.vistaPrincipal.HotChoc.setActionCommand("HotChoc");
        this.vistaPrincipal.HotChoc.addActionListener(this);
        
        //Escuhamos radiobutton de opciones de Tamaño
        //pequeño
        this.vistaPrincipal.SizeS.setActionCommand("SizeS");
        this.vistaPrincipal.SizeS.addActionListener(this);
        //mediano
        this.vistaPrincipal.SizeM.setActionCommand("SizeM");
        this.vistaPrincipal.SizeM.addActionListener(this);
        //Grande
        this.vistaPrincipal.SizeL.setActionCommand("SizeL");
        this.vistaPrincipal.SizeL.addActionListener(this);
        
        
        //Escuchamos radiobutton de tipo de leche
        
        this.vistaPrincipal.rdbSLeche.setActionCommand("rdbSLeche");
        this.vistaPrincipal.rdbSLeche.addActionListener(this);
        
        this.vistaPrincipal.LecheE1.setActionCommand("LecheE1");
        this.vistaPrincipal.LecheE1.addActionListener(this);
        
        this.vistaPrincipal.LecheD.setActionCommand("LecheD");
        this.vistaPrincipal.LecheD.addActionListener(this);
        
        this.vistaPrincipal.LecheS.setActionCommand("LecheS");
        this.vistaPrincipal.LecheS.addActionListener(this);
        
        //Escuchamos radiobbuton de tipo de azucar
        this.vistaPrincipal.SAzucar.setActionCommand("SAzucar");
        this.vistaPrincipal.SAzucar.addActionListener(this);
        
        this.vistaPrincipal.CAzucar.setActionCommand("CAzucar");
        this.vistaPrincipal.CAzucar.addActionListener(this);
        
        this.vistaPrincipal.EAzucar.setActionCommand("EAzucar");
        this.vistaPrincipal.EAzucar.addActionListener(this);
        
        //Escuchamos textbox
        this.vistaPrincipal.txtValor.setActionCommand("txtValor");
        this.vistaPrincipal.txtValor.addActionListener(this);
        
        this.vistaPrincipal.txtVuelto.setActionCommand("txtVuelto");
        this.vistaPrincipal.txtVuelto.addActionListener(this);
        
        this.vistaPrincipal.txtImporte.setActionCommand("txtImporte");
        this.vistaPrincipal.txtImporte.addActionListener(this);
        
        //Escuchamos botones de monto
        this.vistaPrincipal.btn50.setActionCommand("btn50");
        this.vistaPrincipal.btn50.addActionListener(this);
        
        this.vistaPrincipal.btn100.setActionCommand("btn100");
        this.vistaPrincipal.btn100.addActionListener(this);
        
        this.vistaPrincipal.btn500.setActionCommand("btn500");
        this.vistaPrincipal.btn500.addActionListener(this);
        
        this.vistaPrincipal.btn1000.setActionCommand("btn1000");
        this.vistaPrincipal.btn1000.addActionListener(this);
        
        this.vistaPrincipal.btn2000.setActionCommand("btn2000");
        this.vistaPrincipal.btn2000.addActionListener(this);
        
        this.vistaPrincipal.btn5000.setActionCommand("btn5000");
        this.vistaPrincipal.btn5000.addActionListener(this);
        
        this.vistaPrincipal.btn10000.setActionCommand("btn10000");
        this.vistaPrincipal.btn10000.addActionListener(this);
        
        this.vistaPrincipal.btn20000.setActionCommand("btn20000");
        this.vistaPrincipal.btn20000.addActionListener(this);
        
        /*this.vistaPrincipal.GrupoAzucar.getSelection();
        this.vistaPrincipal.GrupoBebida.getSelection();
        this.vistaPrincipal.GrupoLeche.getSelection();
        this.vistaPrincipal.GrupoSize.getSelection();*/


    }
    
      int monto=0;
      int ValProd = 0;
      int ValAzucar = 0;
      int ValLeche = 0;
      int ValSize = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
      
        switch ( Accion.valueOf( e.getActionCommand() ) )
        {
            case  btn50:
                monto = monto + 50;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn100:
                monto = monto + 100;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn500:
                monto = monto + 500;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn1000:
                monto = monto + 1000;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn2000:
                monto = monto + 2000;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn5000:
                monto = monto + 5000;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn10000:
                monto = monto + 10000;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case  btn20000:
                monto = monto + 20000;
                this.vistaPrincipal.txtImporte.setText(Integer.toString(monto));
                break;
            case Expresso:
                if (monto <= 0){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar monto previamente");
                }
                else if(Integer.parseInt(this.vistaPrincipal.txtImporte.getText()) < 900){
                    JOptionPane.showMessageDialog(null,"Debe ingresar más dinero para adquirir el producto");
                }
                else {
                   ValProd = 900;
                   this.vistaPrincipal.Expresso.setEnabled(false);
                   this.vistaPrincipal.Latte.setEnabled(true);
                   this.vistaPrincipal.Capuchino.setEnabled(true);
                   this.vistaPrincipal.Moka.setEnabled(true);
                   this.vistaPrincipal.HotChoc.setEnabled(true);
                   this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                   this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                   this.vistaPrincipal.btnPreparar.setEnabled(true);
                    
                }
                break;
            case Latte:
                if (monto <= 0){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar monto previamente");
                }
                
                else if(Integer.parseInt(this.vistaPrincipal.txtImporte.getText()) < 1300){
                    JOptionPane.showMessageDialog(null,"Debe ingresar más dinero para adquirir el producto");
                }
                else{
                   ValProd = 1300;
                   this.vistaPrincipal.Expresso.setEnabled(true);
                   this.vistaPrincipal.Latte.setEnabled(false);
                   this.vistaPrincipal.Capuchino.setEnabled(true);
                   this.vistaPrincipal.Moka.setEnabled(true);
                   this.vistaPrincipal.HotChoc.setEnabled(true);
                   this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                   this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                   this.vistaPrincipal.btnPreparar.setEnabled(true);
                }
                break;
            case Capuchino:
                if (monto <= 0){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar monto previamente");
                }
                
                else if(Integer.parseInt(this.vistaPrincipal.txtImporte.getText()) < 1000){
                    JOptionPane.showMessageDialog(null,"Debe ingresar más dinero para adquirir el producto");
                }
                else{
                    ValProd = 1000;
                   this.vistaPrincipal.Expresso.setEnabled(true);
                   this.vistaPrincipal.Latte.setEnabled(true);
                   this.vistaPrincipal.Capuchino.setEnabled(false);
                   this.vistaPrincipal.Moka.setEnabled(true);
                   this.vistaPrincipal.HotChoc.setEnabled(true);
                   this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                   this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                   this.vistaPrincipal.btnPreparar.setEnabled(true);
                }
                break;
            case Moka:
                if (monto <= 0){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar monto previamente");
                }
                
                else if(Integer.parseInt(this.vistaPrincipal.txtImporte.getText()) < 1500){
                    JOptionPane.showMessageDialog(null,"Debe ingresar más dinero para adquirir el producto");
                }
                else{
                   ValProd = 1500;
                   this.vistaPrincipal.Expresso.setEnabled(true);
                   this.vistaPrincipal.Latte.setEnabled(true);
                   this.vistaPrincipal.Capuchino.setEnabled(true);
                   this.vistaPrincipal.Moka.setEnabled(false);
                   this.vistaPrincipal.HotChoc.setEnabled(true);
                   this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                   this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                   this.vistaPrincipal.btnPreparar.setEnabled(true);
                }
                break;
            case HotChoc:
                if (monto <= 0){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar monto previamente");
                }
                
                else if(Integer.parseInt(this.vistaPrincipal.txtImporte.getText()) < 800){
                    JOptionPane.showMessageDialog(null,"Debe ingresar más dinero para adquirir el producto");
                }
                
                else{
                   ValProd = 800;
                   this.vistaPrincipal.Expresso.setEnabled(true);
                   this.vistaPrincipal.Latte.setEnabled(true);
                   this.vistaPrincipal.Capuchino.setEnabled(true);
                   this.vistaPrincipal.Moka.setEnabled(true);
                   this.vistaPrincipal.HotChoc.setEnabled(false);
                   this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                   this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                   this.vistaPrincipal.btnPreparar.setEnabled(true);
                }
                break;
            case SizeS:
                 ValSize = 0;
                 this.vistaPrincipal.SizeS.setEnabled(false);
                 this.vistaPrincipal.SizeM.setEnabled(true);
                 this.vistaPrincipal.SizeL.setEnabled(true);
                 this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                 this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                 break;
                
            case SizeM:
                ValSize  = 100;
                this.vistaPrincipal.SizeS.setEnabled(true);
                this.vistaPrincipal.SizeM.setEnabled(false);
                this.vistaPrincipal.SizeL.setEnabled(true);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
                 
            case SizeL:
                ValSize  = 150;
                this.vistaPrincipal.SizeS.setEnabled(true);
                this.vistaPrincipal.SizeM.setEnabled(true);
                this.vistaPrincipal.SizeL.setEnabled(false);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case rdbSLeche:
                ValLeche = 0;
                this.vistaPrincipal.rdbSLeche.setEnabled(false);
                this.vistaPrincipal.LecheE1.setEnabled(true);
                this.vistaPrincipal.LecheD.setEnabled(true);
                this.vistaPrincipal.LecheS.setEnabled(true);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case LecheE1:
                ValLeche = 100;
                this.vistaPrincipal.rdbSLeche.setEnabled(true);
                this.vistaPrincipal.LecheE1.setEnabled(false);
                this.vistaPrincipal.LecheD.setEnabled(true);
                this.vistaPrincipal.LecheS.setEnabled(true);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case LecheD:
                ValLeche = 200;
                this.vistaPrincipal.rdbSLeche.setEnabled(true);
                this.vistaPrincipal.LecheE1.setEnabled(true);
                this.vistaPrincipal.LecheD.setEnabled(false);
                this.vistaPrincipal.LecheS.setEnabled(true);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case LecheS:
                ValLeche = 500;
                this.vistaPrincipal.rdbSLeche.setEnabled(true);
                this.vistaPrincipal.LecheE1.setEnabled(true);
                this.vistaPrincipal.LecheD.setEnabled(true);
                this.vistaPrincipal.LecheS.setEnabled(false);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case SAzucar:
                ValAzucar = 0;
                this.vistaPrincipal.SAzucar.setEnabled(false);
                this.vistaPrincipal.CAzucar.setEnabled(true);
                this.vistaPrincipal.EAzucar.setEnabled(true);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case CAzucar:
                ValAzucar = 50;
                this.vistaPrincipal.SAzucar.setEnabled(true);
                this.vistaPrincipal.CAzucar.setEnabled(false);
                this.vistaPrincipal.EAzucar.setEnabled(true);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
            case EAzucar:
                ValAzucar = 100;
                this.vistaPrincipal.SAzucar.setEnabled(true);
                this.vistaPrincipal.CAzucar.setEnabled(true);
                this.vistaPrincipal.EAzucar.setEnabled(false);
                this.vistaPrincipal.txtValor.setText(Integer.toString(ValProd+ ValAzucar+ ValSize +ValLeche));
                this.vistaPrincipal.txtVuelto.setText(Integer.toString(Integer.parseInt(this.vistaPrincipal.txtImporte.getText())-(ValProd+ ValAzucar+ ValSize +ValLeche)));
                break;
       }
        
        
        
        
        
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
/*public class Maquina {
        //Capacidades máximas de máquina
    public static final int maxCafe = 1000;        // Gramos
    public static final double maxLecheEnte = 10;  // Litros
    public static final double maxLecheDesc = 10;  // Litros
    public static final double maxLecheSoya = 5;  // Litros
    public static final double maxChoc = 1;        // Litros
    public static final int maxAzucar = 1000;      // Gramos
    
    //Cantidades mínimas de máquina para gatillar alertas
    private static final int minCafe = 200;         // Gramos --> 20 gramos por shot
    private static final double minLecheEnte = 2;   // Litros --> 200ml pot café
    private static final double minLecheDesc = 2;   // Litros --> 200ml pot café
    private static final double minLecheSoya = 2;   // Litros --> 200ml pot café
    private static final double minChoc = 0.2;      // Litros --> 20ml por preparación
    private static final int minAzucar = 200;       // Gramos --> 10 gramos por porción
    
    //Cantidades actuales de máquina. Inicializa la máquina a full capacidad
    private static int stCafe = maxCafe;                // Gramos
    private static double stLecheEnte = maxLecheEnte;   // Litros
    private static double stLecheDesc = maxLecheDesc;   // Litros
    private static double stLecheSoya = maxLecheSoya;   // Litros
    private static double stChoc = maxChoc;             // Litros
    private static int stAzucar = maxAzucar;            // Gramos
        
    //Método encargado de agregar shot y descontar desde stock
    public static boolean addShot(int nShot){
        if(stCafe>=20*nShot){
            stCafe = stCafe -20*nShot;
            return true;
        }else{
            return false;
        }        
    }
    //Método encargado de agregar leche y descontar desde stock
    public static boolean addMilk(int tipo, int medida){
        switch (tipo){
            case 1: // Leche entera
                if(stLecheEnte>=0.1*medida){
                    stLecheEnte = stLecheEnte -0.1*medida;
                return true;
                }else{
                    return false;
                }   
            case 2: // Leche descremada
                if(stLecheDesc>=0.1*medida){
                    stLecheDesc = stLecheDesc -0.1*medida;
                return true;
                }else{
                    return false;
                }   
            case 3: // Leche de soya
                if(stLecheSoya>=0.1*medida){
                    stLecheSoya = stLecheSoya -0.1*medida;
                return true;
                }else{
                    return false;
                }
            default:
                return false;
        }
    }
    //Método encargado de agregar chocolate y descontar desde stock
    public static boolean addChoc(int medida){
        if(stChoc>=0.02*medida){
            stChoc = stChoc -0.02*medida;
            return true;
        }else{
            return false;
        }        
    }
    //Método encargado de agregar azucar y descontar desde stock
    public static boolean addAzucar(int nUnidad, int factor){
        if(stAzucar>=10*nUnidad*factor){
            stAzucar = stAzucar -10*nUnidad*factor;
            return true;
        }else{
            return false;
        }        
    }
    
    //Método encargado de desplegar alertas cuando stock es bajo
    public static boolean[] alertaStock(){
        boolean [] lowStock = new boolean[6];
        if(stCafe<minCafe){
            lowStock[0] = true;
        }
        if(stLecheEnte<minLecheEnte){
            lowStock[1] = true;
        }
        if(stLecheDesc<minLecheDesc){
            lowStock[2] = true;
        }
        if(stLecheSoya<minLecheSoya){
            lowStock[3] = true;
        }
        if(stChoc<minChoc){
            lowStock[4] = true;
        }
        if(stAzucar<minAzucar){
            lowStock[5] = true;
        }
        return lowStock;
    }
    
    //Método encargado de desplegar stock disponible para cada ingrediente
    public static int[] stockDisponible(){
        int[] stockIng = new int[6];
        stockIng[0] = (int)((float)(stCafe)/(float)(maxCafe)*100);
        stockIng[1] = (int)(stLecheEnte/maxLecheEnte*100);
        stockIng[2] = (int)(stLecheDesc/maxLecheDesc*100);
        stockIng[3] = (int)(stLecheSoya/maxLecheSoya*100);
        stockIng[4] = (int)(stChoc/maxChoc*100);
        stockIng[5] = (int)((float)(stAzucar)/(float)(maxAzucar)*100);
        return stockIng;
    }
}
*/