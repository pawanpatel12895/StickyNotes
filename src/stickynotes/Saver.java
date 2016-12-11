/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickynotes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pawan
 */
public class Saver 
{
    public File save(mainFrame frame)
    {   System.out.println("stickynotes.Saver.save(frame)");
        FrameInfo frameinfo = new FrameInfo();
        frameinfo.setParam(frame);
        return save(frameinfo);
    }
    public File save(FrameInfo frameinfo)
    {   System.out.println("stickynotes.Saver.save(frameinfo)");
        Long L = System.nanoTime();
        String parentpath = System.getProperty("user.dir");
        File basePath = new File(parentpath,"Base");
        File filename = new File(basePath,L.toString()+".sticky");
        save(filename,frameinfo);
        return filename;
    }
    public void save(File filename,mainFrame frame)
    {   System.out.println("stickynotes.Saver.save(file,frame)");
        FrameInfo frameinfo = new FrameInfo();
        frameinfo.setParam(frame);
        save(filename,frameinfo);
    }
    public void save(File filename, FrameInfo frameinfo) 
    {   System.out.println("stickynotes.Saver.save(File,frameInfo) final");
        try {
        filename.createNewFile();
        FileOutputStream fout = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(frameinfo);
        } catch (IOException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    FrameInfo retrieve(File file)
    {   try {
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        return (FrameInfo)ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;    
    }
    FrameInfo retrieve(File path,String FileName)
    {   System.out.println("stickynotes.Saver.retrieve()");
        File file = new File(path,FileName);
        return retrieve(file);
    }
}
