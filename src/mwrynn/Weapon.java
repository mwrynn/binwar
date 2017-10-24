package mwrynn;

import java.math.*;
/**
 * Created by mwrynn on 10/22/17.
 */
public class Weapon {
    WeaponType weaponType;
    
    byte bitStr;
    
    public Weapon(WeaponType weaponType, byte bitStr) {
        this.weaponType = weaponType;
        this.bitStr = bitStr;
    }
    
    public WeaponType getWeaponType() {
        return weaponType;
    }
    
    public byte getBitStr() {
        return bitStr;
    }
    
    public byte evaluateDamage(byte otherBitStr) {
        switch (weaponType) {
            case SUBTRACT:
                return (byte)(otherBitStr - bitStr);
            case AND:
                return (byte)(bitStr & otherBitStr);
            case OR:
                return (byte)(bitStr | otherBitStr);
            case XOR:
                return (byte)(bitStr ^ otherBitStr);
            case NAND:
                return (byte)~(bitStr & otherBitStr);
            case RSHIFT:
                return (byte)(otherBitStr >> bitStr);
            case LSHIFT:
                return (byte)(otherBitStr << bitStr);
            default:
                return otherBitStr;
        }
    }
    
    public String toString() { //output as xxxx, e.g. 0110 - only 4 bits
        return weaponType + " " + formatByteAs4Bits(bitStr);
    }
    
    public static String formatByteAs4Bits(byte b) {
        String bitOutputStr = "";
        for (int i = 0; i < 4; i++) {
            if (((1 << i) & b) == 0) {
                bitOutputStr = "0" + bitOutputStr;
            } else {
                bitOutputStr = "1" + bitOutputStr;
            }
        }
        return bitOutputStr;
    }
    
    public static void main(String[] args) {
        Weapon subtractor = new Weapon(WeaponType.SUBTRACT, (byte)1);
        Weapon and6 = new Weapon(WeaponType.AND, (byte)6);
        System.out.println(subtractor);
        System.out.println(and6);
        System.out.println("AND 0110 against " + formatByteAs4Bits((byte)10) + "=" + formatByteAs4Bits(and6.evaluateDamage((byte)10)));

    }
}
