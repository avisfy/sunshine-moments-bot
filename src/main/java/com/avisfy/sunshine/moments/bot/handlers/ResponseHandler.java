package com.avisfy.sunshine.moments.bot.handlers;

import com.avisfy.sunshine.moments.bot.KeyboardFactory;
import lombok.extern.slf4j.Slf4j;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.avisfy.sunshine.moments.bot.TextConstants.START_TEXT;


@Slf4j
public class ResponseHandler {
    private final SilentSender sender;
    private String path;

    public ResponseHandler(SilentSender sender) {
        this.sender = sender;
    }

    public void startAction(Long chatId) {
        File jsonStorage = new File("moments_from_" + LocalDate.now().toString() + ".json");
        path = jsonStorage.getAbsolutePath();
        try {
            if (jsonStorage.createNewFile()) {
                log.info("New file was created, path: " + jsonStorage.getAbsolutePath());
            } else {
                log.info("New file was not created because file already exist: " + jsonStorage.getAbsolutePath());
            }
        } catch (IOException e) {
            log.error("Can't create file: " + e);
            sendMessage("Error: file was not created! Fix me, please<3", chatId);
            return;
        }
        sendMessage(START_TEXT, chatId);
    }

    private void sendMessage(String text, long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        message.setReplyMarkup(KeyboardFactory.getDefaultsButtons());
        sender.execute(message);
    }
}
