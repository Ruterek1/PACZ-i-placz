public class Incendiary extends Chemical {

    private final double SpreadRatio;
    private final double ExpirationTime;
    private final double DPS;

    public Incendiary(double ignitionRange, double applyRange, double spreadRatio, double expirationTime, double DPS) {
        super(ignitionRange, applyRange);
        SpreadRatio = spreadRatio;
        ExpirationTime = expirationTime;
        this.DPS = DPS;
    }

    public double getSpreadRatio() {
        return SpreadRatio;
    }

    public double getExpirationTime() {
        return ExpirationTime;
    }

    public double getDPS() {
        return DPS;
    }
}
