package com.sadon.discordBot.music;

import com.sadon.discordBot.Main;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.Guild;

public class MusicController {

    private Guild guild;
    private AudioPlayer audioPlayer;

    public MusicController(Guild guild){
        this.guild = guild;
        this.audioPlayer = Main.getAudioPlayerManager().createPlayer();

        this.guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(audioPlayer));
        this.audioPlayer.setVolume(15);
    }

    public Guild getGuild(){
        if(this.guild != null) {
            return this.guild;
        }
        return null;
    }

    public AudioPlayer getAudioPlayer(){
        if(this.audioPlayer != null){
            return audioPlayer;
        }
        return null;
    }
}
