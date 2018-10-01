import java.util.Scanner;

public class GuessTheMovie {
    public static void main (String [] args) throws Exception {
        Game game = new Game();
        //escolhe o filme
        String movie = game.chooseMovie();

        //faz a string com os traços
        String movieGuess = game.startGame(movie);

        boolean hasWon = false;
        int guessesQuantity = 0;
        String wrongGuess = "";

        System.out.println(movie);

        while (guessesQuantity < 10) {
            System.out.println("You are guessisng: "+ movieGuess);
            System.out.println("You have guessed ("+guessesQuantity+") wrong letters: "+ wrongGuess);
            System.out.print("Guess a letter: ");
            Scanner scanner = new Scanner(System.in);
            //le a letra de entrada
            String playerGuess = scanner.nextLine();

            //ve se a letra de entrada está no palpite errado
            boolean alreadyGuessed = false;
            for(int i=0 ; i < wrongGuess.length(); i++) {
                if (wrongGuess.substring(i,i+1).equals(playerGuess)) {
                    alreadyGuessed = true;
                    System.out.println("You already wrong this letter!");
                }
            }

            //analiza a entrada do jogo
            if(!alreadyGuessed) {
                String analyzeGuess = game.changeChar(movie, movieGuess, playerGuess);

                if (analyzeGuess.equals(movieGuess)) {
                    guessesQuantity++;
                    wrongGuess += playerGuess + " ";
                } else {
                    movieGuess = analyzeGuess;
                }
                if (movie.equals(movieGuess)) {
                    hasWon = true;
                    break;
                }
            }
        }

        if(hasWon) {
            System.out.println("You guessed the movie: "+movie);
            System.out.println("You Win");
        }else {
            System.out.println("You have guessed (10) wrong letters");
            System.out.println("You Lose");
        }

    }
}
