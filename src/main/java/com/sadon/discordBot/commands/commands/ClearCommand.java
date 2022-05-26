package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

import javax.naming.InsufficientResourcesException;
import java.util.List;

public class ClearCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(arguments.length<2){
            textChannel.sendMessage("Please use !clear <amount>").queue();
        }else{
            try{
                try{
                    message.delete().queue();
                }catch(InsufficientPermissionException exception){
                    textChannel.sendMessage("I don't have permission for that.");
                }

                List<Message> messageList = textChannel.getHistory().retrievePast(Integer.parseInt(arguments[1])).complete();
                textChannel.deleteMessages(messageList).queue();

                textChannel.sendMessage("cleared " + arguments[1] + " messages in " +textChannel.getAsMention()).queue();
            }catch(IllegalArgumentException exception){
                if(exception.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                    textChannel.sendMessage("Sorry but you can't delete more than 100 messages at once");
                }else{
                    textChannel.sendMessage("Sorry but you can't delete messages that are 2 weeks old+");
                }
            }
        }
    }
}
