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

        //translations using a Hashmap here (should be there in a moment)

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
