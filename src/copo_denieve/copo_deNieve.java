package copo_denieve;

import javax.swing.*;
import java.awt.*;

public class copo_deNieve extends JPanel {
    double sin60 = Math.sin(Math.PI / 3.0); 
    int nivel_de_recursividad = 5; 
    Color[] colores = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA}; 
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Copo de nieve");
        copo_deNieve panel = new copo_deNieve();
        
        
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        
       
        JLabel title = new JLabel("Fractal de Copo de Nieve", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.BLUE);
        container.add(title, BorderLayout.NORTH); 
        
        container.add(panel, BorderLayout.CENTER); 

     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 850); 
        frame.add(container); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
    }

    public copo_deNieve() {
        
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        double xp1 = 400, yp1 = 100;
        double xp2 = 200, yp2 = 500;
        double xp3 = 600, yp3 = 500;

        
        Copo(g, nivel_de_recursividad, xp1, yp1, xp2, yp2);
        Copo(g, nivel_de_recursividad, xp2, yp2, xp3, yp3);
        Copo(g, nivel_de_recursividad, xp3, yp3, xp1, yp1);
    }

   
    private void Copo(Graphics g, int nivel, double xp1, double yp1, double xp2, double yp2) {
        if (nivel == 0) {
          
            g.setColor(colores[nivel_de_recursividad - nivel]);
            
            g.drawLine((int) xp1, (int) yp1, (int) xp2, (int) yp2);
        } else {
         
            double dx = (xp2 - xp1) / 3.0;
            double dy = (yp2 - yp1) / 3.0;

        
            double x1 = xp1 + dx;
            double y1 = yp1 + dy;
            double x2 = xp1 + 2 * dx;
            double y2 = yp1 + 2 * dy;

         
            double xx = (x1 + x2) / 2 - (dy * sin60);
            double yy = (y1 + y2) / 2 + (dx * sin60);

         
            Copo(g, nivel - 1, xp1, yp1, x1, y1);
            Copo(g, nivel - 1, x1, y1, xx, yy);
            Copo(g, nivel - 1, xx, yy, x2, y2);
            Copo(g, nivel - 1, x2, y2, xp2, yp2);
        }
    }
}
