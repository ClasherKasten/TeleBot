# TeleBot [![TeleBot Tests](https://circleci.com/gh/ClasherKasten/TeleBot/tree/master.svg?style=svg)](https://circleci.com/gh/ClasherKasten/TeleBot/?branch=master)[![Release](https://jitpack.io/v/ClasherKasten/TeleBot.svg)](https://jitpack.io/#ClasherKasten/TeleBot)
A simple java library to create telegram bots. Work in progress.

# Get it
Just add TeleBot to your dependencies using [jitpack](https://jitpack.io/#ClasherKasten/TeleBot):

**Maven:**
```
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

```
<dependency>
    <groupId>com.github.ClasherKasten</groupId>
    <artifactId>TeleBot</artifactId>
    <version>0.1.3</version>
</dependency>
```

# How to use this library
Creating a simple telegram bot responding to text commands is quite easy using TeleBot!
Just start by creating a TeleBot object and register your actions to react to the corresponding commands:

## Since 0.1.0 (introduction of new datatypes)

**Main class:**
```java
TeleBot bot = new TeleBot("yourTokenHere");
bot.registerCommandAction("/test", new TestAction(bot));
bot.start();
```

**TestAction (implementing TelegramActionHandler):**
```java
private TeleBot bot;

public TestAction(TeleBot bot) {
  this.bot = bot;
}

@Override
public void onMessageReceive(TelegramMessage message) {

  try {
    bot.sendMessage(message.getChat().getId(), "Responding to 'test'");
  } catch (JSONException | UnirestException e) {
    // Catch the error
  }
}
```

## Before 0.1.0

**Main class:**
```java
TeleBot bot = new TeleBot("yourTokenHere");
bot.registerCommandAction("/test", new TestAction(bot));
bot.start();
```

**TestAction (implementing TelegramActionHandler):**
```java
private TeleBot bot;

public TestAction(TeleBot bot) {
  this.bot = bot;
}

@Override
public void onCommandReceive(int chatId, JSONObject responseObject) {

  try {
    bot.sendMessage(chatId, "Responding to 'test'");
  } catch (JSONException | UnirestException e) {
    // Catch the error
  }
}
```
