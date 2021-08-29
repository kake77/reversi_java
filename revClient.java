import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

import javax.swing.JFrame;

import structures.transferData;

class revClient{
  static revFrame frame;
    public static void main(String args[]){
      frame=new revFrame();
      frame.setVisible(true);
    }
  }