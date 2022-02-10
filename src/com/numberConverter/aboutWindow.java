package com.numberConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class aboutWindow extends JFrame {
    // main panel element (contains everything else)
    private JPanel mainPanel;

    private JLabel aboutText;
    private JLabel madeByInfo;

    // links
    private JPanel linkPanel;
    private JButton githubRepo;
    private JButton githubMaintainer;
    private JLabel linkFeedbackLabel;

    // main method
    public static void main(String[] args) {
        aboutWindow aboutWindow = new aboutWindow();
    }

    // constructor
    public aboutWindow() {
        // main window infos
        setTitle("About");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setSize(600, 250);
        setResizable(true);
        setLocationRelativeTo(null);

        // import Elements out of mainWindowPanel from forms
        setContentPane(mainPanel);

        // for copying links to clipboard
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = toolkit.getSystemClipboard();
        linkFeedbackLabel.setVisible(false);

        githubRepo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // super.mouseClicked(e);
                StringSelection githubRepoLink = new StringSelection("https://www.github.com/Reoesque/NumberConverter");
                systemClipboard.setContents(githubRepoLink, null);
                linkFeedbackLabel.setVisible(true);
            }
        });
        githubRepo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // super.mouseExited(e);
                linkFeedbackLabel.setVisible(false);
            }
        });

        githubMaintainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // super.mouseClicked(e);
                StringSelection githubRepoMaintainerLink = new StringSelection("https://www.github.com/Reoesque/");
                systemClipboard.setContents(githubRepoMaintainerLink, null);
                linkFeedbackLabel.setVisible(true);
            }
        });
        githubMaintainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // super.mouseExited(e);
                linkFeedbackLabel.setVisible(false);
            }
        });
    }
}
