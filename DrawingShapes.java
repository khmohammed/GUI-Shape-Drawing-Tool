import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JPanel;

public class DrawingShapes extends JPanel {

	//array + index to store and find the 5 shapes
    private static final int MAX_SHAPES = 5;
    private Shape[] shapes = new Shape[MAX_SHAPES];
    private int currentIndex = 0;

    
    //default size, shape, colour when project is run
    private Color currentColor = Color.RED;
    private int currentSize = 200; 
    private String currentShape = "Circle"; 

    DrawingShapes() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
            }
        });

        setPreferredSize(new Dimension(870, 450));
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setCurrentSize(int size) {
        this.currentSize = size;
    }

    public void setCurrentShape(String shape) {
        this.currentShape = shape;
    }

    private void drawShape(int centerX, int centerY) {
        addShape(new Shape(currentShape, currentColor, currentSize, centerX, centerY));
        repaint();
    }

   
    public void addShape(Shape shape) {
        shapes[currentIndex] = shape;
        currentIndex = (currentIndex + 1) % MAX_SHAPES;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        //for loop so that all 5 drawings are written in the correct order
        for (int i = 0; i < MAX_SHAPES; i++) {
            int index = (currentIndex + i) % MAX_SHAPES;
            Shape shape = shapes[index];

            if (shape != null) {
                g.setColor(shape.getColor());
                int shapeX = shape.getX() - shape.getSize() / 2;
                int shapeY = shape.getY() - shape.getSize() / 2;

                if (shape.getShape().equals("Circle")) {
                    g.fillOval(shapeX, shapeY, shape.getSize(), shape.getSize());
                } else if (shape.getShape().equals("Rectangle")) {
                    g.fillRect(shapeX, shapeY, shape.getSize() * 2, shape.getSize());
                }
            }
        }
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void loadShapesFromFile(String filePath) {
        BufferedReader reader = null;

        try {
            if (!Files.exists(Paths.get(filePath))) {
                NoSave noSave = new NoSave(this);
                noSave.showNoSaveFrame();
                return;  
            }

            reader = new BufferedReader(new FileReader(filePath));

         
            clearShapes();

            String line;
            while ((line = reader.readLine()) != null) {
                // I created a parser to split the properties of the shapes, shape, colour, size, x and y 
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String shapeType = parts[0].substring(parts[0].indexOf(": ") + 2);
                    String colorString = parts[1].substring(parts[1].indexOf(": ") + 2);
                    Color color = getColorFromString(colorString);

                    int size = Integer.parseInt(parts[2].substring(parts[2].indexOf(": ") + 2));
                    int x = Integer.parseInt(parts[3].substring(parts[3].indexOf(": ") + 2));
                    int y = Integer.parseInt(parts[4].substring(parts[4].indexOf(": ") + 2));

                    // Creates and adds the shape 
                    addShape(new Shape(shapeType, color, size, x, y));
                }
            }

         
            Load load = new Load(this);
            load.showLoadFrame();
        } catch (IOException ex) {
            NoSave noSave = new NoSave(this);
            noSave.showNoSaveFrame();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
    }

    
    //this extracts the RGB from the shapes to add when loading the drawingShapes.txt file onto the program.
    private Color getColorFromString(String colorString) {
        int startIndex = colorString.indexOf("r=") + 2; //+2 is used to accommodate for r=
        int endIndex = colorString.indexOf(",", startIndex);
        int red = Integer.parseInt(colorString.substring(startIndex, endIndex));

        startIndex = colorString.indexOf("g=") + 2;
        endIndex = colorString.indexOf(",", startIndex);
        int green = Integer.parseInt(colorString.substring(startIndex, endIndex));

        startIndex = colorString.indexOf("b=") + 2;
        endIndex = colorString.indexOf("]", startIndex);
        int blue = Integer.parseInt(colorString.substring(startIndex, endIndex));

        return new Color(red, green, blue);
    }
    
    private void clearShapes() {
    	shapes = new Shape[MAX_SHAPES];
        currentIndex = 0;
        repaint();
    }
    

   
}
