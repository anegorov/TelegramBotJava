package ru.taksebe.telegram.mentalCalculation.telegram.commands.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.taksebe.telegram.mentalCalculation.Utils;

/**
 * Команда получение списка строящихся объектов
 */
public class Contacts extends ServiceCommand {
    private Logger logger = LoggerFactory.getLogger(Contacts.class);

    public Contacts(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = Utils.getUserName(user);

        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "*Контакты*\n" +
                        "hello@litwin.house*\n" +
                        "+7 812 209 07 10*\n\n" +
                        "https://yandex.ru/maps/-/CCUUB4V3gA");

        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
    }
}