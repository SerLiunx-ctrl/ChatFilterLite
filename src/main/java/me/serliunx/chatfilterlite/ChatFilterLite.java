package me.serliunx.chatfilterlite;

import me.serliunx.chatfilterlite.events.AsyncPlayerChat;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class ChatFilterLite extends JavaPlugin {
    public boolean status = true;
    public final String version = "1.0.1";


    @Override
    public void onEnable() {
        if(!checkVersion())
            getLogger().info("can not enable this plugin.");
        register();
        this.saveDefaultConfig();
    }

/*    @Override
    public void onDisable() {

    }*/

    private void register(){
        //注册事件
        this.getServer().getPluginManager().registerEvents(new AsyncPlayerChat(this),this);
        //注册指令
        Objects.requireNonNull(this.getCommand("cfl")).setExecutor(new Commands(this));
    }

    private boolean checkVersion(){
        return this.getConfig().getBoolean("enable");
    }

    public boolean switchPlugin(boolean status){
        this.status = status;
        return false;
    }

    public boolean getStatus(){
        return this.status;
    }
}
