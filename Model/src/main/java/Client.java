import java.util.List;
import java.util.ArrayList;

public class Client {

    private List<Weapon> weapons;
    private Dummy dummy;

    public Client(Dummy dummy) {
        this.weapons = new ArrayList<Weapon>();
        this.dummy = dummy;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon getWeapon(int n) {
        return weapons.get(n);
    }

    public void useWeapon(Weapon weapon) {
        if(weapon.dealDamage(getDummy())>getDummy().getHp()) {
            dummy.setHp(0);
        }
        else dummy.setHp(dummy.getHp()-weapon.dealDamage(getDummy()));
    }

    public Dummy getDummy() {
        return dummy;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
}
