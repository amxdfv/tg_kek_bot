package ru.blogspot.toolkas.telegram.bot.echo;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

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
        inlineKeyboardButton4.setText("Пошел ты нахер козел");
        inlineKeyboardButton4.setCallbackData("poshel_naxer_kozel");
        inlineKeyboardButton5.setText("Пошел ты нахер козел");
        inlineKeyboardButton5.setCallbackData("poshel_naxer_kozel");

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
}
