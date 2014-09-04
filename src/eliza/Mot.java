package eliza;

public class Mot{
    String leMot;
    
    public Mot(String mot){
	this.leMot=mot;
    }
    
    public String getString(){
	return leMot;
    }

    public boolean equals(Mot mot){
    	return this.leMot==mot.getString();
    }

    public void retirerDernierCaractere(){
        leMot=leMot.substring(0,leMot.length()-2);
    }

    public void ajouterCaractere(char c){
        leMot=leMot+c;
    }
}