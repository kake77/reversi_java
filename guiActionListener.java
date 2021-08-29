import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;
import java.awt.event.ActionEvent;

public class guiActionListener implements ActionListener {
    public static final int REGIST_INI=0;
    public static final int LOGIN_INI=1;
    public static final int REGIST_SUBMIT=2;


    private int buttonID;

    public guiActionListener(int buttonID){
        this.buttonID=buttonID;
    }

    public void actionPerformed(ActionEvent event){
        if(this.buttonID==REGIST_INI){
            revClient.frame.drawRegist();
        }
        else if(this.buttonID==LOGIN_INI){

        }
        else if(this.buttonID==REGIST_SUBMIT){
            try{
                Socket socket=new Socket(revConfig.IP,revConfig.PORT);
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                objectOutputStream.writeObject(revThread.REGIST);
                
                clientData.playerID=(UUID)objectInputStream.readObject();
                clientData.userName="kake";

                System.out.println("登録完了:"+clientData.playerID);
                socket.close();

                //データ保存処理


                revClient.frame.drawMain();

            }catch(IOException e){
                e.printStackTrace();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
