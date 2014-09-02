package eliza;
import eliza.Mot;
import java.util.*;

public class Phrase{
    public enum TypePhrase {AFFIRMATIVE,INTERROGATIVE};
    private ArrayList<Mot> lesMots;
    private char ponct;
        
    public Phrase(String laPhrase){
	String[] mots  = laPhrase.split(" ");
	for(String i : mots){
	    lesMots.add(new Mot(i));
	}	
	ponct = laPhrase.charAt(laPhrase.length());
    }
  
    public TypePhrase obtenirType(){	
	if(this.ponct == '?'){
	    return TypePhrase.INTERROGATIVE;
	}
	return TypePhrase.AFFIRMATIVE;
    }

    public boolean estPresent(Mot mot){
	return lesMots.contains(mot);
    }
    
    public boolean estNegative(){
	if((this.lesMots.contains(new Mot("ne")))||(this.lesMots.contains(new Mot("pas")))||(this.lesMots.contains(new Mot("n")))){
	    return true;
	}
	return false;
    }

    
    public Mot[] obtenirMots(){
	return (Mot[])lesMots.toArray();
    }


}

