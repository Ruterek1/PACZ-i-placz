public class Rifle extends Firearm {

    private final double scope;

    public Rifle(int magazine, double range, int ammo, double bulletDamage, double scope) {
        super(magazine, range, ammo, bulletDamage);
        this.scope = scope;
    }
    @Override
    public double dealDamage(Dummy dummy) {
        if(getAmmo()>0) {
            setAmmo(getAmmo()-1);
            if(dummy.getDistance()>getRange()*getScope()) {
                return 0;
            }
            else if(dummy.getDistance()>getRange()) {
                return getBulletDamage();
            }
            else return 2*getBulletDamage();
        }
        else return 0;
    }
    public double getScope() {
        return scope;
    }

}
