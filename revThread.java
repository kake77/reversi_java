import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

import structures.transferData;

public class revThread extends Thread{
    public static final int MATCH=0;
    public static final int REGIST=1;
    public static final int RECORD=2;



    private Socket socket;

    public revThread(Socket socket){
        this.socket=socket;
        System.out.println("connected:"+socket.getRemoteSocketAddress());
    }

    public void run(){
        try{
            
            ObjectInputStream objectInputStream=new ObjectInputStream(this.socket.getInputStream());
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(this.socket.getOutputStream());
            int type=(int)objectInputStream.readObject();


            if(type==MATCH){
                //マッチキューに追加

            }else if(type==-1){
                //盤面データ

            }else if(type==REGIST){
                //ユーザー登録
                UUID playerID=database.addUserData();
                objectOutputStream.writeObject(playerID);

            }else if(type==RECORD){
                //戦績
                UUID playerID=(UUID)objectInputStream.readObject();
                userdata udata=database.searchUserdata(playerID);
                objectOutputStream.writeObject(udata);

            }
            objectInputStream.close();
            objectOutputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}
