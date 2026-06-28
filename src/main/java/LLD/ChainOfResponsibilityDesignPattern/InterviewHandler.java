package LLD.ChainOfResponsibilityDesignPattern;

public abstract class InterviewHandler {
    protected InterviewHandler nextHandler;

    protected InterviewHandler setNext(InterviewHandler handler) {
        this.nextHandler = handler;
        return nextHandler;
    }

    protected void callNext(String candidate) {
        if(nextHandler != null) {
            nextHandler.hire(candidate);
        } else {
            System.out.println(candidate + " passed all the interviews!");
        }
    }

    protected abstract void hire(String candidate);
}
