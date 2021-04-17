public class Explosive extends Chemical {

    private final double FalloffRatio;
    private final double CentralDamage;

    public Explosive(double ignitionRange, double applyRange, double falloffRatio, double centralDamage) {
        super(ignitionRange, applyRange);
        FalloffRatio = falloffRatio;
        CentralDamage = centralDamage;
    }

    public double getFalloffRatio() {
        return FalloffRatio;
    }

    public double getCentralDamage() {
        return CentralDamage;
    }
}
