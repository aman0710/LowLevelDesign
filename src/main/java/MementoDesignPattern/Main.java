package MementoDesignPattern;

public class Main {
    public static void main(String[] args) {
        ConfigurationCaretaker caretaker = new ConfigurationCaretaker();
        ConfigurationOriginator originator = new ConfigurationOriginator(5, 10);
        ConfigurationMemento snapshot1 = originator.createMemento();
        caretaker.addMemento(snapshot1);
        originator.setHeight(7);
        originator.setWidth(12);
        ConfigurationMemento snapshot2 = originator.createMemento();
        caretaker.addMemento(snapshot2);
        originator.setHeight(10);
        originator.setWidth(20);
        ConfigurationMemento savedMemento = caretaker.undo();
        originator.restoreMemento(savedMemento);
        System.out.println("Height -> " + originator.getHeight());
        System.out.println("Width -> " + originator.getWidth());
        System.out.println("----------------------------");
        ConfigurationMemento savedMementoLast = caretaker.undo();
        originator.restoreMemento(savedMementoLast);
        System.out.println("Height -> " + originator.getHeight());
        System.out.println("Width -> " + originator.getWidth());
        System.out.println("----------------------------");
        ConfigurationMemento savedMementoLast1 = caretaker.undo();
        originator.restoreMemento(savedMementoLast1);
        System.out.println("Height -> " + originator.getHeight());
        System.out.println("Width -> " + originator.getWidth());

    }
}
