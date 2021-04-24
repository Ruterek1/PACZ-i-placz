public class Chemical implements Weapon {

    private double ignitionRange;
    private double applyRange;

    public Chemical(double ignitionRange, double applyRange) {
        this.ignitionRange = ignitionRange;
        this.applyRange = applyRange;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        return 0;
    }

    public double getIgnitionRange() {
        return ignitionRange;
    }

    public double getApplyRange() {
        return applyRange;
    }

}
