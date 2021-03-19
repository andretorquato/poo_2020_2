package projetoWhatsapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
	String id;
	Map<String, Chat> chats = new HashMap<String, Chat>();
	ArrayList<Notify> notify = new ArrayList<Notify>();
	
	User(String id){
		this.id = id;
	}
	
	public void addNotify(String chatId){
		
		Notify notify = new Notify(chatId, getQtdNotify(chatId));
		
		this.notify.add(notify);
		
	}
	
	public int getQtdNotify(String chatId) {
		int total = 0;
		for(Notify notify: this.notify) {
			if(notify.chatId.equals(chatId)) {
				total++;
			}
		}
		return  total;
	}
	
	public String getAllNotifys() {
		String notifys="[ ";
		for(Chat chat: chats.values()) {
			if(getQtdNotify(chat.id) > 0) {
				notifys += chat.id+"("+getQtdNotify(chat.id)+") ";
			}
		}
		notifys += " ]";
		return notifys;
	}
}
