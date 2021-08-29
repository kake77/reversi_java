import java.io.Serializable;
import java.util.UUID;

public class userdata implements Serializable{
    UUID playerID;
    int win;
    int match;

    public userdata(){
        this.playerID=UUID.randomUUID();
        this.win=0;
        this.match=0;
    }
}
