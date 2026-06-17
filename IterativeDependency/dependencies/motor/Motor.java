package designStructures.IterativeDependency.dependencies.motor;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import designStructures.IterativeDependency.dependencies.Dependency;

public class Motor extends Dependency{
    private double speed;
    public Motor(){
        super(makeComponent());
        speed = 0;
    }

    private static JComponent makeComponent(){
        JPanel component = new JPanel();

        component.setBackground(new Color(20, 175, 75));
        component.setSize(500, 500);
        component.setLayout(new FlowLayout(0));

        ImageIcon image = new ImageIcon("CardLogo.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBackground(new Color(70, 70, 70));
        imageLabel.setSize(100, 100);
        component.add(imageLabel);
        

        JLabel label = new JLabel("speed: ");
        label.setFont(new Font("Algerian", Font.ITALIC, 20));

        component.add(label);

        return component;
    }

    @Override
    public void periodic() {
        System.out.print("periodic called");
        JLabel label = (JLabel) this.component.getComponent(1);
        label.setText("speed: " + speed);

        this.component.doLayout();
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
}
