public class Pole extends ColdWeapon {

    private double Range;
    private double Sharpness;

    public Pole(double damage, double range, double sharpness) {
        super(damage);
        Range = range;
        Sharpness = sharpness;
    }

    public double getRange() {
        return Range;
    }

    public double getSharpness() {
        return Sharpness;
    }

}
