package LLDofElevator;

import LLDofElevator.enums.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int floor, ElevatorDirection direction);
}
