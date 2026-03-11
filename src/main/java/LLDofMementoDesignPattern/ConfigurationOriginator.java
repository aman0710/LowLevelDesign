package LLDofMementoDesignPattern;

public class ConfigurationOriginator {
    int height;
    int weight;

    public ConfigurationOriginator(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ConfigurationMemento createMemento() {
        return new ConfigurationMemento(this.height, this.weight);
    }

    public void restoreMemento(ConfigurationMemento memento) {
        this.weight = memento.getWeight();
        this.height = memento.getHeight();
    }
}
