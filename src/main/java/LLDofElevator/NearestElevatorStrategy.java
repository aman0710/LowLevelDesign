package LLDofElevator;

import LLDofElevator.enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestedFloor, ElevatorDirection direction) {
        ElevatorController best = null;
        int minDistance = Integer.MAX_VALUE;

        for(ElevatorController controller: controllers) {
            if(controller.elevatorCar.movingDirection == direction && ((direction == ElevatorDirection.UP && requestedFloor >= controller.elevatorCar.nextFloorStoppage) || (direction == ElevatorDirection.DOWN && requestedFloor <= controller.elevatorCar.nextFloorStoppage))) {
                int distance = Math.abs(requestedFloor - controller.elevatorCar.nextFloorStoppage);
                if(distance < minDistance) {
                    minDistance = distance;
                    best = controller;
                }
            }
        }

        if(best == null) {
            for(ElevatorController controller: controllers) {
                if(controller.elevatorCar.movingDirection == ElevatorDirection.IDLE) {
                    best = controller;
                    break;
                }
            }

            if(best == null) {
                best = controllers.get(0);
            }
        }
        return best;
    }
}
