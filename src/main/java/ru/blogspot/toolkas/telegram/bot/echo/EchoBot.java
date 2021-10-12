package ru.blogspot.toolkas.telegram.bot.echo;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

import static ru.blogspot.toolkas.telegram.bot.echo.ListKey.ListKekReturn;
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

            if (update.hasInlineQuery()) {
               System.out.println("запросили из чата");
                update.getInlineQuery();
                execute(ListKekReturn(update.getInlineQuery()));
                System.out.println("нажал на кнопку");

            } else if (update.hasMessage() && update.getMessage().hasText()) {


                Message inMessage = update.getMessage();


               execute(sendInlineKeyBoardMessage(inMessage.getChatId()));

            } else if(update.hasCallbackQuery()){
                try {
                    String filepath = "resourses";
                    String filename =  update.getCallbackQuery().getData();
                    SendVoice sv = new SendVoice();
                    sv.setChatId(update.getCallbackQuery().getMessage().getChatId());
                   if (System.getProperty("os.name").contains("Windows")){
                       filepath = filepath +  "/";
                   } else {
                       filepath = filepath +  "\\";
                   }
                    File testvoice = new File(filepath+filename+".opus");
                    sv.setVoice(testvoice);
                      execute(sv);

                    /*execute(new SendMessage().setText(
                            update.getCallbackQuery().getData())
                            .setChatId(update.getCallbackQuery().getMessage().getChatId()));*/
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
