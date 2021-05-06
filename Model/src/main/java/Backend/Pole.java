package Backend;

public class Pole extends ColdWeapon {

    private double range;
    private double sharpness;

    public Pole(double damage, double range, double sharpness) {
        super(damage);
        this.range = range;
        this.sharpness = sharpness;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if(getSharpness()==0||dummy.getDistance()>getRange()) {
            return 0;
        }
        if(getSharpness()>5) {
            sharpness-=5;
        }
        else sharpness=0;
        return getDamage();
    }

    public double getRange() {
        return range;
    }

    public double getSharpness() {
        return sharpness;
    }

}
