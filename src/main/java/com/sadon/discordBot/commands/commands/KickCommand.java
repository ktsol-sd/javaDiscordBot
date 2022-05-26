package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.Main;
import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class KickCommand implements ServerCommand{

    private final JDA jda = Main.getJda();

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0x6e304b);

        if(arguments.length == 3){ // kick <user> <reason>
            Member target = message.getMentionedMembers().get(0);
            if(target != null){
                String reason = arguments[2];
                if(reason != null){
                    if(member.hasPermission(Permission.KICK_MEMBERS)){
                        target.kick(reason).queue();
                        embedBuilder.setTitle("User " + target.getUser().getName() + " was kicked");
                        embedBuilder.setDescription("Reason: " + reason);
                        textChannel.sendMessage(embedBuilder.build()).queue();
                    }
                }
            }
        }else{
            textChannel.sendMessage("The right format is - !kick <user> <reason>").queue();
        }
    }
}
