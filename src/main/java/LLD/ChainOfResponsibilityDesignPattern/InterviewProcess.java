package LLD.ChainOfResponsibilityDesignPattern;

public class InterviewProcess {
    protected InterviewHandler chain;

    private static InterviewProcess INSTANCE = new InterviewProcess();

    private InterviewProcess() {
        this.chain = new TechnicalInterview();
        this.chain.setNext(new SystemDesignInterview()).setNext(new HRInterview());
    }

    public static InterviewProcess getInstance() {
        return INSTANCE;
    }

    public void startInterview(String candidate) {
        this.chain.hire(candidate);
    }
}
