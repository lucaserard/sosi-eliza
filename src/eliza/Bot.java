package eliza;
import eliza.Mot;
import eliza.Phrase;
import java.util.*;
import java.lang.*;

public class Bot{
    private String nom;

    public Bot(String nom){
	this.nom=nom;
    }

    public String trouverReponse(Phrase zbeul){
	String  res= "Je ne comprend pas.";
	Boolean ouiNon = trouverOuiNon(zbeul);
	if (ouiNon){
	    int i=(int)Math.round(Math.random()*3);
	    switch(i){
	    case 1 : res= "En es-tu sûr ?"; break;
	    case 2 : res= "En es-tu certain ?"; break;
	    case 3 : res = "Développe, exprime le fond de ta pensée"; break;
	    }
	}



	Mot sujet = trouverSujet(zbeul);

	if (sujet==null){
	    int i=(int)Math.round(Math.random()*4);
	   
	    switch(i){
	    case 1 : res = "Je ne suis pas sûr de tout comprendre, peux-tu développer ?";break;
	    case 2 : res = "Développe le fond de ta pensée."; break;
	    case 3 : res =  "Dis m'en plus, c'est très interessant."; break;
	    case 4 : res = "Le penses-tu vraiment ?"; break;
	    }
	}
	   
	


	return res;



		
	
    }

    private Mot trouverSujet(Phrase zbeul){
	if((zbeul.estPresent(new Mot("Je")))||(zbeul.estPresent(new Mot("J"))))
	    return (new Mot("Tu"));
	if(zbeul.estPresent(new Mot("Tu"))||zbeul.estPresent(new Mot("T")))
	    return (new Mot("Je"));
	return null;
    }

    private Boolean trouverOuiNon(Phrase zbeul){
	return ((zbeul.estPresent(new Mot("oui")))||(zbeul.estPresent(new Mot("non"))));
    }
    
}