package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class EditCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(arguments.length == 3){ // !edit <channelID> <messageID>
            TextChannel textChannel1 = guild.getTextChannelById(arguments[1]);
            if(textChannel1 != null){
                textChannel1.editMessageById(arguments[2],"edited").queue();
            }
        }
    }
}
