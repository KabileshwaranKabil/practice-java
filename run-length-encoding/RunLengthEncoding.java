public class RunLengthEncoding{
	public static String encode(String input){
		if(input==null || input.isEmpty()){
			return "";
		}
		StringBuilder encoded = new StringBuilder();
		int count=1;
		for(int i=1;i<input.length();i++){ 
			if(input.charAt(i)==input.charAt(i-1)){
				count++;
			}else{
				encoded.append(count).append(input.charAt(i-1));
				count=1 ;//Reset count	 
			}
			
		}
		encoded.append(count).append(input.charAt(input.length()-1));
		return encoded.toString();
	}
	public static void main(String[] args){
		String input="AAAABBBCCDAA";
		String encoded=encode(input);
		System.out.println("Orginal: "+input);
		System.out.println("Encoded: "+encoded);
	}
}
