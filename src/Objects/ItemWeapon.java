package Objects;

import GUI.Slot;
import GUI.Types;

public class ItemWeapon extends ItemEquipable {
    public float damage, maxDamage;

    public ItemWeapon(String name, Types.SlotTypes Type, float Damage, float MaxDamage, Slot slot, int Str, int Dex, int Int, int Agi, String imgRef) {
        super(name, Type, slot, Str, Dex, Int, Agi, imgRef);

        damage = Damage;
        maxDamage = MaxDamage;
    }
}