import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class Listeners {
	
	
	
	public static ActionListener createCircleRadioButtonListener(DrawingShapes drawingShapes) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingShapes.setCurrentShape("Circle");
            }
        };
    }
	
	public static ActionListener createRectangleRadioButtonListener(DrawingShapes drawingShapes) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingShapes.setCurrentShape("Rectangle");
            }
        };
    }
	
	
	
	
	public static ActionListener createRedButtonListener(DrawingShapes drawingShapes) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingShapes.setCurrentColor(Color.RED);
            }
        };
    }

    public static ActionListener createYellowButtonListener(DrawingShapes drawingShapes) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingShapes.setCurrentColor(Color.YELLOW);
            }
        };
    }
    
    public static ActionListener createBlueButtonListener(DrawingShapes drawingShapes) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingShapes.setCurrentColor(Color.BLUE);
            }
        };
    }

    public static ActionListener createSizeComboBoxListener(DrawingShapes drawingShapes, JComboBox<String> sizeComboBox) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSize = (String) sizeComboBox.getSelectedItem();
                int size = getSizeValue(selectedSize);
                drawingShapes.setCurrentSize(size);
            }

            private int getSizeValue(String size) {
                switch (size) {
                    case "Big":
                        return 200;
                    case "Medium":
                        return 100;
                    case "Small":
                        return 50;
                    default:
                        return 200; 
                }
            }
        };
    }

    
}
