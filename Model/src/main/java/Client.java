import java.util.List;
import java.util.ArrayList;

public class Client {

    private List<Weapon> Weapons;
    private Dummy Dummy;

    public Client(List<Weapon> weapons, Dummy dummy) {
        Weapons = weapons;
        Dummy = dummy;
    }

    public List<Weapon> getWeapons() {
        return Weapons;
    }

    public Weapon getWeapon(int n) {
        return Weapons.get(n);
    }

    public void useWeapon(Weapon weapon) {
        if(weapon.dealDamage(getDummy())>getDummy().getHp()) {
            dummy.setHp(0);
        }
        else dummy.setHp(dummy.getHp()-weapon.dealDamage(getDummy()));
    }

    public Dummy getDummy() {
        return Dummy;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
}
