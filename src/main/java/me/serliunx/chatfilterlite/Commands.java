package me.serliunx.chatfilterlite;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    private ChatFilterLite plugin;

    public Commands(ChatFilterLite plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("cfl"))
            return false;
        if(sender.hasPermission("chatfilterlite.admin"))
            return false;

        if(args.length > 2 || args.length < 1) {
            showHelp(args,sender);
            return false;
        }

        //
        switch (args[0]){
            case "reload":
                plugin.reloadConfig();
                break;
            case "switch":
                plugin.switchPlugin(!plugin.getStatus());

            default:
                showHelp(args,sender);
                return false;
        }
        return false;
    }


    private void showHelp(String[] args,CommandSender sender){
        for(String mess:plugin.getConfig().getStringList("messages.help_information")){
            sender.sendMessage(mess);
        }
    }
}
