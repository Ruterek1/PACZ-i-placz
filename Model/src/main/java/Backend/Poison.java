package Backend;

public class Poison extends Chemical {

    private final double expirationTime;
    private final double DPS;

    public Poison(double ignitionRange, double applyRange, double expirationTime, double DPS) {
        super(ignitionRange, applyRange);
        this.expirationTime = expirationTime;
        this.DPS = DPS;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if(dummy.getDistance()>getApplyRange()+getIgnitionRange()) {
            return 0;
        }
        else {
            return getDPS()*getExpirationTime();
        }
    }

    public double getExpirationTime() {
        return expirationTime;
    }

    public double getDPS() {
        return DPS;
    }
}
