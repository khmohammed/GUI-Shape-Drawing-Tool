import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Frame extends JFrame {

	 private DrawingShapes drawingShapes;
	    private Save saveMenu;
	    private Load loadMenu;
	    private buttons Buttons;
	    
	    Frame() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(900, 700);
	        setTitle("Shape Drawing Tool");
	        setResizable(false);

	       
	        drawingShapes = new DrawingShapes();
	        Buttons = new buttons(drawingShapes);
	        saveMenu = new Save(this, drawingShapes);
	        loadMenu = new Load(this);

	        Menu menu = new Menu(this);
	        setJMenuBar(menu.menuBar);
     
        
        // Selection Area
        String title1 = "Selection Area";
        Border line1 = BorderFactory.createTitledBorder(title1);

        JPanel selection = new JPanel();
        selection.setBorder(line1);
        selection.setPreferredSize(new java.awt.Dimension(870, 200));
        selection.setLayout(new BoxLayout(selection, BoxLayout.Y_AXIS));

        // Row 1/3: Shapes RadioButtons
        JPanel row1 = new JPanel();
        row1.setLayout(new FlowLayout());
        JLabel select1 = new JLabel("Shape");
        row1.add(select1);
        row1.add(Buttons.getCircle()); 
        row1.add(Buttons.getRectangle()); 
        selection.add(row1);

     // Row 2/3: Color Buttons
        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout());
        JLabel select2 = new JLabel("Colour");
        JButton rButton = Buttons.getrButton();
        JButton yButton = Buttons.getyButton();
        JButton bButton = Buttons.getbButton();
        row2.add(select2);
        row2.add(rButton);
        rButton.setBounds(200, 100, 100, 30);
        row2.add(yButton);
        yButton.setBounds(410, 100, 100, 30);
        row2.add(bButton);
        bButton.setBounds(520, 100, 100, 30);
        selection.add(row2);

        
     // Row 3/3: Size ComboBox
        JPanel row3 = new JPanel();
        row3.setLayout(new FlowLayout());
        JLabel select3 = new JLabel("Size");
        JComboBox<String> sizeComboBox = Buttons.getSizeComboBox();
        row3.add(select3);
        row3.add(sizeComboBox);
        selection.add(row3);

        // Draw Area
        String title2 = "Draw Area";
        Border line2 = BorderFactory.createTitledBorder(title2);

        JPanel draw = new JPanel();
        draw.setBorder(line2);
        draw.setPreferredSize(new java.awt.Dimension(870, 450));
        draw.setLayout(new BorderLayout());
        draw.add(drawingShapes, BorderLayout.CENTER);

        
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10)); //allows Selection area on top of draw area

    
        getContentPane().add(selection);
        getContentPane().add(draw);

        setVisible(true);
    }

   
    public void showSaveFrame() {
        saveMenu.showSaveFrame();
    }
    
 
    public void showLoadFrame() {
        String filePath = "shapeDrawing.txt"; 

        // Check if the .txt file exists
        if (Files.exists(Paths.get(filePath))) {
			drawingShapes.loadShapesFromFile(filePath);
			Load load = new Load(this);
			load.showLoadFrame();
        } else {
            NoSave noSave = new NoSave(drawingShapes);
            noSave.showNoSaveFrame();
        }    }
}

    
    

