
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class Draw extends JFrame {
    public Draw(){
        setTitle("p6Younouss_T");
        setSize(700, 700);  
        Container contentPane = getContentPane();            
        ButtonGroup buttonGroupSize = new ButtonGroup();
        small = new JRadioButton("Small",true); 
        medium= new JRadioButton("Medium"); 
        large = new JRadioButton("Large");  
        buttonGroupSize.add(small);
        buttonGroupSize.add(medium);
        buttonGroupSize.add(large);   
        ButtonGroup buttonGroupShape = new ButtonGroup();
        circle = new JRadioButton("Circle",true); 
        square = new JRadioButton("Square"); 
        triangle = new JRadioButton("Triangle");  
        buttonGroupShape.add(circle);
        buttonGroupShape.add(square);
        buttonGroupShape.add(triangle);        
        ButtonGroup buttonGroupColor = new ButtonGroup();
        red = new JRadioButton("Red",true); 
        blue = new JRadioButton("Blue"); 
        green = new JRadioButton("Green");  
        buttonGroupColor.add(red);
        buttonGroupColor.add(blue);
        buttonGroupColor.add(green);
        clear = new JButton("CLEAR");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clear);
        JPanel radioPanelSize = new JPanel();
        radioPanelSize.setBorder(BorderFactory.createTitledBorder("Size"));
        radioPanelSize.add(small);
        radioPanelSize.add(medium);
        radioPanelSize.add(large);    
        JPanel radioPanelShape = new JPanel();
        radioPanelShape.setBorder(BorderFactory.createTitledBorder("Shape"));
        radioPanelShape.add(circle);
        radioPanelShape.add(square);
        radioPanelShape.add(triangle);    
        JPanel radioPanelColor = new JPanel();
        radioPanelColor.setBorder(BorderFactory.createTitledBorder("Color"));
        radioPanelColor.add(red);
        radioPanelColor.add(blue);
        radioPanelColor.add(green);    
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3,1)); 
        radioPanel.add(radioPanelSize);
        radioPanel.add(radioPanelShape);
        radioPanel.add(radioPanelColor);
        contentPane.add(radioPanel,"North");
        contentPane.add(buttonPanel,"South");
        canvas = new DrawPanel();       
        contentPane.add(canvas,"Center");
        ActionListener buttonObserver = new ButtonObserver();      
        small.addActionListener(buttonObserver);
        medium.addActionListener(buttonObserver);     
        large.addActionListener(buttonObserver); 
        circle.addActionListener(buttonObserver);
        square.addActionListener(buttonObserver);     
        triangle.addActionListener(buttonObserver);        
        red.addActionListener(buttonObserver);
        blue.addActionListener(buttonObserver);     
        green.addActionListener(buttonObserver);
        clear.addActionListener(buttonObserver); 
        canvas.addMouseListener(new MouseObserver());        
    }
     class MouseObserver implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            
        }

        @Override
        public void mousePressed(MouseEvent me) {
           location = new Point2D.Double(me.getX(),me.getY());
           if(color == "red"){
            canvas.setForeground(java.awt.Color.red);
           }
           if(color == "blue"){
            canvas.setForeground(java.awt.Color.blue);
           }
           if(color == "green"){
            canvas.setForeground(java.awt.Color.green);   
           }
           if(shapeShape == "circle"){
                shape = new Circle(location, canvas.getForeground(), size);
           }
              if(shapeShape == "square"){
                shape = new Square(location, canvas.getForeground(), size);
           }
                 if(shapeShape == "triangle"){
                shape = new Triangle(location, canvas.getForeground(), size);              
           }
             shapeList.add(shape);    
             canvas.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        
        }

        @Override
        public void mouseExited(MouseEvent me) {
        
        }
         
     }    
    class ButtonObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {    
           Object source = e.getSource(); 
           if(source == small){
               size = 20;
           }
           if(source == medium){
               size = 30;
           }
           if(source == large){
               size = 40;
           }
           if(source == red){
               color ="red";
           }
           if(source == blue){
               color = "blue";
           }
           if(source == green){
               color ="green";   
           } 
           if(source == circle){
               shapeShape = "circle";
           }    
           if(source == square){
               shapeShape = "square";
           } 
           if(source == triangle){
               shapeShape = "triangle";
           }   
           if(source == clear){
               shapeList.clear();
               canvas.repaint();
           }
        }
    }
    private class DrawPanel extends JPanel { 
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g; 
            for (MyShape shape :  shapeList) {     
            shape.draw(g2);
            }
           // repaint();
        }
    }
    JRadioButton red,blue,green, circle, triangle, square, small, medium, large;   
    Point2D.Double location = new Point2D.Double();
    int size = 20;
    String color = "red", shapeShape = "circle";
    MyShape shape ;
    JButton clear; 
   DrawPanel canvas;
    ArrayList<MyShape> shapeList = new ArrayList();
}
