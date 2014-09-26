package net.glowstone.constants;

import org.apache.commons.lang.Validate;
import org.bukkit.Particle;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

import static org.bukkit.Particle.ANGRY_VILLAGER;

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
            return new int[] { material.getItemType().getId(), material.getData() };
        }
    }

    private static void set(Particle particle, int id) {
        ids[particle.ordinal()] = id;
    }

    static {
        Arrays.fill(ids, -1);
        // todo: the actual numbers here
        set(ANGRY_VILLAGER, 0);
    }
}
