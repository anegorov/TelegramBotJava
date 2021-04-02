package ru.taksebe.telegram.mentalCalculation;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.taksebe.telegram.mentalCalculation.telegram.Bot;

import java.util.Map;

public class MentalCalculationApplication {
    private static final Map<String, String> getenv = System.getenv();

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            String bName = "litwin.house";
            String bToken = "1727260134:AAHJ1o2D0vnV3MH6ZlVWQnHxgpdiUYjvZmE";
            System.out.println(String.format("%s - %s", bName, bToken));
            botsApi.registerBot(new Bot(bName, bToken));
//            botsApi.registerBot(new Bot(getenv.get("BOT_NAME"), getenv.get("BOT_TOKEN")));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}