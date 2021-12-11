package pacz.Backend;

public class Blade extends ColdWeapon {

    private double sharpness;
    private double efficiency;

    public Blade(double damage, double sharpness, double efficiency) {
        super(damage);
        this.sharpness = sharpness;
        this.efficiency = efficiency;
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
        return sharpness;
    }

    public void setSharpness(double sharpness) {
        this.sharpness = sharpness;
    }

    public double getEfficiency() {
        return efficiency;
    }}
