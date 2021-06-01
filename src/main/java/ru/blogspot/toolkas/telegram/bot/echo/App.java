package ru.blogspot.toolkas.telegram.bot.echo;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class App {
    public static void main(String[] args) throws TelegramApiRequestException {
        System.out.println("запуск");
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(new EchoBot());
    }
}
