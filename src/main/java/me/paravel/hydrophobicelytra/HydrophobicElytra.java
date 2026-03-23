package me.paravel.hydrophobicelytra;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.sound.SoundEvents;
import net.minecraft.particle.ParticleTypes;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.paravel.hydrophobicelytra.config.HydrophobicElytraConfig;

public class HydrophobicElytra implements ModInitializer {
	@Override
	public void onInitialize() {
		AutoConfig.register(HydrophobicElytraConfig.class, GsonConfigSerializer::new);

		EntityElytraEvents.ALLOW.register(entity -> {
			if (entity instanceof PlayerEntity playerEntity) {
				HydrophobicElytraConfig config = AutoConfig.getConfigHolder(HydrophobicElytraConfig.class).getConfig();
				
				if (!config.disableElytraOnSubmerge) {
					return true;
				}

				boolean inWater = playerEntity.isTouchingWater();
				boolean inLava = playerEntity.isInLava();
				boolean shouldCancel = false;

				if (config.affectedFluids == HydrophobicElytraConfig.FluidMode.ALL && playerEntity.isInFluid()) {
					shouldCancel = true;
				} else if (config.affectedFluids == HydrophobicElytraConfig.FluidMode.WATER_ONLY && inWater) {
					shouldCancel = true;
				} else if (config.affectedFluids == HydrophobicElytraConfig.FluidMode.LAVA_ONLY && inLava) {
					shouldCancel = true;
				}

				if (shouldCancel) {
					// En el cliente dejamos que HydrophobicElytraClient maneje la cancelación y el feedback visual/sonoro
					if (playerEntity.getEntityWorld().isClient()) {
						return true;
					}
					// En el servidor, cancelamos el vuelo.
					return false; 
				}
			}
			return true;
		});
	}
}