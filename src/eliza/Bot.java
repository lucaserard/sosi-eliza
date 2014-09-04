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
    int i;
    String res="";
	i=(int)Math.round(Math.random()*3);
	switch(i){
		case 1 : res= "Je comprend...";
		case 2 : res= "Je vois...";
		case 3 : res= "D'accord !";
	}
	Boolean ouiNon = trouverOuiNon(zbeul);
	
	
	
	if (ouiNon){
	    i=(int)Math.round(Math.random()*3);
	    
	    switch(i){
	    case 1 : res= "En es-tu sur ?"; break;
	    case 2 : res= "En es-tu certain ?"; break;
	    case 3 : res = "Pourquoi cela ?"; break;
	    }
	    return res;
	}
	
	if((zbeul.estPresent(new Mot("bonjour")))||(zbeul.estPresent(new Mot("salut")))){
		return "De quoi veux-tu parler aujourd'hui ?";
	}

	Mot sujet = trouverSujet(zbeul);
	System.out.println(sujet.getString()); /*fonctionne bien et renvois majoritairement des "ta mere"*/



	if((zbeul.obtenirType()==Phrase.TypePhrase.INTERROGATIVE)&&( sujet.equals(new Mot("je")) )){
		return "Nous ne sommes pas a MA seance chez le psy ! Parlons plutot de toi.";
	}else if(zbeul.obtenirType()==Phrase.TypePhrase.INTERROGATIVE){
		return "Pourquoi te poses-tu tant de questions ?";
	}

	if((zbeul.obtenirType()==Phrase.TypePhrase.AFFIRMATIVE)&&( sujet.equals(new Mot("tu")) )){
		Phrase rep = new Phrase('?');
		Mot verbe = zbeul.obtenirMotSuivant(new Mot("je"));
		Mot nouveauVerbe;
		if (verbe.getString().equals("suis")) {
			nouveauVerbe= new Mot("es");
		}else if (verbe.getString().equals("vais")){
			nouveauVerbe= new Mot("vas");
		}else {
			verbe.ajouterCaractere('s');
			nouveauVerbe=verbe;
		}
		i=(int)Math.round(Math.random()*5);
		switch(i){
			case 1 : rep.ajouterMot(new Mot("Pourquoi")); break;
			case 2 : rep.ajouterMot(new Mot("Comment")); break;
			case 3 : rep.ajouterMot(new Mot("Quand")); break;
			case 4 : rep.ajouterMot(new Mot("A quelle fin")); break;
			case 5 : rep.ajouterMot(new Mot("Depuis quand")); break;
		}
		rep.ajouterMot(nouveauVerbe);
		rep.ajouterMot(sujet);

		//rajout des complements
		Mot cpt=zbeul.obtenirMotSuivant(verbe);
		while(cpt.getString()!=""){
			rep.ajouterMot(cpt);
			cpt=zbeul.obtenirMotSuivant(cpt);
		}
		return rep.toString();
	}

	if (sujet==null){
	     i=(int)Math.round(Math.random()*4);
	    
	    switch(i){
	    	case 1 : res = "Je ne suis pas sur de tout comprendre, peux-tu developper ?";break;
	    	case 2 : res = "Developpe le fond de ta pensee."; break;
	    	case 3 : res =  "Dis m'en plus, c'est tres interessant."; break;
	    	case 4 : res = "Le penses-tu vraiment ?"; break;
	    }
	    return res;
	}

	return res;
    }

    public String trouverReponse(String phrase){
		return this.trouverReponse(new Phrase(phrase));
	}

    private Mot trouverSujet(Phrase zbeul){
	
	if((zbeul.estPresent(new Mot("je")))||(zbeul.estPresent(new Mot("j")))){
	    return (new Mot("tu"));
	}
	
	if(zbeul.estPresent(new Mot("tu"))||zbeul.estPresent(new Mot("t"))){
	    return (new Mot("je"));
	}
	return new Mot("");
    }
    
    private Boolean trouverOuiNon(Phrase zbeul){
	return ( (zbeul.estPresent(new Mot("oui"))) || (zbeul.estPresent(new Mot("non"))));
    }
    
}