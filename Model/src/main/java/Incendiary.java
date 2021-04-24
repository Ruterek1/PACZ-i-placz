public class Incendiary extends Chemical {

    private final double expirationTime;
    private final double DPS;

    public Incendiary(double ignitionRange, double applyRange, double expirationTime, double dps) {
        super(ignitionRange, applyRange);
        this.expirationTime = expirationTime;
        this.DPS = dps;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if(dummy.getDistance()>getApplyRange()+getIgnitionRange()) {
            return 0;
        }
        else {
            return getDPS()*getExpirationTime()* ((dummy.getDistance()-getApplyRange())/getIgnitionRange());
        }
    }

    public double getExpirationTime() {
        return expirationTime;
    }

    public double getDPS() {
        return DPS;
    }
}
