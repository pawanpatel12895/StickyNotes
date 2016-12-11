/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickynotes;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author pawan
 */
public class FrameInfo implements Serializable 
{
    String textArea;
    Point Location;
    public void setParam(mainFrame frame)
    {   textArea = frame.getTextArea();
        Location = frame.getLocation();
    }
    public mainFrame getparam()
    {   mainFrame frame = new mainFrame();
        frame.setTextArea(textArea);
        frame.setLocation(Location);
        return frame;
    }
}
