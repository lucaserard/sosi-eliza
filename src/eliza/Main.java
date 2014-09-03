package eliza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import eliza.Bot;
import eliza.Phrase;

public class Main {

    public static void main(String[] args) throws IOException {
	Bot bot = new Bot("Elisoa");
	
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Bonjour, je m'appelle Elisoa !");

        String phrase;
        String reponse;
        Boolean fin=true;

        while(fin){

	    phrase=buff.readLine();
            
	    if(phrase!=null){	
                phrase=phrase.toLowerCase();
		reponse=bot.trouverReponse(new Phrase(phrase));
		System.out.println(reponse);
		
            }
            
        }
	
    }

}
