package structures;

import java.io.Serializable;
import java.util.UUID;

public class transferData implements Serializable{
    private UUID uuid;
    private UUID[] playerIds;
    private int[][] board;
    private history[] histories;

    public transferData(UUID[] playerIds){
        this.uuid=UUID.randomUUID();
        this.playerIds=playerIds;
        this.board=new int[8][8];
        this.histories=new structures.history[60];
        
        this.board[3][3]=1;
        this.board[3][4]=2;
        this.board[4][3]=2;
        this.board[4][4]=1;
    }

    public String toString(){
        String result="";
        result=result+"UUID:"+this.uuid+"\n";
        result=result+"playerIds[0]:"+this.playerIds[0]+"\n";
        result=result+"playerIds[1]:"+this.playerIds[1]+"\n";
        result=result+"board\n";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                result=result+this.board[i][j];
            }
            result=result+"\n";
        }
        result=result+"\n";


        return(result);
    }
}
