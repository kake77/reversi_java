package structures;

import java.io.Serializable;

public class history implements Serializable{
    private boolean earlier;
    private int[] coodinates;
    
    public history(boolean earlier,int[] coordinates){
        this.earlier=earlier;
        this.coodinates=coordinates;

    }
}
