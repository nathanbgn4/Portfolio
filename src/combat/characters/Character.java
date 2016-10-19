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
public abstract class Character 
{
    private int manapoints = 100;
    private int hitpoints = 100;
   
    
    private String name = "No Name"; 

    public void setHitPoints(int hitpoints)
    {
        this.hitpoints = hitpoints;
    }
    
    public int getHitPoints()
    {
        return hitpoints;
    }

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
 
    public abstract void calculateDamage();

    /**
     * @return the manapoints
     */
    public int getManapoints() {
        return manapoints;
    }

    /**
     * @param manapoints the manapoints to set
     */
    public void setManapoints(int manapoints) {
        this.manapoints = manapoints;
    }
    
}
