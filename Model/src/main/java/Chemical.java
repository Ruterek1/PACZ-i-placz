public class Chemical implements Weapon {

    private double IgnitionRange;
    private double ApplyRange;

    public Chemical(double ignitionRange, double applyRange) {
        IgnitionRange = ignitionRange;
        ApplyRange = applyRange;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        return 0;
    }

    public double getIgnitionRange() {
        return IgnitionRange;
    }

    public double getApplyRange() {
        return ApplyRange;
    }

}
