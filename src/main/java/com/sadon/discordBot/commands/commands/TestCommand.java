package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

public class TestCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        try{
            message.delete().queue();
            if(member.hasPermission(Permission.ADMINISTRATOR)){
                textChannel.sendMessage("Test command works").queue();
            }else{
                textChannel.sendMessage("You are missing permissions for this").queue();
            }

        }catch(InsufficientPermissionException exception){
            String permission = exception.getPermission().getName();
            textChannel.sendMessage("I'm missing the permission " + permission).queue();
        }
    }
}
