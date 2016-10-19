/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.characters;

/**
 *
 * @author Nathan
 */
public class Player extends Character
{
    public void calculateDamage()
    {
        Character player = new Player();
        Character enemy = new Enemy();
        
        System.out.print(player.getHitPoints());
       
        
        Character[] characters_array = new Character[2];
        
        characters_array[0] = player;
        characters_array[1] = enemy;
        
        for(int i=0; i < characters_array.length; i++)
        {
            System.out.print(characters_array[i].getHitPoints());   
        }
    }
    
    
    
}
