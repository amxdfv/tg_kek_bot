package ru.blogspot.toolkas.telegram.bot.echo;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

import static ru.blogspot.toolkas.telegram.bot.echo.ListKey.sendInlineKeyBoardMessage;

/**
 * Класс-обработчик поступающих к боту сообщений.
 */
public class EchoBot extends TelegramLongPollingBot {
    /**
     * Метод, который возвращает токен, выданный нам ботом @BotFather.
     * @return токен
     */
    @Override
    public String getBotToken() {
        return "1859376771:AAHTOFDtEoihMDHlcpIzpNi-ftTNnmWG4rA";
    }

    /**
     * Метод-обработчик поступающих сообщений.
     * @param update объект, содержащий информацию о входящем сообщении
     */
    @Override
    public void onUpdateReceived(Update update) {
        try {
            //проверяем есть ли сообщение и текстовое ли оно
            if (update.hasMessage() && update.getMessage().hasText()) {
                //Извлекаем объект входящего сообщения
                Message inMessage = update.getMessage();
                //Создаем исходящее сообщение
              //  SendMessage outMessage = new SendMessage();
                //Указываем в какой чат будем отправлять сообщение
                //(в тот же чат, откуда пришло входящее сообщение)
             //   outMessage.setChatId(inMessage.getChatId());
                //Указываем текст сообщения
               // outMessage.setText("Кукла Нустя не плачь");
                SendVoice sv = new SendVoice();
                sv.setChatId(inMessage.getChatId());
                File testvoice = new File("resourses/test.opus");
                sv.setVoice(testvoice);
                execute(sv);
             //   execute(sendInlineKeyBoardMessage(inMessage.getChatId()));
                //Отправляем сообщение
               // execute(outMessage);
            } else if(update.hasCallbackQuery()){
                try {
                    execute(new SendMessage().setText(
                            update.getCallbackQuery().getData())
                            .setChatId(update.getCallbackQuery().getMessage().getChatId()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который возвращает имя пользователя бота.
     * @return имя пользователя
     */
    @Override
    public String getBotUsername() {
        return "KekQuotesBot";
    }
}
