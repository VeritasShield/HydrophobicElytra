package me.paravel.hydrophobicelytra;
import net.minecraft.client.world.ClientWorld;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestClient {
    public static void main(String[] args) {
        for (Method m : ClientWorld.class.getMethods()) {
            if (m.getName().toLowerCase().contains("particle") && Modifier.isPublic(m.getModifiers())) {
                System.out.println(m.toString());
            }
        }
        for (Method m : net.minecraft.world.World.class.getMethods()) {
            if (m.getName().toLowerCase().contains("particle") && Modifier.isPublic(m.getModifiers())) {
                System.out.println("WORLD: " + m.toString());
            }
        }
    }
}