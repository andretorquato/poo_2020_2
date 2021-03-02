package projetoContatoStar;

public class Fone {
	String label;
	String number;
	
	Fone(String label, String number){
		this.label= label;
		this.number= number;
	}
	boolean validate(String number){
		for(int i = 0; i < number.length();i++) {
			if(number.charAt(i) == '0' || number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3' || number.charAt(i) == '4' || number.charAt(i) == '5' ||  number.charAt(i) == '6' || number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9' ||number.charAt(i) == '(' || number.charAt(i) == ')' ) {				
				if((i+1) == number.length()) {
					return true;
				}
			}else {
				return false;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.label+":"+this.number;
	}
}
