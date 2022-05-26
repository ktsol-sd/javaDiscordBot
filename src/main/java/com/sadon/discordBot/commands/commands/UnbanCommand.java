package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnbanCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {

        if (arguments.length == 2) { //unban <user ID>
            String id = arguments[1];
            if (id != null) {
                guild.unban(id).queue();
                textChannel.sendMessage("User with ID " + id + " was unbanned");
            }
        }else{
            textChannel.sendMessage("The correct format is !unban <user ID>");
        }
    }
}
