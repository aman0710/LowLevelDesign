package LLDofCricBuzz.MatchType;

public class OneDayMatchType implements MatchType{
    @Override
    public int numberOfOvers() {
        return 50;
    }

    @Override
    public int maxOversAllowedPerBowler() {
        return 10;
    }
}
