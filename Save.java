import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    private JFrame saveFrame;
    private DrawingShapes drawingShapes; 

    Save(Frame frame, DrawingShapes drawingShapes) {
        this.drawingShapes = drawingShapes; 

        saveFrame = new JFrame();
        saveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        saveFrame.setSize(400, 200);
        saveFrame.setTitle("Message");
        saveFrame.setResizable(false);

     
        saveFrame.setLayout(null);

        JLabel saved = new JLabel("Drawing successfully saved!");
        saved.setBounds(105, 40, 300, 30);
        saveFrame.add(saved);

        JButton ok = new JButton("OK");
        ok.setBounds(150, 80, 70, 30);
        saveFrame.add(ok);

   
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            saveFrame.dispose();
            }
        });

        saveFrame.setVisible(false);
    }

    public void showSaveFrame() {
        saveFrame.setVisible(true);
        savePropertiesToFile(); 
    }

    private void savePropertiesToFile() {
        Shape[] shapes = drawingShapes.getShapes();
        String filePath = "shapeDrawing.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Shape shape : shapes) {
                writer.write("Shape: " + shape.getShape() +
                        ", Color: " + shape.getColor() +
                        ", Size: " + shape.getSize() +
                        ", X: " + shape.getX() +
                        ", Y: " + shape.getY());
                writer.newLine();
            }

            System.out.println("Drawing properties saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}