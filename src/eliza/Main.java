package eliza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Bonjour, je m'appelle Elisoa !");

        String phrase;

        Boolean fin=true;

        while(fin){

            //if(buff.readLine()!=null){
                phrase=buff.readLine(); 
                phrase=phrase.toLowerCase();
                System.out.println(repondre(phrase));
           // }
            
        }

	}
	
	private static String repondre(String ph){
        if(ph!=null){
            return ph;
        }
        else{
            return"fail";
        }
    }

}
