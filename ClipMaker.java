package domain.app;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ClipMaker {
    private Clip clip;

    public ClipMaker(String fileName) {
        try {
            File soundFile = new File(fileName); //Звуковой файл
            
            //Получаем AudioInputStream
            //Вот тут могут полететь IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            
            //Получаем реализацию интерфейса Clip
            //Может выкинуть LineUnavailableException
            Clip clip = AudioSystem.getClip();
            
            //Загружаем наш звуковой поток в Clip
            //Может выкинуть IOException и LineUnavailableException
            clip.open(ais);
            this.clip = clip;
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
        } 
    }
    public Clip getClip() {
        return this.clip;
    }
    }

    
