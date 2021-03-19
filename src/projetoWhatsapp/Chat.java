package projetoWhatsapp;

import java.util.HashMap;
import java.util.Map;

public class Chat {
	String id;

	Map<String, User> users = new HashMap<String, User>();
	Map<String, Inbox> inboxes = new HashMap<String, Inbox>();
	
	Chat(String id){
		this.id = id;
	}
	
	public void rmUserChat(String userId){
		users.remove(userId);
	}

	public void deliveryZap(User userSend, String message){
		Inbox inbox = new Inbox(userSend);
		inbox.msgs.add(new Msg(userSend.id, message));
		inboxes.put(userSend.id, inbox);
	}

	public String getInboxes(String userId) {
		String allInboxes = "";
		
		for(Inbox inbox: inboxes.values()) {
				for(Msg msg: inbox.msgs) {
					if(!userId.equals(msg.userId)) {
					allInboxes += msg.userId + ": " + msg.text + System.lineSeparator();
					}
				}
		}
		
		return allInboxes;
	}
}
