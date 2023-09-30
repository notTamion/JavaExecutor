package de.tamion.commands;

import bsh.EvalError;
import bsh.Interpreter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ExecuteCode implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("JavaExecutor.executecode")) {
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
            return true;
        } catch (EvalError e) {
            sender.sendMessage("Something went wrong");
            e.printStackTrace();
        }
        return false;
    }
}
