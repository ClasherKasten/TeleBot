package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramMessage extends JSONObject {

	private int									message_id;
	private TelegramChat						chat;
	private int									date;

	private Optional<TelegramUser>				from;
	private Optional<TelegramUser>				forward_from;
	private Optional<TelegramChat>				forward_from_chat;
	private Optional<Integer>					forward_date;
	private Optional<TelegramMessage>			reply_to_message;
	private Optional<Integer>					edit_date;
	private Optional<String>					text;
	private Optional<TelegramMessageEntity[]>	entities;
	private Optional<TelegramAudio>				audio;
	private Optional<TelegramDocument>			document;
	private Optional<TelegramGame>				game;
	private Optional<TelegramPhotoSize[]>		photo;
	private Optional<TelegramSticker>			sticker;
	private Optional<TelegramVideo>				video;
	private Optional<TelegramVoice>				voice;
	private Optional<String>					caption;
	private Optional<TelegramContact>			contact;
	private Optional<TelegramLocation>			location;
	private Optional<TelegramVenue>				venue;
	private Optional<TelegramUser>				new_chat_member;
	private Optional<TelegramUser>				left_chat_member;
	private Optional<String>					new_chat_title;
	private Optional<TelegramPhotoSize[]>		new_chat_photo;
	private Optional<Boolean>					delete_chat_photo;
	private Optional<Boolean>					group_chat_created;
	private Optional<Boolean>					supergroup_chat_created;
	private Optional<Boolean>					channel_chat_created;
	private Optional<Integer>					migrate_to_chat_id;
	private Optional<Integer>					migrate_from_chat_id;
	private Optional<TelegramMessage>			pinned_message;

	public static TelegramMessage create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramMessage.class);
	}

	/**
	 * <p>
	 * Returns the command as array.
	 * </p>
	 * 
	 * @return The command as array
	 * @since 0.0.3
	 */
	public String[] toCommandArray() {

		return this.getText().split(" ");
	}

	/**
	 * @return the message_id
	 */
	public int getMessage_id() {

		return message_id;
	}

	/**
	 * @param message_id
	 *            the message_id to set
	 */
	public void setMessage_id(int message_id) {

		this.message_id = message_id;
	}

	/**
	 * @return the chat
	 */
	public TelegramChat getChat() {

		return chat;
	}

	/**
	 * @param chat
	 *            the chat to set
	 */
	public void setChat(TelegramChat chat) {

		this.chat = chat;
	}

	/**
	 * @return the date
	 */
	public int getDate() {

		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(int date) {

		this.date = date;
	}

	public boolean hasFrom() {

		return this.from.isPresent();
	}

	/**
	 * @return the from
	 */
	public TelegramUser getFrom() throws NoSuchElementException {

		return from.get();
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(TelegramUser from) {

		this.from = Optional.of(from);
	}

	public boolean hasForward_from() {

		return this.forward_from.isPresent();
	}

	/**
	 * @return the forward_from
	 */
	public TelegramUser getForward_from() throws NoSuchElementException {

		return forward_from.get();
	}

	/**
	 * @param forward_from
	 *            the forward_from to set
	 */
	public void setForward_from(TelegramUser forward_from) {

		this.forward_from = Optional.of(forward_from);
	}

	public boolean hasForward_from_chat() {

		return this.forward_from_chat.isPresent();
	}

	/**
	 * @return the forward_from_chat
	 */
	public TelegramChat getForward_from_chat() throws NoSuchElementException {

		return forward_from_chat.get();
	}

	/**
	 * @param forward_from_chat
	 *            the forward_from_chat to set
	 */
	public void setForward_from_chat(TelegramChat forward_from_chat) {

		this.forward_from_chat = Optional.of(forward_from_chat);
	}

	public boolean hasForward_date() {

		return this.forward_date.isPresent();
	}

	/**
	 * @return the forward_date
	 */
	public Integer getForward_date() throws NoSuchElementException {

		return forward_date.get();
	}

	/**
	 * @param forward_date
	 *            the forward_date to set
	 */
	public void setForward_date(Integer forward_date) {

		this.forward_date = Optional.of(forward_date);
	}

	public boolean hasReply_to_message() {

		return this.reply_to_message.isPresent();
	}

	/**
	 * @return the reply_to_message
	 */
	public TelegramMessage getReply_to_message() throws NoSuchElementException {

		return reply_to_message.get();
	}

	/**
	 * @param reply_to_message
	 *            the reply_to_message to set
	 */
	public void setReply_to_message(TelegramMessage reply_to_message) {

		this.reply_to_message = Optional.of(reply_to_message);
	}

	public boolean hasEdit_date() {

		return this.edit_date.isPresent();
	}

	/**
	 * @return the edit_date
	 */
	public Integer getEdit_date() throws NoSuchElementException {

		return edit_date.get();
	}

	/**
	 * @param edit_date
	 *            the edit_date to set
	 */
	public void setEdit_date(Integer edit_date) {

		this.edit_date = Optional.of(edit_date);
	}

	public boolean hasText() {

		return this.text.isPresent();
	}

	/**
	 * @return the text
	 */
	public String getText() throws NoSuchElementException {

		return text.get();
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {

		this.text = Optional.of(text);
	}

	public boolean hasEntities() {

		return this.entities.isPresent();
	}

	/**
	 * @return the entities
	 */
	public TelegramMessageEntity[] getEntities() throws NoSuchElementException {

		return entities.get();
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(TelegramMessageEntity[] entities) {

		this.entities = Optional.of(entities);
	}

	public boolean hasAudio() {

		return this.audio.isPresent();
	}

	/**
	 * @return the audio
	 */
	public TelegramAudio getAudio() throws NoSuchElementException {

		return audio.get();
	}

	/**
	 * @param audio
	 *            the audio to set
	 */
	public void setAudio(TelegramAudio audio) {

		this.audio = Optional.of(audio);
	}

	public boolean hasDocument() {

		return this.document.isPresent();
	}

	/**
	 * @return the document
	 */
	public TelegramDocument getDocument() throws NoSuchElementException {

		return document.get();
	}

	/**
	 * @param document
	 *            the document to set
	 */
	public void setDocument(TelegramDocument document) {

		this.document = Optional.of(document);
	}

	public boolean hasGame() {

		return this.game.isPresent();
	}

	/**
	 * @return the game
	 */
	public TelegramGame getGame() throws NoSuchElementException {

		return game.get();
	}

	/**
	 * @param game
	 *            the game to set
	 */
	public void setGame(TelegramGame game) {

		this.game = Optional.of(game);
	}

	public boolean hasPhoto() {

		return this.photo.isPresent();
	}

	/**
	 * @return the photo
	 */
	public TelegramPhotoSize[] getPhoto() throws NoSuchElementException {

		return photo.get();
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(TelegramPhotoSize[] photo) {

		this.photo = Optional.of(photo);
	}

	public boolean hasSticker() {

		return this.sticker.isPresent();
	}

	/**
	 * @return the sticker
	 */
	public TelegramSticker getSticker() throws NoSuchElementException {

		return sticker.get();
	}

	/**
	 * @param sticker
	 *            the sticker to set
	 */
	public void setSticker(TelegramSticker sticker) {

		this.sticker = Optional.of(sticker);
	}

	public boolean hasVideo() {

		return this.video.isPresent();
	}

	/**
	 * @return the video
	 */
	public TelegramVideo getVideo() throws NoSuchElementException {

		return video.get();
	}

	/**
	 * @param video
	 *            the video to set
	 */
	public void setVideo(TelegramVideo video) {

		this.video = Optional.of(video);
	}

	public boolean hasVoice() {

		return this.voice.isPresent();
	}

	/**
	 * @return the voice
	 */
	public TelegramVoice getVoice() throws NoSuchElementException {

		return voice.get();
	}

	/**
	 * @param voice
	 *            the voice to set
	 */
	public void setVoice(TelegramVoice voice) {

		this.voice = Optional.of(voice);
	}

	public boolean hasCaption() {

		return this.caption.isPresent();
	}

	/**
	 * @return the caption
	 */
	public String getCaption() throws NoSuchElementException {

		return caption.get();
	}

	/**
	 * @param caption
	 *            the caption to set
	 */
	public void setCaption(String caption) {

		this.caption = Optional.of(caption);
	}

	public boolean hasContact() {

		return this.contact.isPresent();
	}

	/**
	 * @return the contact
	 */
	public TelegramContact getContact() throws NoSuchElementException {

		return contact.get();
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(TelegramContact contact) {

		this.contact = Optional.of(contact);
	}

	public boolean hasLocation() {

		return this.location.isPresent();
	}

	/**
	 * @return the location
	 */
	public TelegramLocation getLocation() throws NoSuchElementException {

		return location.get();
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(TelegramLocation location) {

		this.location = Optional.of(location);
	}

	public boolean hasVenue() {

		return this.venue.isPresent();
	}

	/**
	 * @return the venue
	 */
	public TelegramVenue getVenue() throws NoSuchElementException {

		return venue.get();
	}

	/**
	 * @param venue
	 *            the venue to set
	 */
	public void setVenue(TelegramVenue venue) {

		this.venue = Optional.of(venue);
	}

	public boolean hasNew_chat_member() {

		return this.new_chat_member.isPresent();
	}

	/**
	 * @return the new_chat_member
	 */
	public TelegramUser getNew_chat_member() throws NoSuchElementException {

		return new_chat_member.get();
	}

	/**
	 * @param new_chat_member
	 *            the new_chat_member to set
	 */
	public void setNew_chat_member(TelegramUser new_chat_member) {

		this.new_chat_member = Optional.of(new_chat_member);
	}

	public boolean hasLeft_chat_member() {

		return this.left_chat_member.isPresent();
	}

	/**
	 * @return the left_chat_member
	 */
	public TelegramUser getLeft_chat_member() throws NoSuchElementException {

		return left_chat_member.get();
	}

	/**
	 * @param left_chat_member
	 *            the left_chat_member to set
	 */
	public void setLeft_chat_member(TelegramUser left_chat_member) {

		this.left_chat_member = Optional.of(left_chat_member);
	}

	public boolean hasNew_chat_title() {

		return this.new_chat_title.isPresent();
	}

	/**
	 * @return the new_chat_title
	 */
	public String getNew_chat_title() throws NoSuchElementException {

		return new_chat_title.get();
	}

	/**
	 * @param new_chat_title
	 *            the new_chat_title to set
	 */
	public void setNew_chat_title(String new_chat_title) {

		this.new_chat_title = Optional.of(new_chat_title);
	}

	/**
	 * @return the new_chat_photo
	 */
	public TelegramPhotoSize[] getNew_chat_photo() throws NoSuchElementException {

		return new_chat_photo.get();
	}

	/**
	 * @param new_chat_photo
	 *            the new_chat_photo to set
	 */
	public void setNew_chat_photo(TelegramPhotoSize[] new_chat_photo) {

		this.new_chat_photo = Optional.of(new_chat_photo);
	}

	/**
	 * @return the delete_chat_photo
	 */
	public Boolean getDelete_chat_photo() {

		return delete_chat_photo.orElse(false);
	}

	/**
	 * @param delete_chat_photo
	 *            the delete_chat_photo to set
	 */
	public void setDelete_chat_photo(Boolean delete_chat_photo) {

		this.delete_chat_photo = Optional.of(delete_chat_photo);
	}

	/**
	 * @return the group_chat_created
	 */
	public Boolean getGroup_chat_created() {

		return group_chat_created.orElse(false);
	}

	/**
	 * @param group_chat_created
	 *            the group_chat_created to set
	 */
	public void setGroup_chat_created(Boolean group_chat_created) {

		this.group_chat_created = Optional.of(group_chat_created);
	}

	/**
	 * @return the supergroup_chat_created
	 */
	public Boolean getSupergroup_chat_created() {

		return supergroup_chat_created.orElse(false);
	}

	/**
	 * @param supergroup_chat_created
	 *            the supergroup_chat_created to set
	 */
	public void setSupergroup_chat_created(Boolean supergroup_chat_created) {

		this.supergroup_chat_created = Optional.of(supergroup_chat_created);
	}

	/**
	 * @return the channel_chat_created
	 */
	public Boolean getChannel_chat_created() {

		return channel_chat_created.orElse(false);
	}

	/**
	 * @param channel_chat_created
	 *            the channel_chat_created to set
	 */
	public void setChannel_chat_created(Boolean channel_chat_created) {

		this.channel_chat_created = Optional.of(channel_chat_created);
	}

	public boolean hasMigrate_to_chat_id() {

		return this.migrate_to_chat_id.isPresent();
	}

	/**
	 * @return the migrate_to_chat_id
	 */
	public Integer getMigrate_to_chat_id() throws NoSuchElementException {

		return migrate_to_chat_id.get();
	}

	/**
	 * @param migrate_to_chat_id
	 *            the migrate_to_chat_id to set
	 */
	public void setMigrate_to_chat_id(Integer migrate_to_chat_id) {

		this.migrate_to_chat_id = Optional.of(migrate_to_chat_id);
	}

	public boolean hasMigrate_from_chat_id() {

		return this.migrate_from_chat_id.isPresent();
	}

	/**
	 * @return the migrate_from_chat_id
	 */
	public Integer getMigrate_from_chat_id() throws NoSuchElementException {

		return migrate_from_chat_id.get();
	}

	/**
	 * @param migrate_from_chat_id
	 *            the migrate_from_chat_id to set
	 */
	public void setMigrate_from_chat_id(Integer migrate_from_chat_id) {

		this.migrate_from_chat_id = Optional.of(migrate_from_chat_id);
	}

	public boolean hasPinned_message() {

		return this.pinned_message.isPresent();
	}

	/**
	 * @return the pinned_message
	 */
	public TelegramMessage getPinned_message() throws NoSuchElementException {

		return pinned_message.get();
	}

	/**
	 * @param pinned_message
	 *            the pinned_message to set
	 */
	public void setPinned_message(TelegramMessage pinned_message) {

		this.pinned_message = Optional.of(pinned_message);
	}

}
