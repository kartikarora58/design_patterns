public enum StateEnum {
    Idle(0, "idle"),
    HasCoin(1, "hasCoin"),
    Dispensing(2, "dispensing"),
    OutOfOrder(3, "outOfOrderState");
    StateEnum(int stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }
    private final int stateId;

    public int getStateId() {
        return stateId;
    }

    public String getStateName() {
        return stateName;
    }

    private final String stateName;



}
