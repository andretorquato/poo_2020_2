package projetoWhatsapp;

import java.util.HashMap;
import java.util.Map;

public class WhatsappService {
	Map<String, Chat> rep_chat = new HashMap<String, Chat>();
	Map<String, User> rep_user = new HashMap<String, User>();
	
	public void createUser(String key) {
		if(this.userExiste(key) == false) {
			rep_user.put(key, new User(key));
		}else {
			System.out.println("fail: Usuário já cadastrado");
		}
		
	}
	
	public void createChat(String userId, String chatId) {
		if(userExiste(userId) && !chatExiste(chatId)) {
			Chat chat = new Chat(chatId);
			User user = rep_user.get(userId);
			chat.users.put(userId, user);
			
			rep_chat.put(chatId, chat);
			user.chats.put(chatId, chat);
			
		}else if(!userExiste(userId)) {
			System.out.println("fail: Usuário não existe");
		}else if(chatExiste(chatId)) {
			System.out.println("fail: o Chat '"+ chatId + "' já existe");
		}
	}
	
	public Boolean chatExiste(String key) {
		if(rep_chat.get(key) != null) {
			return true;
		}
		return false;
	}
	
	public Boolean userExiste(String key) {
		if(rep_user.get(key) != null) {
			return true;
		}
		return false;
	}
	
	public String allUsers() {
		String allUsers = "[ ";
		for(User user: rep_user.values()) {
			allUsers += user.id + " ";
		}
		allUsers += "]";
		return allUsers;
	}

	public String getUsersChat(String userId) {
		if(userExiste(userId)) {
			User user = rep_user.get(userId);
			String myChats = userId + " [ ";
			for (Chat chat: user.chats.values()) {
				myChats += chat.id + " ";
			}
			myChats += "]";
			return myChats;
		}else {
			return "fail: Usuário não existe";
		}
	}
	
	public String getChatUsers(String chatId) {
		if(chatExiste(chatId)) {
			Chat chat = rep_chat.get(chatId);
			String userInChat = chatId + " [ ";
			for (User user: chat.users.values()) {
				userInChat += user.id + " ";
			}
			userInChat += "]";
			return userInChat;
		}else {
			return "fail: Chat não existe";
		}
	}
	
	public void getNotify(String userId) {
		if(userExiste(userId) ){
			User user = rep_user.get(userId);
			System.out.println(user.getAllNotifys());
		}else{
			System.out.println("fail: Usuário não está no grupo");
		}
		
	}
	
	public void addByInvite(String guessId, String invitedId, String chatId) {
		Chat chat = rep_chat.get(chatId);
		User invitedUser = rep_user.get(invitedId);
		User guessUser =  rep_user.get(guessId);
		if(userExiste(guessId) && userExiste(invitedId) && chatExiste(chatId)) {
			if(invitedUser.chats.get(chatId) != null) {
				guessUser.chats.put(chatId, chat);
				chat.users.put(guessId, guessUser);
			}else {
				System.out.println("fail: "+ invitedId + "não está no grupo" + chatId);
			}
		}else if(!userExiste(guessId)){
			System.out.println("fail: Convidado não existe!");
		}else if(!userExiste(invitedId)) {
			System.out.println("fail: não está no grupo "+chatId);
		}else if(chatExiste(chatId)) {
			System.out.println("fail: grupo "+ chatId + " não existe");
		}
	}

	public void rmUserChat(String userId, String chatId) {
		if(userExiste(userId) && chatExiste(chatId)){
			User user = rep_user.get(userId);
			Chat chat = rep_chat.get(chatId);
			if(chat.users.get(user.id) != null) {
				chat.users.remove(userId);
				user.chats.remove(chatId);
			}else {
				System.out.println("fail: Usuário não está no grupo");
			}
			
		}else if(!userExiste(userId)) {
			System.out.println("fail: Usuário não está no grupo");
		}else if(!chatExiste(chatId)) {
			System.out.println("fail: Chat não encontrado");
		}
	}

	public void sendMessage(String userId, String chatId, String message) {
		if(userExiste(userId) && chatExiste(chatId)) {
			User user = rep_user.get(userId);
			Chat chat = rep_chat.get(chatId);
				if(user.chats.get(chatId) != null) {
					chat.deliveryZap(user, message);
					for(User otherUser: rep_user.values()) {
						if(otherUser.chats.get(chatId) != null && !otherUser.id.equals(userId)) {
							otherUser.addNotify(chatId);
						}
					}
				}
			}else if(!userExiste(userId)) {
				System.out.println("fail: Usuário não está no grupo");
			}else if(!chatExiste(chatId)) {
				System.out.println("fail: Chat não encontrado");
			}
	}
	
	public void readMessage(String userId, String chatId) {
		if(userExiste(userId) && chatExiste(chatId)){
			User user = rep_user.get(userId);
			Chat chat = rep_chat.get(chatId);
			if(chat.users.get(user.id) != null) {
				System.out.println(chat.getInboxes(user.id)); 
			}else {
				System.out.println("fail: Usuário não está no grupo");
			}
			
		}else if(!userExiste(userId)) {
			System.out.println("fail: Usuário não está no grupo");
		}else if(!chatExiste(chatId)) {
			System.out.println("fail: Chat não encontrado");
		}
	}
}
