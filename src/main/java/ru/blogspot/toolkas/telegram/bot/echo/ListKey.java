package ru.blogspot.toolkas.telegram.bot.echo;

import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultPhoto;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultVoice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListKey {

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();


        inlineKeyboardButton1.setText("Пошел ты нахер, козел");
         inlineKeyboardButton1.setCallbackData("poshel_naxer_kozel");
        inlineKeyboardButton2.setText("Вы кто такие, я вас не звал");
        inlineKeyboardButton2.setCallbackData("vi_kto_takie_ia_vas_ne_zval");
        inlineKeyboardButton3.setText("Выйди отсюда, розбийник");
        inlineKeyboardButton3.setCallbackData("vidi_otsuda_razbiinik");
        inlineKeyboardButton4.setText("Петух закукарекал");
        inlineKeyboardButton4.setCallbackData("pitux_zakukarekal");
        inlineKeyboardButton5.setText("Такого тебе кадра нарисовали");
        inlineKeyboardButton5.setCallbackData("takogo_tebe_kadra_narisovali");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow5 = new ArrayList<>();


        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        keyboardButtonsRow4.add(inlineKeyboardButton4);
        keyboardButtonsRow5.add(inlineKeyboardButton5);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        rowList.add(keyboardButtonsRow5);


        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Выбери нужную фразу").setReplyMarkup(inlineKeyboardMarkup);
    }

    public static AnswerInlineQuery ListKekReturn(InlineQuery inlineQuery)  {





        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();

        InputTextMessageContent txt = new InputTextMessageContent();
        txt.setMessageText("хуй");
        answerInlineQuery.setInlineQueryId(inlineQuery.getId());
        InlineQueryResultPhoto ivr = new InlineQueryResultPhoto();
        ivr.setPhotoUrl("https://i.picsum.photos/id/237/536/354.jpg?hmac=i0yVXW1ORpyCZpQ-CknuyV-jbtU7_x9EBQVhvT5aRr0");
        ivr.setThumbUrl("https://i.picsum.photos/id/237/536/354.jpg?hmac=i0yVXW1ORpyCZpQ-CknuyV-jbtU7_x9EBQVhvT5aRr0");
        ivr.setId("2");
        ivr.setTitle("lol");
        InlineQueryResultVoice ivc = new InlineQueryResultVoice();
        ivc.setId("1");
        ivc.setTitle("kek");
        ivc.setVoiceUrl("http://localhost:8080/homeweb/home");
        List<InlineQueryResult> results = new ArrayList<>();
        results.add(ivc);
        answerInlineQuery.setResults(results);
        return answerInlineQuery;
    }

}
