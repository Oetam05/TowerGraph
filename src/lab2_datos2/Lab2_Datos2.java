
package lab2_datos2;
import javax.swing.JOptionPane;

public class Lab2_Datos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AnimationWindow window = new AnimationWindow();
        window.setVisible(true);
        JOptionPane.showMessageDialog(window, "1. Click izquierdo: Añadir torre \n2. Click derecho: Eliminar torre", "Instrucciones", 1);
        
        
    }
    
}
