

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

/**
 * Created by flofly on 22/12/2017.
 */
public class transferfileClient
{
    Socket ClientSoc;
    boolean waitingRes=false;
    DataInputStream din;
    DataOutputStream dout;

    BufferedReader br;
    
    transferfileClient(Socket soc)
    {
        try
        {
            ClientSoc=soc;
            din=new DataInputStream(ClientSoc.getInputStream());
            dout=new DataOutputStream(ClientSoc.getOutputStream());
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception ex)
        {
        }
    }

     

    public void displayMenu() throws Exception
    {
        Sensor s1= new Sensor(1,180,600,"plaque",0,0);
        Sensor s2= new Sensor(2,160,300,"plaque2",0,0);
        Sensor s3= new Sensor(3,170,600,"plaque3",0,0);

        Long d1 = System.currentTimeMillis();
        Long d2 = System.currentTimeMillis();

        while(true)
        {
            if(System.currentTimeMillis()-d1==600){
                dout.writeUTF(s1.getId()+":R"+s1.getRange()+"_P"+s1.getEtat()+s1.getOpt());
                d1 = System.currentTimeMillis();

            }
            if(System.currentTimeMillis()-d2==300){
                if(s2.getEtat()==0){
                    dout.writeUTF("2:DETECTE");
                }else{
                    dout.writeUTF("2:NA");
                }


                d2 = System.currentTimeMillis();

            }
            if(s3.getEtat()==0){
                if(s3.getEtat()!=s3.getOldEtat()){
                    dout.writeUTF("3:DETECTE");
                    s3.setOldEtat(s3.getEtat());
                }
            }else{
                if(s3.getEtat()!=s3.getOldEtat()) {
                    dout.writeUTF("3:NA");
                    s3.setOldEtat(s3.getEtat());
                }
            }
            Random rand = new Random();
            int randInt = rand.nextInt( 2);
            s3.setEtat(randInt);
            System.out.print(randInt);
        }
    }
      
}
