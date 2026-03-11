package LLDofMementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCaretaker {
    List<ConfigurationMemento> history = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento) {
        this.history.add(memento);
    }

    public ConfigurationMemento undo() {
        if(!history.isEmpty()) {
            int lastIndex = history.size() - 1;
            ConfigurationMemento lastMemento = history.get(lastIndex);
            history.remove(lastIndex);
            return lastMemento;
        }
        return null;
    }
}
