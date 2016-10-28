package exh3y.telebot.data.enums;

/**
 * Contains all possible chat types.
 * 
 * @since 0.0.6
 */
public enum ETelegramChatType {

	PRIVATE("private"),
	GROUP("group"),
	SUPERGROUP("supergroup"),
	CHANNEL("channel");
	
	private String chatTypeString;
	ETelegramChatType(String chatTypeString) {
		this.chatTypeString = chatTypeString;
	}
	
	public String getChatTypeString() { return chatTypeString; }
	
	/**
	 * Returns the ETelegramChatType (determined by the content of the type field)
	 * 
	 * @param name
	 * @return The ETelegramChatType
	 * @since 0.0.6
	 */
	public static ETelegramChatType getEnumByName(String name) {
		
		for (ETelegramChatType singleEnum : ETelegramChatType.values()) {
			
			if (singleEnum.getChatTypeString().equals(name)) {
				return singleEnum;
			}
		}
		
		return null;
		
	}
	
}
