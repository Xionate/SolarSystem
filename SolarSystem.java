import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.JComponent;


public class SolarSystem extends JComponent{
    final int WIDTH = 768;
    final int HEIGHT = 432;
    ArrayList<planet> planets;
    SolarSystem(){
        planets = new ArrayList<>();  
    }
    public void append(planet a) {
        planets.add(a);
        repaint();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(743,407, 50, 50);
        for (int i = 0; i < planets.size(); i++) {
            planet a = planets.get(i);
            g.setColor(a.colorofplanet);
            g.drawOval(768-a.xoforbit, 432-a.yoforbit, 2*a.xoforbit, 2*a.yoforbit);
            g.fillOval((int)a.getPositionx()+a.r, (int)a.getPositiony()+a.r, 2*a.r, 2*a.r);
        }
    }
    public planet addplanet(int r, int x,int y){
        Random rand = new Random();
        float R = rand.nextFloat();
        float G = rand.nextFloat();
        float B = rand.nextFloat();
        Color randomColor = new Color(R, G, B);
        planet toadd = new planet(r, x, y, randomColor);
        return toadd;
    }
    public void animation(double angle){
        for (int i = 0; i < planets.size(); i++) {
            planet a= planets.get(i);
            a.setPosition(angle);
            repaint();
        }
    }
}