package domain.app;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import javax.sound.sampled.*;
import java.awt.FlowLayout;

class App implements ActionListener {
    JButton button1;
    JButton button2;
    JLabel label;
    JPanel panel;
    long counter;
    int width = 400;
    int height = 400;
    JTextField textField;
    JFrame frame;
    Timer timer;
    MyTimerTask timerTask;

    public void actionPerformed(ActionEvent e) {
        // JOptionPane.showMessageDialog(frame,"Любое событие:" + counter);
        if(e.getSource() == textField) {
            counter = Long.parseLong(textField.getText(), 10);
            // JOptionPane.showMessageDialog(frame,"Ваш период:" + timerTask);
            timer.scheduleAtFixedRate(timerTask, counter*1000, counter*1000);
       }
    }


    public static void main(String args[]) {
     
        new App();
    }
    

    public App() {
        String fileName = "domain/app/MySong5.wav";

        ClipMaker cm = new ClipMaker(fileName);
        Clip clip = cm.getClip();
        
              timerTask = new MyTimerTask();
              timerTask.setClip(clip);
          // стартуем TimerTask в виде демона
          
              timer = new Timer(true);
          // будем запускать каждых 10 секунд (10 * 1000 миллисекунд)
          
          // clip.close(); //Закрываем
        counter = 0;
        JFrame frame = new JFrame("Искособенился");
        
        

        button1 = new JButton("Запустить таймер");
        button1.addActionListener(this);
        // button1.setBounds(100,height-75,85,20);

        label = new JLabel("Введите временной интервал в сек.");
        // label.setBounds(0,0,width,20);
    
        
        textField = new JTextField(3);
        // label.setBounds(0,0,width,20);
        textField.setToolTipText("Введите интервал.");
        // textField.setBounds(width-100, height-100, width-50, height-140);
        textField.addActionListener(this);
        frame.add(textField);


        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(label);
        contents.add(textField);
        contents.add(button1);
        frame.setContentPane(contents);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        // frame.setLayout(null);
        frame.setVisible(true);
    }
}
