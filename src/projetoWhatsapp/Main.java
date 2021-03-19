package projetoWhatsapp;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		   Scanner scanner = new Scanner(System.in);
		    WhatsappService whatsapp= new WhatsappService();
		    
		    while(true){
		        String line = scanner.nextLine();
		        System.out.println("$" + line);
		        String ui[] = line.split(" ");
		        try {
		            if (ui[0].equals("end"))
		                break;
		            else if (ui[0].equals("addUser")) {
		                whatsapp.createUser(ui[1]);
		            } else if (ui[0].equals("allUsers")) {
		                System.out.print(whatsapp.allUsers());
		            } else if (ui[0].equals("newChat")) {
		            	String userName = ui[1];
		            	String chatName = ui[2];
		            	whatsapp.createChat(userName, chatName);
		            }else if (ui[0].equals("chats")) {
		            	String user = ui[1];
		            	
		            	System.out.println(whatsapp.getUsersChat(user));
		            }
		            else if (ui[0].equals("users")) {
		            	String chat = ui[1];
		            	
		            	System.out.println(whatsapp.getChatUsers(chat));
		            }else if (ui[0].equals("invite")) {
		            	String guess = ui[1];
		            	String invited = ui[2];
		            	String chat = ui[3];
		            	
		            	whatsapp.addByInvite(guess, invited, chat);
		            
		            }else if (ui[0].equals("leave")) {
		            	String user= ui[1];
		            	String chat = ui[2];
		            	
		            	whatsapp.rmUserChat(user, chat);
			        }else if (ui[0].equals("zap")) {
		                String user = ui[1];
		                String chat = ui[2];
		                String msg = "";
		                for(int i = 3; i < ui.length; i++)
		                    msg += ui[i] + " ";
		               
		                whatsapp.sendMessage(user, chat, msg);
		            }
		            else if (ui[0].equals("notify")) {
		            	String user = ui[1];
		            	whatsapp.getNotify(user);
		            }
		            else if (ui[0].equals("ler")) {
		            	String user = ui[1];
			            String chat = ui[2];
			            
			            whatsapp.readMessage(user, chat);
		            }else{
		                System.out.println("fail: comando invalido");
		            }
		        }catch(RuntimeException rt){
		            System.out.println(rt.getMessage());
		        }
		    }
		    scanner.close();
	}

}
