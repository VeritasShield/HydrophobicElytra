package me.paravel.hydrophobicelytra.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "hydrophobic-elytra")
public class HydrophobicElytraConfig implements ConfigData {
    
    @ConfigEntry.Category("general")
    @Comment("Disable elytra flying when submerged in fluids")
    public boolean disableElytraOnSubmerge = true;

    @ConfigEntry.Category("general")
    @Comment("Which fluids affect the elytra")
    public FluidMode affectedFluids = FluidMode.ALL;

    @ConfigEntry.Category("feedback")
    @Comment("Show a warning message when flying is cancelled")
    public boolean showWarningMessage = true;

    @ConfigEntry.Category("feedback")
    @Comment("Play a fire extinguish sound when flying is cancelled")
    public boolean enableSound = true;

    public enum FluidMode {
        ALL, WATER_ONLY, LAVA_ONLY
    }
}
