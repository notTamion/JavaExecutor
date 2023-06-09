package de.tamion;

import de.tamion.commands.ExecuteCode;
import de.tamion.commands.ExecuteFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class JavaExecutor extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("executecode").setExecutor(new ExecuteCode());
        getCommand("executefile").setExecutor(new ExecuteFile());

        Metrics metrics = new Metrics(this, 19007);
    }

    @Override
    public void onDisable() {

    }
}
