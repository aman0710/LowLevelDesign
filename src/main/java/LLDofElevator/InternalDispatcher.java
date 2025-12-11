package LLDofElevator;

public class InternalDispatcher {
    private static InternalDispatcher INSTANCE = new InternalDispatcher();
    public InternalDispatcher() {

    }

    public static InternalDispatcher getInstance() {
        return INSTANCE;
    }

    public void submitInternalRequest(int floor, ElevatorController controller) {
        controller.submitRequest(floor);
    }
}
