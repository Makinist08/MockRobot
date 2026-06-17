package designStructures.IterativeDependency.dependencies;

import java.util.HashSet;
import java.util.Set;

public class DependencyHandler {
    private static DependencyHandler instance;
    private Set<Dependency> dependencySet;

    private DependencyHandler(){
        dependencySet = new HashSet<Dependency>();
    }

    public static DependencyHandler getInstance(){
        if (instance == null) {
            instance = new DependencyHandler();
        }
        return instance;
    }

    public Set<Dependency> getDependencySet(){
        return this.dependencySet;
    }

    public void addDependency(Dependency dependency){
        this.dependencySet.add(dependency);
    }
}
