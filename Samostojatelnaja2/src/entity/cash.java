package entity;

public class cash {
    private float cash;

    @Override
    public String toString() {
        return "Всего заработанно - " + cash;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }
}
