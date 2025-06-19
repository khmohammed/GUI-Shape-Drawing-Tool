import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");

    JMenuItem saveMenuItem = new JMenuItem("Save");
    JMenuItem loadMenuItem = new JMenuItem("Load");

    Menu(Frame frame) {
        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);

        menuBar.add(fileMenu);

        
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showSaveFrame();
            }
        });
        
        loadMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLoadFrame();
            }
        });
    }


    public void addSaveActionListener(ActionListener listener) {
        saveMenuItem.addActionListener(listener);
    }
    
    public void addLoadActionListener(ActionListener listener) {
        loadMenuItem.addActionListener(listener);
    }
}