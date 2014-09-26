package net.glowstone.constants;

import org.bukkit.Particle;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the GlowParticle class.
 */
public class ParticleTest {

    @Test
    public void testGetId() {
        for (Particle particle : Particle.values()) {
            assertTrue("Id missing for particle " + particle, GlowParticle.getId(particle) >= 0);
        }
    }

}
