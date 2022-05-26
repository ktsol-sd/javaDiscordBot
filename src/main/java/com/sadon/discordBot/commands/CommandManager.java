package com.sadon.discordBot.commands;


import com.sadon.discordBot.commands.commands.*;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandManager extends ListenerAdapter {

    private final HelpCommand helpCommand;
    private final ClearCommand clearCommand;
    private final KickCommand kickCommand;
    private final BanCommand banCommand;
    private final UnbanCommand unbanCommand;
    private final CooldownCommand cooldownCommand;
    private final TestCommand testCommand;
    private final EditCommand editCommand;
    private final RestartCommand restartCommand;
    private final PlayCommand playCommand;


    public CommandManager(){
        this.helpCommand= new HelpCommand();
        this.clearCommand = new ClearCommand();
        this.kickCommand = new KickCommand();
        this.banCommand = new BanCommand();
        this.unbanCommand = new UnbanCommand();
        this.cooldownCommand = new CooldownCommand();
        this.testCommand = new TestCommand();
        this.editCommand = new EditCommand();
        this.restartCommand = new RestartCommand();
        this.playCommand = new PlayCommand();
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        if(!event.getAuthor().isBot()) {
            String[] arguments = event.getMessage().getContentRaw().split(" ");
            if(arguments != null){
                Guild guild = event.getGuild();
                Member member = event.getMember();
                TextChannel textChannel = event.getChannel();
                Message message = event.getMessage();

                switch(arguments[0]){
                    case "!help":
                        this.helpCommand.performCommand(arguments, guild, member, textChannel, message);
                        break;
                    case "!clear":
                        this.clearCommand.performCommand(arguments, guild, member, textChannel, message);
                    case "!kick":
                        kickCommand.performCommand(arguments, guild, member, textChannel, message);
                        break;
                    case "!ban":
                        banCommand.performCommand(arguments, guild, member, textChannel,  message);
                        break;
                    case"!unban":
                        unbanCommand.performCommand(arguments,guild, member, textChannel,message);
                        break;
                    case"!cooldown":
                        cooldownCommand.performCommand(arguments,guild,member,textChannel,message);
                        break;
                    case"!test":
                        testCommand.performCommand(arguments, guild, member, textChannel, message);
                        break;
                    case"!edit":
                        editCommand.performCommand(arguments, guild, member, textChannel, message);
                        break;
                    case"!restart":
                        restartCommand.performCommand(arguments,guild,member,textChannel,message);
                        break;
                    case"!play":
                        playCommand.performCommand(arguments, guild, member, textChannel, message);
                        break;

                }
            }
        }
    }
}
