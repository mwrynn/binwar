package mwrynn;

import java.util.function.BiFunction;

/**
 * Created by mwrynn on 10/22/17.
 */
enum WeaponType {
    SUBTRACT((a, b) -> a - b),
    AND((a, b) -> a + b),
    OR((a, b) -> a | b),
    XOR((a, b) -> a ^ b),
    NAND((a, b) -> ~(a & b)),
    RSHIFT((a, b) -> (int)(a >> b)),
    LSHIFT((a, b) -> (int)(a << b));

    private BiFunction<Byte,Byte,Integer> damage;
    
    WeaponType(BiFunction<Byte,Byte,Integer> damage) {
        this.damage = damage;
    }

    public byte evaluateDamage(byte value1, byte value2) {
        return (byte)(int)this.damage.apply(value1, value2);
    }

}