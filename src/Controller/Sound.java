package Controller;

import  java.io.*;
import javax.sound.sampled.*;

public class Sound extends Thread 
{
    AudioInputStream audioInputStream = null;
    SourceDataLine line;
    public String fileDirectory;

    public Sound(String fileDirectory)
    {
    	this.fileDirectory = fileDirectory;
    }
    public void run()
    {
        File file = new File(fileDirectory);
        try 
        {
            @SuppressWarnings("unused")
            AudioFileFormat format = AudioSystem.getAudioFileFormat(file);
        } 
        catch (UnsupportedAudioFileException e1) 
        {
            e1.printStackTrace();
        } 
        catch (IOException e1) 
        {
            e1.printStackTrace();
        }
        try 
        {
            audioInputStream = AudioSystem.getAudioInputStream(file);
        } 
        catch (UnsupportedAudioFileException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         AudioFormat audioFormat = audioInputStream.getFormat();
         DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
         try 
         {
             line = (SourceDataLine) AudioSystem.getLine(info);              
         } 
         catch (LineUnavailableException e) 
         {
           e.printStackTrace();
           return;
         }
          
        try 
        {
            line.open(audioFormat);
        } 
        catch (LineUnavailableException e) 
        {
            e.printStackTrace();
            return;
        }
        line.start();
        try 
        {
            byte bytes[] = new byte[1024];
            int bytesRead=0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) 
            {
            	line.write(bytes, 0, bytesRead);
            }
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
            return;
        }
    }
}