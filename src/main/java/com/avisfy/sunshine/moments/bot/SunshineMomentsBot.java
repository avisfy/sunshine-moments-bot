package com.avisfy.sunshine.moments.bot;

import com.avisfy.sunshine.moments.bot.config.BotConfig;
import com.avisfy.sunshine.moments.bot.handlers.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static com.avisfy.sunshine.moments.bot.TextConstants.EMPTY_TEXT;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.CREATOR;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

@Component
public class SunshineMomentsBot extends AbilityBot {
    private final Long creatorId;

    private final ResponseHandler responseHandler;
    @Override
    public long creatorId() {
        return creatorId;
    }

    @Autowired
    public SunshineMomentsBot(BotConfig botConfig) {
        super(botConfig.getBotToken(), botConfig.getBotUsername());
        creatorId = botConfig.getCreatorId();
        responseHandler = new ResponseHandler(silent);
    }

    public Ability startBot() {
        return Ability
                .builder()
                .name("start")
                .info("says hello!")
                .locality(ALL)
                .privacy(PUBLIC)
                .setStatsEnabled(true)
                .action(ctx -> responseHandler.startAction(ctx.chatId()))
//                .action(ctx -> silent.send(START_TEXT, ctx.chatId()))
                .build();
    }

    public Ability addMoment() {
        return Ability
                .builder()
                .name("add_moment")
                .info("adds your happy moment to the list")
                .locality(ALL)
                .privacy(PUBLIC)
                .setStatsEnabled(true)
                .action(ctx -> silent.send(EMPTY_TEXT, ctx.chatId()))
                .build();
    }

    public Ability getMoments() {
        return Ability
                .builder()
                .name("get_moments")
                .info("gets moments one by one")
                .locality(ALL)
                .privacy(PUBLIC)
                .setStatsEnabled(true)
                .action(ctx -> silent.send(EMPTY_TEXT, ctx.chatId()))
                .build();
    }

    public Ability getMomentsList() {
        return Ability
                .builder()
                .name("get_moments_list")
                .info("gets your list of happy moments in one message")
                .locality(ALL)
                .privacy(PUBLIC)
                .setStatsEnabled(true)
                .action(ctx -> silent.send(EMPTY_TEXT, ctx.chatId()))
                .build();
    }

    public Ability setFile() {
        return Ability
                .builder()
                .name("set_file")
                .info("[conf] allows you to upload file with moments")
                .locality(ALL)
                .privacy(CREATOR)
                .setStatsEnabled(true)
                .action(ctx -> silent.send(EMPTY_TEXT, ctx.chatId()))
                .build();
    }

    public Ability resetFile() {
        return Ability
                .builder()
                .name("reset_file")
                .info("[conf] drops old file and begins to use new one")
                .locality(ALL)
                .privacy(CREATOR)
                .setStatsEnabled(true)
                .action(ctx -> silent.send(EMPTY_TEXT, ctx.chatId()))
                .build();
    }

    public Ability getFile() {
        return Ability
                .builder()
                .name("get_file")
                .info("[conf] download file with moments")
                .locality(ALL)
                .privacy(CREATOR)
                .setStatsEnabled(true)
                .action(ctx -> silent.send(EMPTY_TEXT, ctx.chatId()))
                .build();
    }

}
