package projetoTwitter;

import java.util.LinkedList;

public class Tweet {
	private int idTweet;
	private String username;
	private String message;
	LinkedList<String> likes = new LinkedList<String>();
	
	Tweet(int id, String user, String message){
		this.idTweet = id;
		this.username = user;
		this.message = message;
	}

	public int getIdTweet() {
		return idTweet;
	}

	public void setIdTweet(int idTweet) {
		this.idTweet = idTweet;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLikes() {
		String likes = "";
		
		if(this.likes.size() > 0) {
			likes = "[ ";
			for(String username: this.likes) {
				likes += username + " ";
			}
			likes += " ]";
		}
		
		return likes;
	}

	public void setLikes(String username) {
		this.likes.add(username);
	}
	
	
	@Override
	public String toString() {
		return "Tweet [idTweet=" + idTweet + ", username=" + username + ", message=" + message + ", likes=" + likes
				+ "]";
	}


}
