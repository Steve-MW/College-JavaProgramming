import java.awt.*;
import java.applet.*;

/* 
<Applet code="SimpleApplet" width=500 height=500></applet>
*/

public class SimpleApplet extends Applet
{
    public void paint(Graphics g)
    {
        g.drawString("A simple Applet",20,20);
    }
}
