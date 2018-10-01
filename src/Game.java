import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Game {
    public String chooseMovie() throws Exception{
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> movieList = new ArrayList<String>();
        while (scanner.hasNextLine()){
            movieList.add(scanner.nextLine());
        }
        return  movieList.get((int)(Math.random() * 25));
    }

    public String startGame(String movie){
        String movieGuess = "";
        for(int i = 0; i < movie.length(); i++){
            if (movie.substring(i,i+1).equals(" ")) {
                movieGuess += " ";
            } else {
                movieGuess += "_";
            }
        }
        return movieGuess;
    }

    public String changeChar(String movie, String movieGuess, String playerGuess){
        String charChanged = "";
        for(int i = 0; i < movieGuess.length(); i++){

            if (movie.substring(i,i+1).equals(playerGuess)) {
                charChanged += playerGuess;
            }else{
                charChanged += movieGuess.substring(i,i+1);
            }
        }
        return charChanged;
    }
}
