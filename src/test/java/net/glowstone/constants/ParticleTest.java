package net.glowstone.constants;

import org.bukkit.Particle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for {@link GlowParticle}.
 */
@RunWith(Parameterized.class)
public class ParticleTest {

    private final Particle particle;

    public ParticleTest(Particle particle) {
        this.particle = particle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Particle[] values = Particle.values();
        List<Object[]> result = new ArrayList<>(values.length);
        for (Particle value : values) {
            result.add(new Object[]{value});
        }
        return result;
    }

    @Test
    public void testHasId() {
        assertTrue("Id missing for particle " + particle, GlowParticle.getId(particle) >= 0);
    }

}
