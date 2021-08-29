import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputFilter.Config;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class revFrame extends JFrame{

    JLabel usernameJLabel;
    imagePanel p;

    public revFrame(){

        setTitle("reversi");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        p=new imagePanel(revConfig.BGImagePath);
        p.setLayout(null);

        getContentPane().add(p,BorderLayout.CENTER);

        clientData cdata=getClientData();
        if(cdata==null){
            drawIni();
        }

    }

    public void drawMain(){
        p.removeAll();

        usernameJLabel=new JLabel("ユーザーID");
        usernameJLabel.setBounds(0,0,100,40);
        usernameJLabel.setForeground(Color.white);
        p.add(usernameJLabel);

        JButton button=new JButton("マッチ");
        button.setBounds(900, 290, 800, 100);
        button.addActionListener(new guiActionListener(guiActionListener.REGIST_INI));
        p.add(button);

        JButton button2=new JButton("戦績");
        button2.setBounds(900, 490, 800, 100);
        button2.addActionListener(new guiActionListener(guiActionListener.LOGIN_INI));
        p.add(button2);

        JButton button3=new JButton("ユーザー情報");
        button3.setBounds(900, 690, 800, 100);
        button3.addActionListener(new guiActionListener(guiActionListener.LOGIN_INI));
        p.add(button3);

        p.repaint();
    }

    public void drawIni(){
        p.removeAll();

        usernameJLabel=new JLabel("ユーザー情報なし");
        usernameJLabel.setBounds(0,0,100,40);
        usernameJLabel.setForeground(Color.white);
        p.add(usernameJLabel);

        JButton button=new JButton("ユーザー登録");
        button.setBounds(900, 390, 800, 100);
        button.addActionListener(new guiActionListener(guiActionListener.REGIST_INI));
        p.add(button);

        JButton button2=new JButton("ログイン");
        button2.setBounds(900, 590, 800, 100);
        button2.addActionListener(new guiActionListener(guiActionListener.LOGIN_INI));
        p.add(button2);

        p.repaint();
    }

    public void drawRegist(){
        p.removeAll();

        JTextField userNameJTextField=new JTextField();
        userNameJTextField.setBounds(900, 390, 800, 100);
        p.add(userNameJTextField);

        JButton registJButton=new JButton("登録");
        registJButton.setBounds(900, 590, 800, 100);
        registJButton.addActionListener(new guiActionListener(guiActionListener.REGIST_SUBMIT));
        p.add(registJButton);

        p.repaint();
    }
    public clientData getClientData(){
        clientData result=null;
        try{
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(revConfig.clientDataPath));
            result=(clientData)objectInputStream.readObject();
            objectInputStream.close();
        }catch(IOException e){
            //e.printStackTrace();
            System.out.println("no data");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }
}
