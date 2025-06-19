import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class buttons {

    private JButton rButton;
    private JButton yButton;
    private JButton bButton;
    private JComboBox<String> sizeComboBox;
    private JRadioButton circle;
    private JRadioButton rectangle;
    private ButtonGroup shapeGroup;

    public buttons(DrawingShapes drawingShapes) {
    	
    	//RadioButtons
        shapeGroup = new ButtonGroup();
        circle = new JRadioButton("Circle");
        rectangle = new JRadioButton("Rectangle");
        circle.setSelected(true);

     
        shapeGroup.add(circle);
        shapeGroup.add(rectangle);

        circle.addActionListener(Listeners.createCircleRadioButtonListener(drawingShapes));
        rectangle.addActionListener(Listeners.createRectangleRadioButtonListener(drawingShapes));

        
        //colour buttons
        rButton = new JButton("RED");
        rButton.setBounds(300, 100, 100, 30);
        rButton.setBackground(Color.RED);
        rButton.addActionListener(Listeners.createRedButtonListener(drawingShapes));

        yButton = new JButton("YELLOW");
        yButton.setBounds(400, 100, 100, 30);
        yButton.setBackground(Color.YELLOW);
        yButton.addActionListener(Listeners.createYellowButtonListener(drawingShapes));

        bButton = new JButton("BLUE");
        bButton.setBounds(500, 100, 100, 30);
        bButton.setBackground(Color.BLUE);
        bButton.addActionListener(Listeners.createBlueButtonListener(drawingShapes));

        //size combobox
        sizeComboBox = new JComboBox<>(new String[]{"Big", "Medium", "Small"});
        sizeComboBox.addActionListener(Listeners.createSizeComboBoxListener(drawingShapes, sizeComboBox));
    }
    
    public JRadioButton getCircle() {
        return circle;
    }
    
    public JRadioButton getRectangle() {
        return rectangle;
    }

    public JButton getrButton() {
        return rButton;
    }

    public JButton getyButton() {
        return yButton;
    }

    public JButton getbButton() {
        return bButton;
    }

    public JComboBox<String> getSizeComboBox() {
        return sizeComboBox;
    }

}
