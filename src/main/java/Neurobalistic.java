public class Neurobalistic extends ColdWeapon {

    private final double Range;

    public Neurobalistic(double damage, double range) {
        super(damage);
        Range = range;
    }

    public double getRange() {
        return Range;
    }

}
