import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class webbrowser extends JFrame {

    private JTextField addressbar;
    private JEditorPane display;

    //constructor
    public webbrowser(){
        super("matt's browser");

        addressbar = new JTextField("enter a URl boss!");
        addressbar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        loadstuff(event.getActionCommand());
                    }
                }
        );
        add(addressbar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent event) {
                        if(event.getEventType()== HyperlinkEvent.EventType.ACTIVATED){
                            loadstuff(event.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }

    //load stuff to display on screen
    private void loadstuff(String userText){
        try{
            display.setPage(userText);
            addressbar.setText(userText);
        }catch(Exception e){
            System.out.println("error");
        }
    }

}