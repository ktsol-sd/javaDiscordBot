package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand {

    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message){
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0x6e304b);
        embedBuilder.setTitle("Useful Commands");
        embedBuilder.setDescription("**!help** - Shows all commands" +
                "\n**!clear <integer>** clears some messages" +
                "\n**!kick <user> <reason>** kicks the user" +
                "\n**!ban <user> <reason>** bans the user" +
                "\n**!unban <userID>** unbans the user" +
                "\n**!cooldown** Testing adding cooldown" +
                "\n**!test** Testing how permissions work" +
                "\n**!edit <channelID> <messageID> ** Edits your message to 'edited'" +
                "\n**!restart** restarts the bot" +
                "\n**!play <yt url>** plays the song linked (youtube only)");

        textChannel.sendMessage(embedBuilder.build()).queue();
    }

}
