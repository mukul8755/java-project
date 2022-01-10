package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
    JScrollPane pane;

    Notepad() {
        setTitle("Notepad");
        setBounds(0, 0, 1368, 768);
        JMenuBar j1 = new JMenuBar();
        JMenu file = new JMenu("File");

        JMenuItem New = new JMenuItem("New");
        New.addActionListener(this);
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));


        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));


        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        file.add(New);
        file.add(open);
        file.add(save);
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem selectall = new JMenuItem("Select All");
        selectall.addActionListener(this);
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About the developer");
        about.addActionListener(this);
        help.add(about);

        j1.add(file);
        j1.add(edit);
        j1.add(help);
        setJMenuBar(j1);

        area = new JTextArea();
        area.setFont(new Font("", Font.BOLD, 20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        pane = new JScrollPane(area);
        add(pane, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            area.setText("");
        }
        else if(e.getActionCommand().equals("Open")) {
            JFileChooser c1 = new JFileChooser();
            c1.showOpenDialog(this);
            File file = c1.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader,null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("Save")) {
            JFileChooser s1 = new JFileChooser();
            s1.showOpenDialog(this);
            File f = new File(s1.getSelectedFile()+".txt");
            BufferedWriter outfile = null;
            try {
                outfile = new BufferedWriter(new FileWriter(f));
                area.write(outfile);
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("Cut")) {
            area.cut();
        }
        else if(e.getActionCommand().equals("Copy")) {
            area.copy();
        }
        else if(e.getActionCommand().equals("Paste")) {
            area.paste();
        }
        else if(e.getActionCommand().equals("Select All")) {
            area.selectAll();
        }
        else if(e.getActionCommand().equals("About the developer")) {
            new about();
        }

    }


    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }
}
