package me.paravel.hydrophobicelytra;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class HydrophobicElytra implements ModInitializer {
	@Override
	public void onInitialize() {
		EntityElytraEvents.ALLOW.register(entity -> {
			if (entity instanceof PlayerEntity playerEntity) {
				if (playerEntity.isInFluid()) {
					if (playerEntity.getEntityWorld().isClient()) {
						playerEntity.sendMessage(Text.translatable("message.hydrophobicelytra.too_wet").formatted(Formatting.RED), true);
					}
					return false; 
				}
			}
			return true;
		});
	}
}