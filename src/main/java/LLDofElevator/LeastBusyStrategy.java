package LLDofElevator;

import LLDofElevator.enums.ElevatorDirection;

import java.util.List;

public class LeastBusyStrategy implements ElevatorSelectionStrategy{

    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestedFloor, ElevatorDirection direction) {
        ElevatorController best = null;
        int minTasks = Integer.MAX_VALUE;
        for(ElevatorController controller: controllers) {
            int tasks = controller.downPQ.size() + controller.upPQ.size();
            if(tasks < minTasks) {
                minTasks = tasks;
                best = controller;
            }
        }
        return best;
    }
}
