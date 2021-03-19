package projetoWhatsapp;

import java.util.ArrayList;

public class Inbox {
	User user;
	ArrayList<Msg> msgs = new ArrayList<Msg>();
	
	Inbox(User user){
		this.user = user;
	}
}
