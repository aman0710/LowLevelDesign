package LLDofElevator;

import LLDofElevator.enums.DoorState;

public class Door {
    private DoorState doorState;

    public Door() {
        this.doorState = DoorState.DOOR_CLOSED;
    }

    public void openDoor(int id) {
        this.doorState = DoorState.DOOR_OPEN;
        System.out.println("Opening the elevator door of elevator: " + id);
    }

    public void closeDoor(int id) {
        this.doorState = DoorState.DOOR_CLOSED;
        System.out.println("Closing the elevator door of elevator: " + id);
    }
}
