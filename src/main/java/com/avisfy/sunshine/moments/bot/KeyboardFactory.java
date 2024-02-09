package com.avisfy.sunshine.moments.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardFactory {
    public static ReplyKeyboard getDefaultsButtons() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(TextConstants.B_ADD_MOMENT);
        row1.add(TextConstants.B_GET_MOMENTS);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(TextConstants.B_GET_MOMENT_LIST);
        row2.add(TextConstants.B_GET_COMMAND_LIST);
        return new ReplyKeyboardMarkup(List.of(row1, row2));
    }
}
