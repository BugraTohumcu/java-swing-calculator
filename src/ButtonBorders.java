import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.border.Border;

class ButtonBorders implements Border {

    private int radius;
    


    ButtonBorders(int radius) {
        this.radius = radius;
    }


    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawRoundRect(x, y, width, height+1, 0, radius);
        
       
    }


    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1 , this.radius+2,this.radius+3,this.radius);
    }


    @Override
    public boolean isBorderOpaque() {
        return true;
    }


    
}