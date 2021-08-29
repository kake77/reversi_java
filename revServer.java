import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class revServer {

    public static void main(String args[]){
        ServerSocket serverSocket=null;
        try{
            serverSocket=new ServerSocket(revConfig.PORT);
            System.out.println("Server is running\nPORT="+serverSocket.getLocalPort());
            while(true){
                Socket socket=serverSocket.accept();
                new revThread(socket).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(serverSocket !=null){
                    serverSocket.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
