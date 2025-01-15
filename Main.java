import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Main {

    private static final HashMap<String, String> vocabularies = new HashMap<>();
    private static String currentWord = null;
    private static int correctCount = 0;
    private static int totalCount = 0;

    public static void main(String[] args) {
        // Preloading some vocabulary

        vocabularies.put("gehen", "ir");
        vocabularies.put("Sommer", "verano");
        vocabularies.put("Geschichte", "historia");
        vocabularies.put("Landschaft", "paisaje");
        vocabularies.put("können", "poder");
        vocabularies.put("Arbenteuer", "aventura");
        vocabularies.put("Natur", "naturaleza");
        vocabularies.put("Utensilien", "utensilios");
        vocabularies.put("Burg", "castillio");
        vocabularies.put("Sonne", "sol");
        vocabularies.put("invierno", "Winter");
        vocabularies.put("wandern", "caminata");
        vocabularies.put("Meer", "mar");
        vocabularies.put("See", "lago");
        vocabularies.put("Fluss", "río");
        vocabularies.put("sitzen", "sentarse"); //not sure
        vocabularies.put("Brücke", "Puente");
        vocabularies.put("Himmel", "Cielo");
        vocabularies.put("Hafen", "Puerto");
        vocabularies.put("lachen", "reír");
        vocabularies.put("Strand", "playa");
        vocabularies.put("Stadt", "ciudad");
        vocabularies.put("Berg", "montaña");
        vocabularies.put("Auto", "auto");
        vocabularies.put("Bus", "autobús");
        vocabularies.put("machen", "hacer");
        vocabularies.put("Baum", "arból");
        vocabularies.put("historische Stadt", "ciudad historia");

        vocabularies.put("warmes Wetter", "clima calor");
        vocabularies.put("kaltes Wetter", "clima frío");
        vocabularies.put("Wolke", "nube");
        vocabularies.put("repräsentieren", "representan");
        vocabularies.put("Stimmung", "ambiente");
        vocabularies.put("Wald", "bosque");
        vocabularies.put("Sportkleidung", "ropa deportiva");
        vocabularies.put("Tisch", "mesa");
        vocabularies.put("Stuhl", "silla");
        vocabularies.put("Zeit mit Freunden verbringen", "Pasar tiempo con amigos");
        vocabularies.put("Spaß", "Diversión");
        vocabularies.put("Getränk", "Bebida");
        vocabularies.put("Essen", "comida");
        vocabularies.put("Weg", "camino");
        vocabularies.put("Schiff", "barco");

        // Create the main JFrame
        JFrame frame = new JFrame("Vocabulary Learning App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Top Panel: Display Word
        JPanel topPanel = new JPanel();
        JLabel wordLabel = new JLabel("Word:");
        JLabel displayWord = new JLabel("");
        topPanel.add(wordLabel);
        topPanel.add(displayWord);
        frame.add(topPanel, BorderLayout.NORTH);

        // Center Panel: Input and Feedback
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1)); // Adjusted layout to fit the button properly
        JTextField userInput = new JTextField();
        JButton checkButton = new JButton("Check"); // Now properly placed and visible
        JLabel feedbackLabel = new JLabel("Enter your answer above.", SwingConstants.CENTER);
        centerPanel.add(userInput);
        centerPanel.add(checkButton);
        centerPanel.add(feedbackLabel);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel: Control Buttons and Stats
        JPanel bottomPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        JLabel statsLabel = new JLabel("Score: 0/0");
        bottomPanel.add(nextButton);
        bottomPanel.add(statsLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Logic for "Next" Button
        nextButton.addActionListener(e -> {
            if (vocabularies.isEmpty()) {
                feedbackLabel.setText("No vocabulary available. Add some words!");
                displayWord.setText("");
            } else {
                // Pick a random word
                Object[] words = vocabularies.keySet().toArray();
                currentWord = (String) words[new Random().nextInt(words.length)];
                displayWord.setText(currentWord);
                userInput.setText("");
                feedbackLabel.setText("Translate the word above.");
            }
        });

        // Logic for "Check" Button
        checkButton.addActionListener(e -> {
            if (currentWord == null) {
                feedbackLabel.setText("Click 'Next' to start!");
            } else {
                String userAnswer = userInput.getText().trim();
                String correctAnswer = vocabularies.get(currentWord);
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    feedbackLabel.setText("Correct! Great job!");
                    correctCount++;
                } else {
                    feedbackLabel.setText("Incorrect. The correct answer is: " + correctAnswer);
                }
                totalCount++;
                statsLabel.setText("Score: " + correctCount + "/" + totalCount);
            }
        });

        //Do not repeat words Code here

        // Initial Setup
        nextButton.doClick(); // Automatically load the first word

        // Show the frame
        frame.setVisible(true);
    }
}
