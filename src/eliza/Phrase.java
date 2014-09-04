package eliza;
import eliza.Mot;
import java.util.*;

public class Phrase{
    public enum TypePhrase {AFFIRMATIVE,INTERROGATIVE};
    private ArrayList<Mot> lesMots = new ArrayList<Mot>();
    private char ponct;
        
    public Phrase(String laPhrase){
	String[] mots;
	

	ponct = laPhrase.charAt(laPhrase.length()-1);
	if ((ponct=='.' )||(ponct =='!')||(ponct =='?')){
	    mots  = (laPhrase.substring(0,laPhrase.length()-1)).split("\\s");
	}else{
	    mots  = laPhrase.split("\\s");		
	}
	for(String i : mots){   
	    Mot mot = new Mot(i);
	    lesMots.add(mot);
	}		
    }
  
    public TypePhrase obtenirType(){	
	if(this.ponct == '?'){
	    return TypePhrase.INTERROGATIVE;
	}
	return TypePhrase.AFFIRMATIVE;
    }

    public boolean estPresent(Mot mot){
	
	for(Mot i : lesMots){
	    if(i.getString().equals(mot.getString())){
		return true;
	    }
	}
	
	return false;
    }
    
    public boolean estNegative(){
	return ((this.lesMots.contains(new Mot("ne")))||(this.lesMots.contains(new Mot("pas")))||(this.lesMots.contains(new Mot("n"))));
    }

    
    public Mot[] obtenirMots(){
	return (Mot[])lesMots.toArray();
    }

    public String toString(){
    	StringBuilder str=new StringBuilder();
    	for(Mot i : lesMots){
	    str.append(i);
	}
	return str.toString();
    }
}

