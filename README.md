## Что это?

Telegram-бот для генерации готового для печати Word-файла, содержащего задания для обучения устному счёту

Параметры заданий и файла (минимальное и максимальное используемые числа, количество страниц) определяет пользователь

Бот принесёт пользу родителям, которые хотят подтянуть навыки устного счёта у своих детей

## Лицензия

Этот проект лицензируется в соответствии с лицензией Apache 2.0

Подробности в файле LICENSE

## Попробовать

[@MentalCalculationBot](https://t.me/MentalCalculationBot) доступен в Telegram

## Автор

Сергей Козырев

## Контакты для связи

Telegram [@taksebe](https://t.me/taksebe)

## Создано с помощью

Java™ SE Development Kit 11.0.5

Git - управление версиями

GitHub - репозиторий

[Telegram Bots](https://core.telegram.org/bots) - взаимодействие с Telegram

[Apache Maven](https://maven.apache.org/) - сборка, управление зависимостями

[Apache POI](https://poi.apache.org/) - создание документа Word

[Lombok](https://projectlombok.org/) - упрощение кода, замена стандартных java-методов аннотациями

[Apache Log4j](https://logging.apache.org/log4j/) - логирование

[JUnit 5](https://junit.org/junit5/) - тестирование

[Heroku](https://www.heroku.com/) - деплой, хостинг

Полный список зависимостей и используемые версии компонентов можно найти в pom.xml

## Сборка и запуск

Перед сборкой необходимо создать бота с помощью [BotFather](https://t.me/botfather) и сохранить его имя и токен (они понадобятся для запуска)

```
git clone https://github.com/taksebe-official/mentalCalculation
cd mentalCalculation
mvn clean install

//далее для Windows
set BOT_NAME=<имя бота>
set BOT_TOKEN=<токен бота>
java -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -cp ./target/classes;./target/dependency/* ru.taksebe.telegram.mentalCalculation.MentalCalculationApplication

//далее для Linux
export BOT_NAME=<имя бота>
export BOT_TOKEN=<токен бота>
java -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -cp ./target/classes:./target/dependency/* ru.taksebe.telegram.mentalCalculation.MentalCalculationApplication
```

## Порядок развёртывания на heroku

Проект писался для релиза на [heroku](https://www.heroku.com/) и содержит специфические для этой площадки файлы:
+ Procfile, в котором устанавливается тип процесса (worker, web  и т.п.) и команда для запуска приложения
+ system.properties, в котором нужно указать версию Java, если она отлична от 8
```
mvn clean install

//предварительно зарегистрироваться на heroku
heroku login
heroku create <имя приложения>
git push heroku master

//добавить имя и токен бота (получены от BotFather) в переменные окружения
heroku config:set BOT_NAME=<имя бота>
heroku config:set BOT_TOKEN=<токен бота>

//удостовериться, что переменные окружения установлены
heroku config:get BOT_NAME
heroku config:get BOT_TOKEN

//установить количество контейнеров (dynos) для типа процесса worker (тип устанавливается в Procfile)
heroku ps:scale worker=1
```

В интерфейсе управления приложением в личном кабинете на [heroku](https://www.heroku.com/) можно перейти к логам (прячутся под кнопкой «More» в правом верхнем углу) и убедиться, что приложение запущено. Также можно проверять бота непосредственно в Telegram

При необходимости в интерфейсе управления приложением на вкладке «Deploy» можно переключить деплой на GitHub-репозиторий (по запросу или автоматически)

## Отдельное спасибо

[Владу](https://github.com/itotx), который возится со мной, неразумным