package net.glowstone.entity;

import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.EntityType;

/**
 * Represents an entity with an age.
 */
public class GlowAgeable extends GlowCreature implements Ageable {

    private int age = 0;
    private boolean ageLocked = false;

    /**
     * Creates a new ageable monster.
     * @param location The location of the monster.
     * @param type The type of monster.
     */
    public GlowAgeable(Location location, EntityType type) {
        super(location, type);
    }

    @Override
    public void pulse() {
        super.pulse();
        if (this.ageLocked) {
            //
        }
    }

    @Override
    public final int getAge() {
        return this.age;
    }

    @Override
    public final void setAge(int age) {
        this.age = age;
    }

    @Override
    public final void setAgeLock(boolean ageLocked) {
        this.ageLocked = ageLocked;
    }

    @Override
    public final boolean getAgeLock() {
        return this.ageLocked;
    }

    @Override
    public final void setBaby() {
        if (isAdult()) {
            setAge(-24000);
        }
    }

    @Override
    public final void setAdult() {
        if (!isAdult()) {
            setAge(0);
        }
    }

    @Override
    public final boolean isAdult() {
        return this.age >= 0;
    }

    @Override
    public final boolean canBreed() {
        return this.age == 0;
    }

    @Override
    public void setBreed(boolean b) {

    }

    public void setScaleForAge(boolean isBaby) {

    }

    protected final void setScale(float scale) {
//        super.setScale(this.val *scale, this.val2 * scale);
    }
}
