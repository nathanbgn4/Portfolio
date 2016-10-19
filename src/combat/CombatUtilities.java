package combat;
import java.util.Random;

public class CombatUtilities
{ 
    
    
    public static boolean isCharacterAlive(combat.characters.Character character)
    {
        return (character.getHitPoints() > 0);
    }
    
    public static void printCharacterHP(combat.characters.Character character)
    {
        System.out.println(character.getName() + "'s HP: " + character.getHitPoints());        
    }
    
    
    public static void printCharacterDeath(combat.characters.Character character)
    {
        System.out.println(character.getName() + " has died!");
    }
    
     //number generated to determine a hit or miss 
    public static int getHitRoll()
    {
        return new Random().nextInt(101);
    }
    
    
    public static int getHitDamage()
    {
        return new Random().nextInt(10)+1;    
    }
    
    
    public static int getCritDamage()
    {
        return getHitDamage()*2;
    }
   
    
    public static boolean isHit(int diceRoll)
    {
        return diceRoll > 30;
    }
    
    public static boolean isCrit(int diceRoll)
    {
        return diceRoll > 90;
    }
    
    public static boolean isMiss(int diceRoll)
    {
        return diceRoll < 30;
    }

   
    
    
    public static void performAttack(combat.characters.Character attacker, combat.characters.Character defender)
    {
        int attackerRoll = CombatUtilities.getHitRoll();
        
        if(CombatUtilities.isHit(attackerRoll))
        {
         if(CombatUtilities.isCrit(attackerRoll))
         {
            int critDamage = getCritDamage();
             
            defender.setHitPoints(defender.getHitPoints() - critDamage);
            System.out.println(attacker.getName() + " did " + critDamage + " critical damage to " + defender.getName());
         }
         else
         {
             int hitDamage = getHitDamage();
             defender.setHitPoints(defender.getHitPoints() - hitDamage);
             System.out.println(attacker.getName() + " did " + hitDamage + " damage to " + defender.getName());
         }
        }
        else
        {
            System.out.println(attacker.getName() + " missed.");
        }
    }
    
   
}