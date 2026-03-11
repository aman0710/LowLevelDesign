package LLDofMementoDesignPattern;

public class ConfigurationMemento {
    int height;
    int weight;

    public ConfigurationMemento(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }
}
