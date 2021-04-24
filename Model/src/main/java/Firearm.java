public class Firearm implements Weapon {

    private final int Magazine;
    private final double Range;
    private int Ammo;
    private final double BulletDamage;

    public Firearm(int magazine, double range, int ammo, double bulletDamage) {
        Magazine = magazine;
        Range = range;
        Ammo = ammo;
        BulletDamage = bulletDamage;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if(getAmmo()>0) {
            setAmmo(getAmmo()-1);
            if(dummy.getDistance()>getRange()) {
                return 0;
            }
            else return getBulletDamage();
        }
        else return 0;
    }

    public double dealDamage(Dummy dummy, int bullets) {
        if(getAmmo()==0) {
            return 0;
        }
        double tempDamage;
        if(getAmmo()>bullets) {
            setAmmo(getAmmo()-bullets);
            tempDamage=bullets*getBulletDamage();
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



    public int getMagazine() {
        return Magazine;
    }

    public double getRange() {
        return Range;
    }

    public int getAmmo() {
        return Ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo=ammo;
    }

    public void addAmmo(int ammo) {
        Ammo = ammo;
    }

    public double getBulletDamage() {
        return BulletDamage;
    }

}
