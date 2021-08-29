import java.util.ArrayList;
import java.util.UUID;

public class database {
    static ArrayList<userdata> userdatas=new ArrayList<>();


    public static UUID addUserData(){
        userdata udata=new userdata();
        userdatas.add(udata);
        System.out.println("ユーザーが登録されました:"+udata.playerID);
        return udata.playerID;
    }

    public static userdata searchUserdata(UUID searchingID){
        for(int i=0;i<userdatas.size();i++){
            if(userdatas.get(i).playerID.equals(searchingID)){
                return userdatas.get(i);
            }
        }
        return null;
    }
}
