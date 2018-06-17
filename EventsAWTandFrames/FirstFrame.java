import java.awt. *;
import java.awt.event. *;
import java.applet. *;
/*
<Applet code="FirstFrame.java" width=500 height=500></applet>
*/
// Flow - init() -> start() -> paint -> stop() -> destroy()
/*
Essentially we are editing the predefined methods 
or in other words overriding them to acheive what we want 
eg: init(), windowClosing() .. etc
*/

/* Creating a subclass of Frame and using super() to access the 
constructor -> Frame(String title) of the super class Frame 
Hence that becomes the Title of the window when the class object is 
initialised.
*/
class SampleFrame extends Frame {
    SampleFrame(String title) {
        super(title);
        // This event handling is done so that when we close the frame
        // Window, an event is raised (OnWindowClose) that can be handled 
        // by the listener -> addWindowListener when we register it.
        // Note we dont have to do this for applets (They are also essentially frames)
        // But the applet class abstract methods like paint() already have the code 
        // to handle events like these by default, no need to explicitly do so.
        MyWindowAdapter adapter = new MyWindowAdapter(this); // Passing the sample frame 
                                                             // object (this) to MyWindowAdapter Class via its constructor 
                                                             // to register the frame object to the 
                                                             // Event handler.
        // register it to receive those events with the adapter object 
        // which was defined by calling the MyWindowAdapter constructor 
        // that initiated the window event 
        addWindowListener(adapter);
    }
    public void paint(Graphics g) {
        g.drawString("This is in frame window", 10, 40);
        // initate the frame via a seperate paint call ( thsi is called nesting in applets)
    }
}

// This is the event handler class i.e this describes the processing 
// part of the event once it is raised by a source.
// Here, the source is the SimpleFrame class.( This is a good example of the "Delegation event model")
class MyWindowAdapter extends WindowAdapter {
    SampleFrame sampleFrame;
    public MyWindowAdapter(SampleFrame sampleFrame) {
        this.sampleFrame = sampleFrame;
    }
    // as soon as the listener is triggered it calls the function 
    // windowClosing. We overrided the windowClosing method 
    // to do the setVisible(False) i.e. close the frame !
    public void windowClosing(WindowEvent we) {
        sampleFrame.setVisible(false);
    }
}
// Create frame window, this where it all comes down ! i.e when an appletViewer 
// is called it looks for the init() function and starts from there. 
// Therefore, the absence of main() doesnt really matter.
// Since we extended applet class, this form a applet windiow that is distinguished 
// from the fame window
public class FirstFrame extends Applet {
    Frame f;
    // Using this object we can access the all the features required to 
    // start a frame window !                                                                                                   
    public void init() {
        f = new SampleFrame("A Frame Window");
        // When the f object is initialised with SampleFrame constructor 
        // The constructor constrcuts the class, hence it cascades through the
        // Class heirarchy i.e from Frame class - event handler class, basically 
        // All the required setup process for the frame is done !
        f.setSize(250, 250);
        f.setVisible(true);
        // These functions are defined in the "component" class ( in the class heirarchy )
    }
    public void start() {
        f.setVisible(true);
    }
    public void stop() {
        f.setVisible(false);
        // This is different from the setVisible(false) of the event handler 
        // This is called when the applet is closed ( i.e. when it goes from)
        // running to end ( in the lifecycle )
    }
    public void paint(Graphics g) {
        g.drawString("This is in applet window", 10, 20);
    }
}