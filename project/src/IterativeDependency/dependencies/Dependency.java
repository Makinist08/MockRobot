package designStructures.IterativeDependency.dependencies;

import javax.swing.JComponent;

public abstract class Dependency {
    protected JComponent component;

    public Dependency(JComponent component){
        this.component = component;
        DependencyHandler.getInstance().addDependency(this);
    }

    public JComponent getComponent(){
        return this.component;
    }

    public abstract void periodic();
}
