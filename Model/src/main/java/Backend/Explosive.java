package Backend;

public class Explosive extends Chemical {

    private final double centralDamage;

    public Explosive(double ignitionRange, double applyRange, double centralDamage) {
        super(ignitionRange, applyRange);
        this.centralDamage = centralDamage;
    }

    @Override
    public double dealDamage(Dummy dummy){
        if(dummy.getDistance()>getApplyRange()+getIgnitionRange()) {
            return 0;
        }
        else if(dummy.getDistance()>getApplyRange()) {
            return getCentralDamage()*((dummy.getDistance()-getApplyRange())/getIgnitionRange());
        }
        else {
            return getCentralDamage();
        }
    }

    public double getCentralDamage() {
        return centralDamage;
    }
}
