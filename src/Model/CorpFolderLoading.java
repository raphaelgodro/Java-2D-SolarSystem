
package Model;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class CorpFolderLoading 
{
    String path;
    public String bgImage = "";
    public String profileImage = "";
    public String description = "";
    public ArrayList<BufferedImage> img = new ArrayList<BufferedImage>();
    
    public CorpFolderLoading(String s)
    {
        this.path = s.toLowerCase();
        if(path != "")
        {
            try
            {
                final File folder = new File("lib/localsolarsystem/" + path);
                openFolder(folder);               
            }
            catch(Exception e)
            {}
        }
    }

    public void openFolder(final File folder) 
    {
        for (final File fileEntry : folder.listFiles()) 
        {
            if (fileEntry.isDirectory()) 
            {
                openFolder(fileEntry);
            } 
            else 
            {
                checkBackgroundImg(fileEntry);
                checkProfileImg(fileEntry);
                checkDescription(fileEntry);
                addImageToList(fileEntry);
            }
        }
    }
    void checkBackgroundImg(File file)
    {
        if(file.getName().equals("bg.png"))
        {
            bgImage = "lib/localsolarsystem/" + path + "/" + file.getName();
        }
    }
    void checkProfileImg(File file)
    {
        if((file.getName().equals("profile.png"))||(file.getName().equals("profile.jpg")))
        {
            profileImage = "lib/localsolarsystem/" + path + "/" + file.getName();
        }
    }
    void checkDescription(File file)
    {
        if(file.getName().equals("description.txt"))
        {
            try
            {
                BufferedReader in = new BufferedReader(new FileReader("lib/localsolarsystem/" + path + "/" + file.getName()));
                String line;
                while((line = in.readLine()) != null)
                {
                    description += line;
                }
                in.close();
            }
            catch(Exception e)
            {}
        }
    }
    void addImageToList(File file)
    {
        boolean castOk = true;
        BufferedImage imgToAdd = null;
        try
        {
            imgToAdd = ImageIO.read(file);
        }
        catch(Exception e)
        {
            castOk = false;
        }
        if((castOk)&&(imgToAdd != null))
            this.img.add(imgToAdd);
    }
    
}
