/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickynotes;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author pawan
 */
public class StickyNotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   System.out.println("stickynotes.StickyNotes.main()");
        // TODO code application logic here
        File baseFolder = new File(System.getProperty("user.dir"),"Base");
        if(!baseFolder.exists())
            baseFolder.mkdirs();
        
        FilenameFilter ext = new extensionCheck();
        
        String L[] = baseFolder.list(ext);
        if(L.length == 0)
            newSticky();
        else 
            LoadExistingSticky(baseFolder,L);
    }

    private static void newSticky() 
    {   System.out.println("stickynotes.StickyNotes.newSticky()");
        mainFrame frame = new mainFrame();
    }

    private static void LoadExistingSticky(File baseFolder, String[] L) 
    {   System.out.println("stickynotes.StickyNotes.LoadExistingSticky()");
        FrameInfo frameinfo;
        Saver retrievingPoint = new Saver();
        File newfile;
        mainFrame frame;
            
        for(String S1:L)
        {   System.out.println("Load "+S1);
            newfile = new File(baseFolder,S1);
            frameinfo = retrievingPoint.retrieve(baseFolder, S1);
            frame = frameinfo.getparam();
            frame.setFilename(newfile);
        }
    }
}
class extensionCheck implements FilenameFilter
{    @Override
    public boolean accept(File dir, String name) 
    {   return (new File(dir,name).isFile())&&name.endsWith(".sticky");
    }
}