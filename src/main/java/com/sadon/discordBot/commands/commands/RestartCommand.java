package com.sadon.discordBot.commands.commands;

import com.sadon.discordBot.Main;
import com.sadon.discordBot.commands.types.ServerCommand;
import com.sadon.discordBot.data.LiteSQL;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class RestartCommand implements ServerCommand {

    private final JDA jda = Main.getJda();
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(member.hasPermission(Permission.ADMINISTRATOR)){
            textChannel.sendMessage("Restarting...").queue();
            jda.getPresence().setStatus(OnlineStatus.OFFLINE);
            jda.shutdown();
            LiteSQL.disconnect();
            Main.main(null);
        }else{
            textChannel.sendMessage("You don't have permissions for this").queue();
        }
    }
}
