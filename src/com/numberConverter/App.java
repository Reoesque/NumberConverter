package com.numberConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class App extends JFrame {
    private JPanel mainWindowPanel;

    // input head
    private JLabel inputLabel;
    private JButton convertInputButton;
    private JTextField inputField;

    // frame with all conversions
    private JPanel conversionPanel;

    // full number conversion
    private JButton fullNumberCopyButton;
    private JTextField fullNumberTextfield;
    private JLabel fullNumberLabel;

    // short number conversion
    private JTextField shortNumberTextfield;
    private JButton shortNumberCopyButton;
    private JLabel shortNumberLabel;

    // split number conversion
    private JLabel splitNumberLabel;
    private JTextField splitNumberTextfield;
    private JButton splitNumberCopyButton;

    // lower application part
    private JPanel outputFrame;
    private JButton exitAppButton;
    private JButton clearClipboardButton;
    private JButton openAboutButton;
    private JButton clearAll;

    // main method
    public static void main(String[] args) {
        App mainWindow = new App();
    }

    // constructor
    public App() {
        // main window infos
        setTitle("Matriculation Number Converter 0.1");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(500, 250);
        setResizable(true);
        setLocationRelativeTo(null);

        // import Elements out of mainWindowPanel from forms
        setContentPane(mainWindowPanel);

        // for number copy buttons necessary instances
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = toolkit.getSystemClipboard();

        // action listener when pressing input-convert button
        convertInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputFieldText = inputField.getText();
                String[] convertedNumbers = convertInput(inputFieldText);
                fullNumberTextfield.setText(convertedNumbers[0]);
                shortNumberTextfield.setText(convertedNumbers[1]);
                splitNumberTextfield.setText(convertedNumbers[2]);
            }
        });

        // action listener when pressing full-number-copy button
        fullNumberCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection toBeCopied = new StringSelection(fullNumberTextfield.getText());
                systemClipboard.setContents(toBeCopied, null);
            }
        });

        // action listener when pressing short-number-copy button
        shortNumberCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection toBeCopied = new StringSelection(shortNumberTextfield.getText());
                systemClipboard.setContents(toBeCopied, null);
            }
        });

        // action listener when pressing split-number-copy button
        // not sure why this might be helpful, since we never use that number format
        splitNumberCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection toBeCopied = new StringSelection(splitNumberTextfield.getText());
                systemClipboard.setContents(toBeCopied, null);
            }
        });

        // action listener when pressing exit button
        exitAppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // action listener when pressing empty clipboard button
        clearClipboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection toBeCopied = new StringSelection("");
                systemClipboard.setContents(toBeCopied, null);
            }
        });

        // action listener when pressing about button
        openAboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutWindow newWindow = new aboutWindow();
            }
        });

        // make input field listen to enter key
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String inputFieldText = inputField.getText();
                    String[] convertedNumbers = convertInput(inputFieldText);
                    fullNumberTextfield.setText(convertedNumbers[0]);
                    shortNumberTextfield.setText(convertedNumbers[1]);
                    splitNumberTextfield.setText(convertedNumbers[2]);
                }
            }
        });
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                fullNumberTextfield.setText("");
                shortNumberTextfield.setText("");
                splitNumberTextfield.setText("");
            }
        });
    }

    // internal methods
    private static String[] convertInput(String userInput) {
        // in case there are unnecessary whitespaces
        userInput = userInput.trim();

        // initialization of all converted numbers
        String convertedToFullNumber = "";
        String convertedToShortNumber = "";
        String convertedToSplitNumber = "";
        // initialization of array for conversions
        String[] outputNumbers = new String[3];

        // setting indicies for array
        outputNumbers[0] = convertedToFullNumber;
        outputNumbers[1] = convertedToShortNumber;
        outputNumbers[2] = convertedToSplitNumber;

        // in case input is in full form
        if (userInput.startsWith("108") && (userInput.length() == 12)) {
            outputNumbers[0] = userInput;
            outputNumbers[1] = userInput.substring(4);
            outputNumbers[2] = userInput.substring(0, 3) + " " + userInput.substring(3, 6) + " " + userInput.substring(6);
        }
        // in case input is in split form
        else if (userInput.startsWith("108") && (userInput.length() == 14)) {
            outputNumbers[0] = userInput.replaceAll("\\s", "");
            outputNumbers[1] = outputNumbers[0].substring(4);
            outputNumbers[2] = userInput;
        }
        // in case input was in short form after all
        else if (userInput.length() == 8) {
            outputNumbers[0] = "1080" + userInput;
            outputNumbers[1] = userInput;
            outputNumbers[2] = "108 0" + userInput.substring(0, 2) + " " + userInput.substring(2);
        } else {
            String errorMessage = "Invalid input. Try again.";
            for (int i = 0; i < 3; i++) {
                outputNumbers[i] = errorMessage;
            }
        }

        return outputNumbers;
    }

}
