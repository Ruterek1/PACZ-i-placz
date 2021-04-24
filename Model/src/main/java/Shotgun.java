public class Shotgun extends Firearm {

    private final int barrels;

    public Shotgun(int magazine, double range, int ammo, double bulletDamage, int barrels) {
        super(magazine, range, ammo, bulletDamage);
        this.barrels = barrels;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if (getAmmo()==0) {
            return 0;
        }
        double tempDamage;
        if (getAmmo()>getBarrels()) {
            setAmmo(getAmmo()-getBarrels());
            tempDamage=getBarrels()*getBulletDamage();
        }
        else {
            int tempAmmo=getAmmo();
            setAmmo(0);
            tempDamage=tempAmmo*getBulletDamage();
        }
        if(dummy.getDistance()>getRange()) {
            return 0;
        }
        else return tempDamage;
    }

    public int getBarrels() {
        return barrels;
    }

}
