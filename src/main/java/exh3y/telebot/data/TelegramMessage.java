package exh3y.telebot.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import exh3y.telebot.data.games.TelegramGame;
import exh3y.telebot.util.ObjectMapperFactory;

import kong.unirest.json.JSONObject;

import java.io.IOException;

public class TelegramMessage {

    private int message_id;
    private TelegramChat chat;
    private int date;

    private TelegramUser from = null;
    private TelegramUser forward_from = null;
    private TelegramChat forward_from_chat = null;
    private Integer forward_from_message_id = null;
    private Integer forward_date = null;
    private TelegramMessage reply_to_message = null;
    private Integer edit_date = null;
    private String text = null;
    private TelegramMessageEntity[] entities = null;
    private TelegramAudio audio = null;
    private TelegramDocument document = null;
    private TelegramGame game = null;
    private TelegramPhotoSize[] photo = null;
    private TelegramSticker sticker = null;
    private TelegramVideo video = null;
    private TelegramVoice voice = null;
    private String caption = null;
    private TelegramContact contact = null;
    private TelegramLocation location = null;
    private TelegramVenue venue = null;
    private TelegramUser new_chat_member = null;
    private TelegramUser left_chat_member = null;
    private String new_chat_title = null;
    private TelegramPhotoSize[] new_chat_photo = null;
    private Boolean delete_chat_photo = null;
    private Boolean group_chat_created = null;
    private Boolean supergroup_chat_created = null;
    private Boolean channel_chat_created = null;
    private Integer migrate_to_chat_id = null;
    private Integer migrate_from_chat_id = null;
    private TelegramMessage pinned_message = null;

    public static TelegramMessage create(JSONObject json) throws IOException {

        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
        return mapper.readValue(json.toString(), TelegramMessage.class);
    }

    /**
     * Returns the command as array.
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
     * @param message_id the message_id to set
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
     * @param chat the chat to set
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
     * @param date the date to set
     */
    public void setDate(int date) {

        this.date = date;
    }

    public boolean hasFrom() {

        return from != null;
    }

    /**
     * @return the from
     */
    public TelegramUser getFrom() {

        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(TelegramUser from) {

        this.from = from;
    }

    public boolean hasForward_from() {

        return forward_from != null;
    }

    /**
     * @return the forward_from
     */
    public TelegramUser getForward_from() {

        return forward_from;
    }

    /**
     * @param forward_from the forward_from to set
     */
    public void setForward_from(TelegramUser forward_from) {

        this.forward_from = forward_from;
    }

    public boolean hasForward_from_chat() {

        return forward_from_chat != null;
    }

    /**
     * @return the forward_from_chat
     */
    public TelegramChat getForward_from_chat() {

        return forward_from_chat;
    }

    /**
     * @param forward_from_chat the forward_from_chat to set
     */
    public void setForward_from_chat(TelegramChat forward_from_chat) {

        this.forward_from_chat = forward_from_chat;
    }

    public Integer getForward_from_message_id() {

        return forward_from_message_id;
    }

    public void setForward_from_message_id(Integer forward_from_message_id) {

        this.forward_from_message_id = forward_from_message_id;
    }

    public boolean hasForward_date() {

        return forward_date != null;
    }

    /**
     * @return the forward_date
     */
    public Integer getForward_date() {

        return forward_date;
    }

    /**
     * @param forward_date the forward_date to set
     */
    public void setForward_date(Integer forward_date) {

        this.forward_date = forward_date;
    }

    public boolean hasReply_to_message() {

        return reply_to_message != null;
    }

    /**
     * @return the reply_to_message
     */
    public TelegramMessage getReply_to_message() {

        return reply_to_message;
    }

    /**
     * @param reply_to_message the reply_to_message to set
     */
    public void setReply_to_message(TelegramMessage reply_to_message) {

        this.reply_to_message = reply_to_message;
    }

    public boolean hasEdit_date() {

        return edit_date != null;
    }

    /**
     * @return the edit_date
     */
    public Integer getEdit_date() {

        return edit_date;
    }

    /**
     * @param edit_date the edit_date to set
     */
    public void setEdit_date(Integer edit_date) {

        this.edit_date = edit_date;
    }

    public boolean hasText() {

        return text != null;
    }

    /**
     * @return the text
     */
    public String getText() {

        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {

        this.text = text;
    }

    public boolean hasEntities() {

        return entities != null;
    }

    /**
     * @return the entities
     */
    public TelegramMessageEntity[] getEntities() {

        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(TelegramMessageEntity[] entities) {

        this.entities = entities;
    }

    public boolean hasAudio() {

        return audio != null;
    }

    /**
     * @return the audio
     */
    public TelegramAudio getAudio() {

        return audio;
    }

    /**
     * @param audio the audio to set
     */
    public void setAudio(TelegramAudio audio) {

        this.audio = audio;
    }

    public boolean hasDocument() {

        return document != null;
    }

    /**
     * @return the document
     */
    public TelegramDocument getDocument() {

        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(TelegramDocument document) {

        this.document = document;
    }

    public boolean hasGame() {

        return game != null;
    }

    /**
     * @return the game
     */
    public TelegramGame getGame() {

        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(TelegramGame game) {

        this.game = game;
    }

    public boolean hasPhoto() {

        return photo != null;
    }

    /**
     * @return the photo
     */
    public TelegramPhotoSize[] getPhoto() {

        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(TelegramPhotoSize[] photo) {

        this.photo = photo;
    }

    public boolean hasSticker() {

        return sticker != null;
    }

    /**
     * @return the sticker
     */
    public TelegramSticker getSticker() {

        return sticker;
    }

    /**
     * @param sticker the sticker to set
     */
    public void setSticker(TelegramSticker sticker) {

        this.sticker = sticker;
    }

    public boolean hasVideo() {

        return video != null;
    }

    /**
     * @return the video
     */
    public TelegramVideo getVideo() {

        return video;
    }

    /**
     * @param video the video to set
     */
    public void setVideo(TelegramVideo video) {

        this.video = video;
    }

    public boolean hasVoice() {

        return voice != null;
    }

    /**
     * @return the voice
     */
    public TelegramVoice getVoice() {

        return voice;
    }

    /**
     * @param voice the voice to set
     */
    public void setVoice(TelegramVoice voice) {

        this.voice = voice;
    }

    public boolean hasCaption() {

        return caption != null;
    }

    /**
     * @return the caption
     */
    public String getCaption() {

        return caption;
    }

    /**
     * @param caption the caption to set
     */
    public void setCaption(String caption) {

        this.caption = caption;
    }

    public boolean hasContact() {

        return contact != null;
    }

    /**
     * @return the contact
     */
    public TelegramContact getContact() {

        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(TelegramContact contact) {

        this.contact = contact;
    }

    public boolean hasLocation() {

        return location != null;
    }

    /**
     * @return the location
     */
    public TelegramLocation getLocation() {

        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(TelegramLocation location) {

        this.location = location;
    }

    public boolean hasVenue() {

        return venue != null;
    }

    /**
     * @return the venue
     */
    public TelegramVenue getVenue() {

        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(TelegramVenue venue) {

        this.venue = venue;
    }

    public boolean hasNew_chat_member() {

        return new_chat_member != null;
    }

    /**
     * @return the new_chat_member
     */
    public TelegramUser getNew_chat_member() {

        return new_chat_member;
    }

    /**
     * @param new_chat_member the new_chat_member to set
     */
    public void setNew_chat_member(TelegramUser new_chat_member) {

        this.new_chat_member = new_chat_member;
    }

    public boolean hasLeft_chat_member() {

        return left_chat_member != null;
    }

    /**
     * @return the left_chat_member
     */
    public TelegramUser getLeft_chat_member() {

        return left_chat_member;
    }

    /**
     * @param left_chat_member the left_chat_member to set
     */
    public void setLeft_chat_member(TelegramUser left_chat_member) {

        this.left_chat_member = left_chat_member;
    }

    public boolean hasNew_chat_title() {

        return new_chat_title != null;
    }

    /**
     * @return the new_chat_title
     */
    public String getNew_chat_title() {

        return new_chat_title;
    }

    /**
     * @param new_chat_title the new_chat_title to set
     */
    public void setNew_chat_title(String new_chat_title) {

        this.new_chat_title = new_chat_title;
    }

    public boolean hasNew_chat_photo() {

        return new_chat_photo != null;
    }

    /**
     * @return the new_chat_photo
     */
    public TelegramPhotoSize[] getNew_chat_photo() {

        return new_chat_photo;
    }

    /**
     * @param new_chat_photo the new_chat_photo to set
     */
    public void setNew_chat_photo(TelegramPhotoSize[] new_chat_photo) {

        this.new_chat_photo = new_chat_photo;
    }

    public boolean hasDelete_chat_photo() {

        return delete_chat_photo != null;
    }

    /**
     * @return the delete_chat_photo
     */
    public Boolean getDelete_chat_photo() {

        return delete_chat_photo;
    }

    /**
     * @param delete_chat_photo the delete_chat_photo to set
     */
    public void setDelete_chat_photo(Boolean delete_chat_photo) {

        this.delete_chat_photo = delete_chat_photo;
    }

    public boolean hasGroup_chat_created() {

        return group_chat_created != null;
    }

    /**
     * @return the group_chat_created
     */
    public Boolean getGroup_chat_created() {

        return group_chat_created;
    }

    /**
     * @param group_chat_created the group_chat_created to set
     */
    public void setGroup_chat_created(Boolean group_chat_created) {

        this.group_chat_created = group_chat_created;
    }

    public boolean hasSupergroup_chat_created() {

        return supergroup_chat_created != null;
    }

    /**
     * @return the supergroup_chat_created
     */
    public Boolean getSupergroup_chat_created() {

        return supergroup_chat_created;
    }

    /**
     * @param supergroup_chat_created the supergroup_chat_created to set
     */
    public void setSupergroup_chat_created(Boolean supergroup_chat_created) {

        this.supergroup_chat_created = supergroup_chat_created;
    }

    public boolean hasChannel_chat_created() {

        return channel_chat_created != null;
    }

    /**
     * @return the channel_chat_created
     */
    public Boolean getChannel_chat_created() {

        return channel_chat_created;
    }

    /**
     * @param channel_chat_created the channel_chat_created to set
     */
    public void setChannel_chat_created(Boolean channel_chat_created) {

        this.channel_chat_created = channel_chat_created;
    }

    public boolean hasMigrate_to_chat_id() {

        return migrate_to_chat_id != null;
    }

    /**
     * @return the migrate_to_chat_id
     */
    public Integer getMigrate_to_chat_id() {

        return migrate_to_chat_id;
    }

    /**
     * @param migrate_to_chat_id the migrate_to_chat_id to set
     */
    public void setMigrate_to_chat_id(Integer migrate_to_chat_id) {

        this.migrate_to_chat_id = migrate_to_chat_id;
    }

    public boolean hasMigrate_from_chat_id() {

        return migrate_from_chat_id != null;
    }

    /**
     * @return the migrate_from_chat_id
     */
    public Integer getMigrate_from_chat_id() {

        return migrate_from_chat_id;
    }

    /**
     * @param migrate_from_chat_id the migrate_from_chat_id to set
     */
    public void setMigrate_from_chat_id(Integer migrate_from_chat_id) {

        this.migrate_from_chat_id = migrate_from_chat_id;
    }

    public boolean hasPinned_message() {

        return pinned_message != null;
    }

    /**
     * @return the pinned_message
     */
    public TelegramMessage getPinned_message() {

        return pinned_message;
    }

    /**
     * @param pinned_message the pinned_message to set
     */
    public void setPinned_message(TelegramMessage pinned_message) {

        this.pinned_message = pinned_message;
    }
}
