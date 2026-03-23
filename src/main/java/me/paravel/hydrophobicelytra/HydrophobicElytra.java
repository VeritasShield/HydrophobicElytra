package me.paravel.hydrophobicelytra;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.particle.ParticleTypes;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.paravel.hydrophobicelytra.config.HydrophobicElytraConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class HydrophobicElytra implements ModInitializer {
	private static final Map<UUID, Long> COOLDOWNS = new HashMap<>();
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
					if (!playerEntity.getEntityWorld().isClient() && playerEntity.getEntityWorld() instanceof net.minecraft.server.world.ServerWorld serverWorld) {
						long currentTime = playerEntity.getEntityWorld().getTime();
						UUID playerId = playerEntity.getUuid();
						
						// Cooldown de 60 ticks (3 segundos) para no spamear sonidos, texto y partículas
						if (!COOLDOWNS.containsKey(playerId) || currentTime - COOLDOWNS.get(playerId) > 60) {
							COOLDOWNS.put(playerId, currentTime);
							
							if (config.showWarningMessage) {
								playerEntity.sendMessage(Text.translatable("message.hydrophobicelytra.too_wet").formatted(Formatting.RED), true);
							}
							
							if (config.enableSound) {
								// Feedback Sensorial: Sonido de fuego apagándose
								playerEntity.playSound(
									SoundEvents.BLOCK_FIRE_EXTINGUISH,
									0.5F, 0.8F + (playerEntity.getRandom().nextFloat() - playerEntity.getRandom().nextFloat()) * 0.2F
								);
							}
							
							// Feedback Sensorial: Partículas de burbujas rompiéndose
							serverWorld.spawnParticles(
								ParticleTypes.BUBBLE_POP, 
								playerEntity.getParticleX(0.5D), 
								playerEntity.getRandomBodyY(), 
								playerEntity.getParticleZ(0.5D), 
								5, 0.0D, 0.05D, 0.0D, 0.0D
							);
						}
					}
					return false; 
				}
			}
			return true;
		});
	}
}