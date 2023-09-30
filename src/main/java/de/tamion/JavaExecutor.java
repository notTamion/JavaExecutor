package de.tamion;

import de.tamion.commands.Execute;
import de.tamion.commands.ExecuteFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class JavaExecutor extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("execute").setExecutor(new Execute());
        getCommand("executefile").setExecutor(new ExecuteFile());
    }

    @Override
    public void onDisable() {

    }
}
