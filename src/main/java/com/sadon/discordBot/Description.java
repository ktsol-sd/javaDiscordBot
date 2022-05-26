package com.sadon.discordBot;

import com.sadon.discordBot.config.ConfigValues;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

import java.util.TimerTask;

public class Description extends TimerTask{
    private int count = 0;
    private final JDA jda = Main.getJda();

    @Override
    public void run(){
        if(jda != null){
            jda.getPresence().setActivity(Activity.watching(ConfigValues.DESCRIPTION[count]));
            count = (count + 1)%ConfigValues.DESCRIPTION.length;
        }
    }
}
