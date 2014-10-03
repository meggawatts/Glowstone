package net.glowstone.net.message.play.player;

import lombok.*;
import org.bukkit.Location;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public final class PlayerLookMessage extends PlayerUpdateMessage {

    private final float yaw, pitch;

    public PlayerLookMessage(float yaw, float pitch, boolean onGround) {
        super(onGround);
        this.yaw = (yaw % 360 + 360) % 360;
        this.pitch = pitch;
    }

    @Override
    public void update(Location location) {
        location.setYaw(yaw);
        location.setPitch(pitch);
    }

}
