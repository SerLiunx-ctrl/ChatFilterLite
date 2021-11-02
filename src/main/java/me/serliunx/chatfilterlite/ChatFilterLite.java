package me.serliunx.chatfilterlite;

import me.serliunx.chatfilterlite.events.AsyncPlayerChat;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class ChatFilterLite extends JavaPlugin {

    @Override
    public void onEnable() {
        register();
    }

    @Override
    public void onDisable() {

    }

    private void register(){
        //注册事件
        this.getServer().getPluginManager().registerEvents(new AsyncPlayerChat(this),this);
        //注册指令
        Objects.requireNonNull(this.getCommand("cfl")).setExecutor(new Commands(this));
    }
}
