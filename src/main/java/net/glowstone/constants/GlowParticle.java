package net.glowstone.constants;

import org.apache.commons.lang.Validate;
import org.bukkit.Particle;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

import static org.bukkit.Particle.*;

/**
 * Id mappings for particles.
 */
public final class GlowParticle {

    private static final int[] EMPTY = new int[0];

    private GlowParticle() {
    }

    private static final int[] ids = new int[Particle.values().length];

    /**
     * Get the particle id for a specified Particle.
     * @param particle the Particle.
     * @return the particle id.
     */
    public static int getId(Particle particle) {
        Validate.notNull(particle, "particle cannot be null");
        return ids[particle.ordinal()];
    }

    /**
     * Convert a MaterialData to an extData array if possible for a particle.
     * @param particle the Particle to validate.
     * @param material the MaterialData to convert.
     * @return The extData array for the particle effect.
     * @throws IllegalArgumentException if data is provided incorrectly
     */
    public static int[] getData(Particle particle, MaterialData material) {
        if (material != null && !particle.usesMaterial()) {
            throw new IllegalArgumentException("Particle " + particle + " does not use material, " + material + " provided");
        } else if (material == null && particle.usesMaterial()) {
            throw new IllegalArgumentException("Particle " + particle + " requires material, null provided");
        }

        if (material == null) {
            return EMPTY;
        } else {
            return new int[]{material.getItemType().getId(), material.getData()};
        }
    }

    private static void set(Particle particle, int id) {
        ids[particle.ordinal()] = id;
    }

    static {
        Arrays.fill(ids, -1);
        // todo: confirm these numbers
        set(SMALL_SMOKE, 0);
        set(LARGE_EXPLOSION, 1);
        set(HUGE_EXPLOSION, 2);
        set(FIREWORKS_SPARK, 3);
        set(BUBBLES, 4);
        set(FISH_WAKE, 5);
        set(SPLASH, 6);
        set(UNDERWATER, 7); // "SUSPEND"
        set(TOWN_AURA, 8);
        set(CRITICAL, 9);
        set(MAGIC_CRITICAL, 10);
        set(SMOKE, 11);
        set(LARGE_SMOKE, 12);
        set(POTION_SWIRL, 13);
        set(INSTANT_SPELL, 14);
        set(SPELL, 15);
        set(POTION_SWIRL_TRANSPARENT, 16); // ???
        set(WITCH_MAGIC, 17);
        set(WATER_DRIP, 18);
        set(LAVA_DRIP, 19);
        set(ANGRY_VILLAGER, 20);
        set(HAPPY_VILLAGER, 21);
        set(VOID_FOG, 22); // "DEPTH_SUSPEND"
        set(NOTE, 23);
        set(PORTAL, 24);
        set(FLYING_GLYPH, 25);
        set(FLAME, 26);
        set(LAVA_POP, 27);
        set(FOOTSTEP, 28);
        set(CLOUD, 29);
        set(COLORED_DUST, 30);
        set(SNOWBALL_BREAK, 31);
        set(SNOW_SHOVEL, 32);
        set(SLIME, 33);
        set(HEART, 34);
        // 35: barrier
        // todo: the three usesMaterial particles
    }
}
