package Objects;

import GUI.SlotTypes;

public class ItemWeapon extends ItemEquipable {
    public float damage, maxDamage;

    public ItemWeapon(String name, SlotTypes Type, float Damage, float MaxDamage, int Str, int Dex, int Int, int Agi) {
        super(name, Type, Str, Dex, Int, Agi);

        damage = Damage;
        maxDamage = MaxDamage;
    }
}
