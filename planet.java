import java.awt.Color;
import java.awt.*;
import javax.swing.JComponent;

public class planet extends JComponent {
    double positionx, positiony;
    int xoforbit, yoforbit;
    int r;
    Color colorofplanet;
    double angle;
    planet(int r,int xoforbit,int yoforbit, Color a){
        this.r = r;
        this.xoforbit = xoforbit;
        this.yoforbit = yoforbit;
        this.colorofplanet = a;
        this.angle = 0;
        setPosition(0);
    }
    public void setPosition(double angl) {
        angle = angle + angl;
        positionx =768+(xoforbit*Math.cos(angle))-2*r;
        positiony =(432+(yoforbit*Math.sin(angle))-2*r);
    }
    public double getPositionx() {
        return positionx;
    }
    public double getPositiony() {
        return positiony;
    }
    
    public void paintComponent(Graphics g) {
        g.setColor(colorofplanet);
        g.drawOval(768+xoforbit, 432+yoforbit, 2*xoforbit, 2*yoforbit);
        g.fillOval((int)positionx-r, (int)positiony-r, 2*r, 2*r);
        
    }
     
}
