package Backend;

public class Firearm implements Weapon {

    private final int magazine;
    private final double range;
    private int ammo;
    private final double bulletDamage;

    public Firearm(int magazine, double range, int ammo, double bulletDamage) {
        this.magazine = magazine;
        this.range = range;
        this.ammo = ammo;
        this.bulletDamage = bulletDamage;
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
        return magazine;
    }

    public double getRange() {
        return range;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo=ammo;
    }

    public void addAmmo(int ammo) {
        if(getAmmo()+ammo>getMagazine()) {
            setAmmo(getMagazine());
        }
        else if (ammo>0) {
            setAmmo(getAmmo()+ammo);
        }
    }

    public double getBulletDamage() {
        return bulletDamage;
    }

}
