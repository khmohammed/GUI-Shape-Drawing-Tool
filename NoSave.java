import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoSave {

	 private JFrame noSaveFrame;
	 private DrawingShapes drawingShapes;

	 NoSave(DrawingShapes drawingShapes) {
	        this.drawingShapes = drawingShapes;
    	noSaveFrame = new JFrame();
    	noSaveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	noSaveFrame.setSize(400, 200);
    	noSaveFrame.setTitle("Message");
    	noSaveFrame.setResizable(false);

    
    	noSaveFrame.setLayout(null);

        JLabel noSaveMessage = new JLabel("No Saved Drawing!");
        noSaveMessage.setBounds(130, 40, 300, 30);
        noSaveFrame.add(noSaveMessage);

        JButton ok = new JButton("OK");
        ok.setBounds(150, 80, 70, 30);
        noSaveFrame.add(ok);
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noSaveFrame.dispose();
            }
        });

    }

    public void showNoSaveFrame() {
    	noSaveFrame.setVisible(true);
    }
}