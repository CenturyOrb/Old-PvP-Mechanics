package com.rosed.oldpvp.listener;

import org.bukkit.entity.FishHook;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class FishingRodListener implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        if (event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) {
            event.setCancelled(true);
            event.getHook().remove();
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof FishHook && event.getHitEntity() != null) {
            FishHook hook = (FishHook) event.getEntity();
            LivingEntity entity = (LivingEntity) event.getHitEntity();

            if (entity == null) {
                return;
            }

            Vector knockback = hook.getOrigin().toVector().subtract(entity.getLocation().toVector()).normalize();

            entity.damage(0.1);
            entity.setVelocity(new Vector(-knockback.getX() * 1.1, 0.45, -knockback.getZ() * 1.1));
        }
    }

}
