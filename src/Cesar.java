import java.util.Scanner;

public class Cesar {
	
	private String mensagens;
	private int chave;
    private static char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
    
public Cesar() {
    super();
    	
}
    public Cesar(String mensagens, int chave) {
    	super();
    	this.mensagens=mensagens;
    	this.chave=chave;
    }
	public String getMensagens() {
		return mensagens;
	}
	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public static char[] getAlfabeto() {
		return alfabeto;
	}
	public static void setAlfabeto(char[] alfabeto) {
		Cesar.alfabeto = alfabeto;
	}

     public void lerDados() {
    	 
    	 	Scanner sc = new Scanner(System.in);
    	 	
    	 	System.out.println("Me passe uma mensagem");
    	 	setMensagens(sc.nextLine().toUpperCase());
    	 	
    	 	System.out.println("Me passe uma chave");
    	 	setChave(sc.nextInt());
    	 	
    	 	sc.close();
     }
     
     public char[] encriptar() {
    	 
    	 char[] novaMensagem = new char[getMensagens().length()];
    	 
    	 for(int i=0; i<getMensagens().length(); i++) {
    		 
    		 if(getMensagens().charAt(i)==' ') {
    			 novaMensagem[i]=getMensagens().charAt(i);	 
    		 } else {
    			 for(int j=0; j<getAlfabeto().length; j++) {
    				 
    				if(getMensagens().charAt(i)==getAlfabeto()[j]) {
    					
    					if(getChave()<0) {
    						novaMensagem[i]=getAlfabeto()[(j+getChave()+getAlfabeto().length)%getAlfabeto().length];
    					    j=getAlfabeto().length;
    					}else {
    						novaMensagem[i]=getAlfabeto()[(j+getChave())%getAlfabeto().length];
    						j=getAlfabeto().length;
    					}
    				}else {
    					novaMensagem[i]=getMensagens().charAt(i);
    				}
    			 }
    		 }
    	 }
    	 
    	 return novaMensagem;
     }

     public char[] descriptar() {
    	 
         char[] novaMensagem = new char[getMensagens().length()];
    	 
    	    for(int i=0; i<getMensagens().length(); i++) {
    		 
    		  if(getMensagens().charAt(i)==' ') {
    			 novaMensagem[i]=getMensagens().charAt(i);	 
    		   } else {
    			   
    			   for(int j=0; j<getAlfabeto().length; j++) {
    				 
    				 if(getMensagens().charAt(i)==getAlfabeto()[j]) {
    					
    				   if(j<getChave()) {
    						novaMensagem[i]=getAlfabeto()[(j+getChave()+getAlfabeto().length)%getAlfabeto().length];
    					    j=getAlfabeto().length;
    					}else {
    						novaMensagem[i]=getAlfabeto()[(j-getChave())%getAlfabeto().length];
    						j=getAlfabeto().length;
    					}
    				   
    				}else {
    					
    					novaMensagem[i]=getMensagens().charAt(i);
    				}
    			 }
    		 }
    	 }
    	 
    	 return novaMensagem;
     }
}
