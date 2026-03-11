package LLDofMementoDesignPattern;

public class Main {
    public static void main(String[] args) {
        ConfigurationCaretaker caretaker = new ConfigurationCaretaker();
        ConfigurationOriginator originator = new ConfigurationOriginator(5, 10);
        ConfigurationMemento memento = originator.createMemento();
        caretaker.addMemento(memento);
        originator.setHeight(7);
        originator.setWeight(12);
        memento = originator.createMemento();
        caretaker.addMemento(memento);
        originator.setHeight(9);
        originator.setWeight(14);
        memento = caretaker.undo();
        originator.restoreMemento(memento);
        System.out.println("Originator height: " + originator.getHeight());
        System.out.println("Originator weight: " + originator.getWeight());
    }
}
