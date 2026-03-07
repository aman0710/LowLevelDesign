package VisitorDesignPattern;

public interface RoomElement {
    void accept(RoomVisitor visitor);
}
