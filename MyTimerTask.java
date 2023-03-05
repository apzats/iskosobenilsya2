package domain.app;
import java.util.TimerTask;
import javax.sound.sampled.*;
 
public class MyTimerTask extends TimerTask {
    public Clip clip;
    public void setClip(Clip clip) {
        this.clip = clip;
    }

    @Override
    public void run() {
        System.out.println("TimerTask начал свое выполнение в:" );
        completeTask();
        System.out.println("TimerTask закончил свое выполнение в:");
    }
 
    private void completeTask() {
        try {
            this.clip.setFramePosition(0); //устанавливаем указатель на старт
            this.clip.start(); //Поехали!!!
        
            //Если не запущено других потоков, то стоит подождать, пока клип не закончится
                //В GUI-приложениях следующие 3 строчки не понадобятся
            Thread.sleep(this.clip.getMicrosecondLength()/1000);
            this.clip.stop(); //Останавливаем  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
   
}