package me.serliunx.chatfilterlite.events;

import me.serliunx.chatfilterlite.ChatFilterLite;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {
    private ChatFilterLite plugin;

    public AsyncPlayerChat(ChatFilterLite plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent evt){

    }
}
