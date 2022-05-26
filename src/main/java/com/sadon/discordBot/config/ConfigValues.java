package com.sadon.discordBot.config;

public class ConfigValues {

    public static String BOT_TOKEN;
    public static String STATUS;
    public static String[] DESCRIPTION;

    public static void loadValues(){
        BOT_TOKEN = ConfigManager.getKeys("token");
        STATUS = ConfigManager.getKeys("status");
        DESCRIPTION = ConfigManager.getKeys("description").split(",");
    }
}
