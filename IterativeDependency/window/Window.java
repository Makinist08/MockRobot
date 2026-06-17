package designStructures.IterativeDependency.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import designStructures.IterativeDependency.dependencies.Dependency;
import designStructures.IterativeDependency.dependencies.DependencyHandler;

public class Window extends JFrame{
    private JPanel dependencyPanel;
    private JPanel inputPanel;
    private DependencyHandler dependencyHandler;


    public Window(){
        this.JFrameSetUp();
        dependencyHandler = DependencyHandler.getInstance();
        dependencyPanel = new JPanel();
        dependencyPanel.setBackground(Color.CYAN);
        dependencyPanel.setSize(this.getWidth()/2, this.getHeight());
        dependencyPanel.setLayout(new FlowLayout());

        inputPanel = new JPanel();
        inputPanel.setBackground(Color.RED);
        inputPanel.setSize(this.getWidth() / 2, this.getHeight());
        inputPanel.setLayout(new FlowLayout());

        this.add(dependencyPanel);
        this.add(inputPanel);
    }

    @Override
    public void update(Graphics graphics){

        for (Dependency dependency : dependencyHandler.getDependencySet()) {
            dependency.periodic();

            List<Component> list = List.of(dependencyPanel.getComponents());

            if (!list.contains(dependency.getComponent())) {
                this.dependencyPanel.add(dependency.getComponent());
            }
        }

        dependencyPanel.setBounds(0, 0, this.getWidth()/2, this.getHeight());
        inputPanel.setBounds(this.getWidth() / 2, 0, this.getWidth(), this.getHeight());

        //System.out.println(this.dependencyPanel.getComponents());
        super.update(graphics);
    }

    private void JFrameSetUp(){
        this.setTitle("Card Game");
        this.setSize(900, 600);
        this.getContentPane().setBackground(new Color(100, 100 , 100));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setVisible(true);
    }
}
