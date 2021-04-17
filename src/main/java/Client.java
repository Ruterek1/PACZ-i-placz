import java.util.List;

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

    }

    public Dummy getDummy() {
        return Dummy;
    }

    public void addWeapon(Weapon weapon) {

    }
}
