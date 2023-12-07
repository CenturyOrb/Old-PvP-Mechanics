package com.rosed.oldpvp.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class ShieldListener implements Listener {

    @EventHandler
    public void onShieldBlock(EntityDamageByEntityEvent event) {

        // Check if the entity taking damage is a player
        if (!(event.getEntity() instanceof Player))
            return;

        double damage = event.getDamage(EntityDamageEvent.DamageModifier.BLOCKING);
        damage /= 2;

        event.setDamage(EntityDamageEvent.DamageModifier.BLOCKING, damage);

    }

}
