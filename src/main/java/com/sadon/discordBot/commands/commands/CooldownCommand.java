package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.HashMap;

public class CooldownCommand implements ServerCommand {
    private HashMap<Member, Long> cooldown = new HashMap<>();

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {

        if(cooldown.containsKey(member) && cooldown.get(member) > System.currentTimeMillis()){
            long longRemaining = cooldown.get(member) - System.currentTimeMillis();
            int intRemaining = (int) (longRemaining / 1000); // 1 second = 1000 ticks

            textChannel.sendMessage("You must wait " + intRemaining + " seconds, before executing the command again").queue();

        }else{
            textChannel.sendMessage("You ran the command now you have to wait 15 seconds");
            cooldown.put(member, System.currentTimeMillis() + (15 * 1000));
        }
    }
}
