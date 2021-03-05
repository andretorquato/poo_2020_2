package projetoTwitter;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	Map<String, User> users = new HashMap<String, User>();
	Map<Integer, Tweet> tweets = new HashMap<Integer, Tweet>();
	int nextTweetId;
	
	Controller(){
		this.nextTweetId = 0;
	}
	public void addUser(String username) {

		if(users.get(username) == null) {
		User user = new User();
		user.username = username;
		users.put(username, user);
		}else {
			System.out.println("fail: usuário já cadastrado");
		}
	}
	public User getUser(String username) {
		User user = null;
		if(users.get(username) != null) {
			user = users.get(username);
		}else {
			System.out.println("fail: Usuário não encontrado!");
		}
		return user;
	}
	public String getUsers(){
		String users="";
		for(User user: this.users.values()) {
			users += 
					System.lineSeparator() 
					+ user.username +
					System.lineSeparator() +
					"Seguindo:" +
					"[ "+ user.getFollowing() + "]"
					+ System.lineSeparator() +
					"Seguidores:" +
					"[ "+user.getFollowers() + "]"
					+ System.lineSeparator();
				
		}
		return users;
	}
	
	public void sendTweet(String username, String message) {
		User user = getUser(username);
		
		
		if(user != null) {
		String[] getFollowers = user.getFollowers().split(" ");
		
		
		
		Tweet tweet = new Tweet(nextTweetId, username, message);
		
		user.sendTweet(tweet);
		tweets.put(nextTweetId, tweet);
		
		if(!getFollowers[0].equals("")) {
			for (int i = 0; i < getFollowers.length; i++) {
				User follower = getUser(getFollowers[i]);
				follower.sendTweet(tweet);
			}
		}
		
		this.nextTweetId++;
		}
	}
	@Override
	public String toString() {	
		return getUsers();
	}
}
