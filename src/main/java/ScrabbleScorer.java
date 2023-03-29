import java.util.Locale;
import java.util.Scanner;

public class ScrabbleScorer {

    Scanner userInput = new Scanner(System.in);

    public void run(){
        System.out.println("Welcome to Scrabble Scorer! Enter the word you would like scored, " +
                "or two words separated by a single space for a comparison. Do not include punctuation.");
        String toScore = userInput.nextLine().toLowerCase();
        if (toScore.contains(" ")) {
            String higherScoring = compareScores(toScore);
            System.out.println("\"" + higherScoring + "\"" + " is the higher scoring word and is worth " + scoreSingle(higherScoring) + " points");
        } else {
            System.out.println("The score is " + scoreSingle(toScore));
        }
    }

    private String compareScores(String words){
        String[] comparison = words.split(" ");
        if (scoreSingle(comparison[0]) > scoreSingle(comparison[1])){
            return comparison[0];
        } else {
            return comparison[1];
        }
    }

    private int scoreSingle(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'e' || word.charAt(i) == 'a' || word.charAt(i) == 'o' || word.charAt(i) == 'n'
            || word.charAt(i) == 'r' || word.charAt(i) == 't'|| word.charAt(i) == 's' || word.charAt(i) == 'l' || word.charAt(i) == 'u'){
                score += 1;
            } else if (word.charAt(i) == 'd' || word.charAt(i) == 'g'){
                score += 2;
            } else if (word.charAt(i) == 'b' || word.charAt(i) == 'c'|| word.charAt(i) == 'm' || word.charAt(i) == 'p') {
                score += 3;
            } else if (word.charAt(i) == 'f' || word.charAt(i) == 'h' || word.charAt(i) == 'v' || word.charAt(i) == 'w'
                    || word.charAt(i) == 'y'){
                score += 4;
            } else if (word.charAt(i) == 'k') {
                score += 5;
            } else if (word.charAt(i) == 'j' || word.charAt(i) == 'x') {
                score += 8;
            } else if (word.charAt(i) == 'q' || word.charAt(i) == 'z'){
                score += 10;
            }
        }
        return score;
    }
}
