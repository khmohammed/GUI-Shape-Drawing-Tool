import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Load {

    private JFrame loadFrame;

    // This constructor is different because Load is used in Frame.java and DrawingShapes.java, so it needs to be able to accept the relevant files 

    Load(Object context) {
        loadFrame = new JFrame();
        loadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadFrame.setSize(400, 200);
        loadFrame.setTitle("Message");
        loadFrame.setResizable(false);

    
        loadFrame.setLayout(null);

        JLabel loaded = new JLabel("Drawing successfully loaded!");
        loaded.setBounds(105, 40, 300, 30);
        loadFrame.add(loaded);

        JButton ok = new JButton("OK");
        ok.setBounds(150, 80, 70, 30);
        loadFrame.add(ok);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFrame.dispose();
            }
        });
    }

    public void showLoadFrame() {
        loadFrame.setVisible(true);
    }
}
