package LLDofElevator;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        try {
            // Create elevator cars and their controllers
            ElevatorCar car1 = new ElevatorCar(1);
            ElevatorController controller1 = new ElevatorController(car1);

            ElevatorCar car2 = new ElevatorCar(2);
            ElevatorController controller2 = new ElevatorController(car2);

            InternalButton internalButton_elevator1 = new InternalButton(controller1);
            InternalButton internalButton_elevator2 = new InternalButton(controller2);

            ElevatorScheduler scheduler = new ElevatorScheduler(Arrays.asList(controller1, controller2), new NearestElevatorStrategy());

            ExternalDispatcher dispatcher = new ExternalDispatcher(scheduler);

            Building building = new Building(5, dispatcher);

            new Thread(controller1, "Elevator-1").start();
            new Thread(controller2, "Elevator-2").start();

            building.getFloor(3).pressUpButton();
            Thread.sleep(5);

            building.getFloor(5).pressDownButton();
            Thread.sleep(5);

            internalButton_elevator1.pressButton(4);
            Thread.sleep(5);

            internalButton_elevator1.pressButton(5);
            Thread.sleep(5);

            building.getFloor(1).pressDownButton();
            Thread.sleep(5);

            building.getFloor(2).pressUpButton();
            Thread.sleep(5);

            internalButton_elevator1.pressButton(2);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
