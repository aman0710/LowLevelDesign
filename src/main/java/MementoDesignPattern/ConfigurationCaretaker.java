package MementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCaretaker {
    List<ConfigurationMemento> history;

    public ConfigurationCaretaker() {
        this.history = new ArrayList<>();
    }

    public void addMemento(ConfigurationMemento memento) {
        this.history.add(memento);
    }

    public ConfigurationMemento undo() {
        if(this.history.isEmpty())
            return null;
        int lastIndex = this.history.size() - 1;
        ConfigurationMemento lastMemento = this.history.get(lastIndex);
        this.history.remove(lastIndex);
        return lastMemento;
    }
}
