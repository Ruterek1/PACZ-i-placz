public class Neurobalistic extends ColdWeapon {

    private final double range;

    public Neurobalistic(double damage, double range) {
        super(damage);
        this.range = range;
    }
    @Override
    public double dealDamage(Dummy dummy) {
        if(dummy.getDistance()>getRange()) {
            return 0;
        }
        return getDamage();
    }

    public double getRange() {
        return range;
    }

}
