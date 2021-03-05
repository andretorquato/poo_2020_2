package projetoTwitter;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	String username;
	Map<String, User> followers = new HashMap<String, User>();
	Map<String, User> following = new HashMap<String, User>();
	Map<Integer, Tweet> timeline = new HashMap<Integer, Tweet>();
	int unreadCount;
	
	User(){}
	
	public void sendTweet(Tweet tweet) {
		timeline.put(tweet.getIdTweet(), tweet);
	}
	
	public void follow(User user) {
		following.put(user.username, user);
		user.followers.put(this.username, this);
	}
	
	public void unfollow(User user) {
		following.remove(user.username);
		user.followers.remove(this.username);
	}
	
	public String getFollowers(){
		String followers = "";
		for(User follow: this.followers.values()){
			followers = follow.username + " ";
		}
		return followers;
	}
	
	public String getFollowing(){
		String following = "";
		for(User follow: this.following.values()){
			following = follow.username + " ";
		}
		return following;
	}
	
	public Tweet getTweet(int idTweet) {
		Tweet tweet = null;
	
		if(timeline.get(idTweet) != null) {
			tweet = timeline.get(idTweet);
		}else {
			System.out.println("Tweet não encontrado!");
		}
		
		return  tweet;
	}
	public String getTimeline() {
		String timeline = "";
		for(Tweet line: this.timeline.values()) {
			timeline += line.getIdTweet()
					+ ":" + line.getUsername() 
					+ " (" + line.getMessage() +")"
					+ line.getLikes() 
					+ System.lineSeparator()
					;
		}
		return timeline;
	}	
}
