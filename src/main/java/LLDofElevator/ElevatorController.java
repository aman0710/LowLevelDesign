package LLDofElevator;

import LLDofElevator.enums.ElevatorDirection;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable{

    ElevatorCar elevatorCar;
    PriorityBlockingQueue<Integer> upPQ;
    PriorityBlockingQueue<Integer> downPQ;
    private final Object monitor = new Object();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.upPQ = new PriorityBlockingQueue<>();
        this.downPQ = new PriorityBlockingQueue<>(10, (a,b) -> b-a);
        this.elevatorCar = elevatorCar;
    }

    public void submitRequest(int destinationFloor) {
        enqueueRequest(destinationFloor);
    }

    private void enqueueRequest(int destinationFloor) {
        System.out.println("Request details -> destination floor: " + destinationFloor + " accepted by elevator: " + elevatorCar.id);
        if(destinationFloor == elevatorCar.nextFloorStoppage)
            return;

        if(destinationFloor > elevatorCar.nextFloorStoppage) {
            if(!upPQ.contains(destinationFloor)) {
                upPQ.offer(destinationFloor);
            }
        } else {
            if(!downPQ.contains(destinationFloor)) {
                downPQ.offer(destinationFloor);
            }
        }

        synchronized (monitor) {
            monitor.notify();
        }
    }



    @Override
    public void run() {
        controlElevator();
    }

    public void controlElevator() {
        while(true) {
            synchronized (monitor) {
                while(upPQ.isEmpty() && downPQ.isEmpty()) {
                    try {
                        System.out.println("Elevator: " + elevatorCar.id + " is IDLE");
                        elevatorCar.movingDirection = ElevatorDirection.IDLE;
                        monitor.wait();
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while(!upPQ.isEmpty()) {
                int floor = upPQ.poll();
                System.out.println("Serving floor: " + floor + " by elevator: " + elevatorCar.id + " current floor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(floor);
            }

            while(!downPQ.isEmpty()) {
                int floor = downPQ.poll();
                System.out.println("Serving floor: " + floor + " by elevator: " + elevatorCar.id + " current floor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(floor);
            }
        }
    }
}
