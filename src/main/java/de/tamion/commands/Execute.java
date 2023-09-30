package de.tamion.commands;

import bsh.EvalError;
import bsh.Interpreter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Execute implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("JavaExecutor.execute")) {
            sender.sendMessage("You aren't allowed to execute this Command");
            return false;
        }
        if(args.length == 0) {
            sender.sendMessage("Please provide code to execute");
            return false;
        }
        Interpreter inter = new Interpreter();
        try {
            inter.eval(String.join(" ", args));
            sender.sendMessage("Executed Code");
        } catch (EvalError e) {
            sender.sendMessage("Something went wrong");
            throw new RuntimeException(e);
        }
        return true;
    }
}
