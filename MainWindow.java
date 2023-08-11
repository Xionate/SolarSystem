import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainWindow extends JFrame {
    final int SOLARSYSTEM_WIDTH = 1536;
    final int SOLARSYSTEM_HEIGHT= 864;
    final int FRAME_HEIGHT =864;
    final int FRAME_WIDTH =1536;
    startlistener starter; 
    stoplistener stoper;
    JLabel rLabel, xLabel, yLabel;
    JTextField rField, xField, yField;
    JButton start,stop,rewind,addButton;
    SolarSystem system;
    boolean reverse = false;
    public MainWindow(){
        system = new SolarSystem();
        system.setPreferredSize(new Dimension(SOLARSYSTEM_WIDTH,SOLARSYSTEM_HEIGHT));
        planet mercur = new planet(5, 100, 100, Color.orange);
        planet venus = new planet(6, 200, 200, Color.gray);
        planet earth = new planet(7, 300, 300, Color.green);
        planet mars = new planet(8, 400, 400, Color.red);
        system.append(mercur);
        system.append(mars);
        system.append(earth);
        system.append(venus);
        createButtons();
        createadd();
        createPanel();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    public class stoplistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                stop.setEnabled(false);
                rewind.setEnabled(true);
                start.setEnabled(true);
                addButton.setEnabled(true);
                starter.stoptimer();
        }
    }
    public class startlistener implements ActionListener{
        Timer timer = new Timer(3, this);
        public void actionPerformed(ActionEvent e) {
            stop.setEnabled(true);
                rewind.setEnabled(false);
                start.setEnabled(false);
                addButton.setEnabled(false);
            timer.start();
            if(reverse){
                system.animation(-0.05);
            }
            else{
                system.animation(0.05);
            }
        }
        public void stoptimer(){
            timer.stop();
        }
    }
    public class rewindlistener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            reverse = !reverse;
            if(reverse){
                rewind.setText("rewinded");
            }
            else{
                rewind.setText("rewind");
            }
        }
    }
    public class addListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int r= Integer.parseInt(rField.getText());
            int x= Integer.parseInt(xField.getText());
            int y= Integer.parseInt(yField.getText());
            planet toadd = system.addplanet(r, x, y);
            system.append(toadd);
        }
    }
    public void createButtons(){
        start = new JButton("Start");
        stop = new JButton("Stop");
        rewind = new JButton("rewind");
        starter = new startlistener();
        stoper = new stoplistener();
        ActionListener rewinder = new rewindlistener();
        start.addActionListener(starter);
        stop.addActionListener(stoper);
        rewind.addActionListener(rewinder);
        stop.setEnabled(false);
    }
    public void createadd(){
        rLabel = new JLabel("r ");
        final int FIELD_WIDTH=10;
        rField = new JTextField(FIELD_WIDTH);
        rField.setText("" + 0);
        xLabel = new JLabel("x ");
        xField = new JTextField(FIELD_WIDTH);
        xField.setText("" + 0);
        yLabel = new JLabel("y ");
        yField = new JTextField(FIELD_WIDTH);
        yField.setText("" + 0);
        addButton = new JButton("Add Planet");
        ActionListener add = new addListener();
        addButton.addActionListener(add);
        rLabel.setForeground(Color.white);
        xLabel.setForeground(Color.white);
        yLabel.setForeground(Color.white);
    }
    public void createPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(start);
        panel.add(stop);
        panel.add(rewind);
        panel.add(rLabel);
        panel.add(rField);
        panel.add(xLabel);
        panel.add(xField);
        panel.add(yLabel);
        panel.add(yField);
        panel.add(addButton);
        panel.add(system);
        add(panel);
    }
    public static void main(String[] args) {
        MainWindow a = new MainWindow();
        a.setDefaultCloseOperation(3);
        a.setVisible(true);
    }
}