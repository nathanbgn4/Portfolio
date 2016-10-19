/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import combat.characters.*;


public class mainapp
{
    public static void main(String[] args) 
        {
          //declaring variables for other classes
          Player player = new Player();
          Enemy enemy = new Enemy();
          
          player.setName("Knight");
          enemy.setName("Goblin");
          
          combat.characters.Character[] allCharacters = new combat.characters.Character[2];
          
          allCharacters[0] = player;
          allCharacters[1] = enemy;
          
          System.out.println("Start Combat:");
          
          while (CombatUtilities.isCharacterAlive(player) && CombatUtilities.isCharacterAlive(enemy))
            {   
                
                CombatUtilities.performAttack(player, enemy);
                     
                if(CombatUtilities.isCharacterAlive(enemy))
                {
                     CombatUtilities.performAttack(enemy, player);
                }
                else
                {
                     System.out.println("The enemy has died.");
                }
                     
               CombatUtilities.printCharacterHP(player);
               CombatUtilities.printCharacterHP(enemy);
                
               System.out.println();
            }
          
          if(!CombatUtilities.isCharacterAlive(player))
          {
             CombatUtilities.printCharacterDeath(player);
          }
          
        }
}