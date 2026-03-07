package VisitorDesignPattern;

public class DoubleRoom implements RoomElement {

    int roomPrice = 0;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
