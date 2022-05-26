package com.sadon.discordBot;
import com.sadon.discordBot.commands.CommandManager;
import com.sadon.discordBot.config.ConfigFile;
import com.sadon.discordBot.config.ConfigValues;
import com.sadon.discordBot.data.LiteSQL;
import com.sadon.discordBot.music.AudioManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;



import javax.security.auth.login.LoginException;
import java.util.Timer;

public class Main extends ListenerAdapter {
    private static JDA jda;
    private static JDABuilder jdaBuilder;
    private static AudioPlayerManager audioPlayerManager;
    private static AudioManager audioManager;


    public static void main(String[] args) {

        LiteSQL.openConnection();
//        SQLManager.createTables();
//        SQLManager.insertValues();
//        SQLManager.getValues();

        ConfigFile.loadConfig();
        ConfigValues.loadValues();

        jdaBuilder = JDABuilder.createDefault(ConfigValues.BOT_TOKEN);
        setStatus();
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        audioPlayerManager = new DefaultAudioPlayerManager();
        audioManager = new AudioManager();


        try {
            jda = jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
        AudioSourceManagers.registerRemoteSources(audioPlayerManager);

        setDescription();
        registerCommands();
    }

    private static void setStatus(){
        switch(ConfigValues.STATUS){
            case "online":
                jdaBuilder.setStatus(OnlineStatus.ONLINE);
                break;
            case "offline":
                jdaBuilder.setStatus(OnlineStatus.OFFLINE);
                break;
            case "idle":
                jdaBuilder.setStatus(OnlineStatus.IDLE);
                break;
            case "busy":
                jdaBuilder.setStatus(OnlineStatus.DO_NOT_DISTURB);
                break;
        }
    }

    private static void setDescription(){
        Description description = new Description();
        Timer timer = new Timer();
        timer.schedule(description, 0, 5000);
    }

    private static void registerCommands(){
        CommandManager commandManager = new CommandManager();
        jda.addEventListener(commandManager);
    }

    public static JDA getJda(){
        if(jda != null){
            return jda;
        }
        return null;
    }

    public static AudioPlayerManager getAudioPlayerManager(){
        if(audioPlayerManager != null){
            return audioPlayerManager;
        }
        return null;
    }

    public static AudioManager getAudioManager(){
        if(audioManager != null){
            return audioManager;
        }
        return null;
    }
}