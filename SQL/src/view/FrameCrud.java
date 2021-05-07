package view;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class FrameCrud {
    public static void addComponentsToPane(Container pane,ActionListener listener) {
        pane.setLayout(new GridLayout(4,1));
        addAButton("Create", pane,Events.CREATE.name(),listener);
        addAButton("Search", pane,Events.SEARCH.name(),listener);
        addAButton("Update", pane,Events.UPDATE.name(),listener);
        addAButton("Delete", pane,Events.DELETE.name(),listener);
    }
    
    public FrameCrud(ActionListener listener) {
    	createAndShowGUI(listener);
	}
    private static void addAButton(String text, Container container, String command,ActionListener listener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.addActionListener(listener);
        button.setActionCommand(command);
    }
    
    private static void createAndShowGUI(ActionListener listener) {
        JFrame frame = new JFrame("CRUD");
        JPanel jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        addComponentsToPane(jPanel,listener);
        frame.add(jPanel);
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
		new FrameCrud(null);
	}
 
}