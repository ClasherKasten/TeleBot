package exh3y.telebot.data.enums;

public enum ETelegramParseMode {
    MARKDOWN("Markdown"),
    HTML("HTML");

    private String value;

    private ETelegramParseMode(String value) {

        this.value = value;
    }

    public String getValue() {

        return this.value;
    }
}
