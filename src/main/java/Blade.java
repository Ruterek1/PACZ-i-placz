public class Blade extends ColdWeapon {

    private double Sharpness;
    private double Efficiency;

    public Blade(double damage, double sharpness, double efficiency) {
        super(damage);
        Sharpness = sharpness;
        Efficiency = efficiency;
    }

    public double getSharpness() {
        return Sharpness;
    }

    public void setSharpness(double sharpness) {
        Sharpness = sharpness;
    }

    public double getEfficiency() {
        return Efficiency;
    }

    public void setEfficiency(double efficiency) {
        Efficiency = efficiency;
    }
}
