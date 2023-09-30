package de.tamion.commands;

import bsh.EvalError;
import bsh.Interpreter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecuteFile implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("JavaExecutor.executefile")) {
            sender.sendMessage("You aren't allowed to execute this Command");
            return false;
        }
        if(args.length != 1) {
            sender.sendMessage("Please provide Path of File to execute");
            return false;
        }
        Interpreter inter = new Interpreter();
        try {
            inter.eval(new String(Files.readAllBytes(Paths.get(args[0]))));
            sender.sendMessage("Executed Code");
            return true;
        } catch (EvalError e) {
            sender.sendMessage("Something went wrong");
            e.printStackTrace();
        } catch (IOException e) {
            sender.sendMessage("File doesn't exist");
        }
        return false;
    }
}
