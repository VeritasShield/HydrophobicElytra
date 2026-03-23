package me.paravel.hydrophobicelytra.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "hydrophobic-elytra")
public class HydrophobicElytraConfig implements ConfigData {
    
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.Tooltip
    public boolean disableElytraOnSubmerge = true;

    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.Tooltip
    public FluidMode affectedFluids = FluidMode.ALL;

    @ConfigEntry.Category("feedback")
    @ConfigEntry.Gui.Tooltip
    public boolean showWarningMessage = true;

    @ConfigEntry.Category("feedback")
    @ConfigEntry.Gui.Tooltip
    public boolean enableSound = true;

    public enum FluidMode {
        ALL, WATER_ONLY, LAVA_ONLY
    }
}
