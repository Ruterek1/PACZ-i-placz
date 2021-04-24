public class Blade extends ColdWeapon {

    private double Sharpness;
    private double Efficiency;

    public Blade(double damage, double sharpness, double efficiency) {
        super(damage);
        Sharpness = sharpness;
        Efficiency = efficiency;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if(dummy.getDistance()>0||getSharpness()==0) {
            return 0;
        }
        if(getSharpness()>getEfficiency()) {
            setSharpness(getSharpness()-getEfficiency());
        }
        else setSharpness(0);
        return getDamage();
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
