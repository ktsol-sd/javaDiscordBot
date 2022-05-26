package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class BanCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0xcf000f);

        if(arguments.length==3){ //ban <user> <reason>
            Member target = message.getMentionedMembers().get(0);
            if(target != null){
                String reason = arguments[2];
                if(reason != null){
                    if(member.hasPermission(Permission.BAN_MEMBERS)){
                        target.ban(0, reason).queue();
                        embedBuilder.setTitle("User " + target.getUser().getName() + " was banned");
                        embedBuilder.setDescription("Reason: " + reason);
                        textChannel.sendMessage(embedBuilder.build()).queue();
                    }
                }
            }
        }else{
            textChannel.sendMessage("Correct format is !ban <user> <reason>");
        }
    }
}
