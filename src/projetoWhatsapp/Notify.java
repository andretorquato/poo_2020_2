package projetoWhatsapp;

public class Notify {
	String chatId;
	int unreadCount;
	
	Notify(String chatId, int unreadCount){
		this.chatId = chatId;
		this.unreadCount += unreadCount;
	}
}
