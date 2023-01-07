import java.util.*;
class MetroCard{
    String m_id;
    int m_balance;
    int journey;
    MetroCard(String m_id,int m_balance){
        this.m_id=m_id;
        this.m_balance=m_balance;
        this.journey=0;
    }
}

class Checkin {
    String m_id;
    String p_type;
    String Station;

    Checkin(String m_id,String p_type,String Station){
        this.m_id=m_id;
        this.p_type=p_type;
        this.Station=Station;
    }
}
class Result{
    static int central_collection;
    static int c_adult;
    static int c_kid;
    static int c_Senior_Citizen;
    static int air_collection;
    static int a_adult;
    static int a_kid;
    static int a_Senior_Citizen;
}
public class Main
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<MetroCard> mc=new ArrayList();
        String id;
        int bal;
        int flag=1;
        while(flag!=0){
            System.out.print("Enter MC_id:");
            id=in.next();
            System.out.println("Enter initial balance:");
            bal=in.nextInt();
            mc.add(new MetroCard(id,bal));
            System.out.println("Do you want to continue? Press 1::else 0");
            flag=in.nextInt();
        }
        ArrayList<Checkin> li=new ArrayList();
        flag=1;
        String m_id;
        String p_type;
        String Station;
        while(flag!=0){
            System.out.print("Enter MC_id:");
            m_id=in.next();
            System.out.println("Enter PassengerType");
            p_type=in.next();
// System.out.println();
            System.out.println("Enter Station");
            Station=in.next();
// System.out.println(Station);
            li.add(new Checkin(m_id,p_type,Station));
            System.out.println("Do you want to continue? Press 1::else 0");
            flag=in.nextInt();
        }
        String sn="Senior_Citizen";
        String adult="Adult";
        String kid="Kid";

        for( int i =0;i<li.size();i++){
            // MetroCard mc1 = mc.get(i);
            Checkin c1 = li.get(i);
            for(int j=0;j<mc.size();j++)
            {
                MetroCard mc1 = mc.get(j);
                if(mc1.m_id.equalsIgnoreCase(c1.m_id))
                {  int per=0;
                    if(c1.p_type.equalsIgnoreCase(sn) && mc1.journey==0)
                    {
                        mc1.m_balance=mc1.m_balance-100;
                        if(mc1.m_balance<=0){
                            per=mc1.m_balance*2/100;
                            mc1.m_balance=0;
                        }
                        mc1.journey=1;
                        if(c1.Station.equalsIgnoreCase("Central"))
                        {
                            Result.central_collection=Result.central_collection+100-per;
                            Result.c_Senior_Citizen+=1;
                        }
                        else
                        { Result.air_collection=Result.air_collection+100-per;
                            Result.a_Senior_Citizen+=1;
                        }
                    }
                    else if(c1.p_type.equalsIgnoreCase(sn) && mc1.journey==1)
                    {
                        mc1.m_balance=mc1.m_balance-50;
                        if(mc1.m_balance<=0){
                            per=mc1.m_balance*2/100;
                            mc1.m_balance=0;
                        }
                        mc1.journey=0;

                        if(c1.Station.equalsIgnoreCase("Central"))
                        { Result.central_collection=Result.central_collection+50-per;
                            Result.c_Senior_Citizen+=1;
                        }
                        else
                        {Result.air_collection=Result.air_collection+50-per;
                            Result.a_Senior_Citizen+=1;
                        }
                    }
                    else if(c1.p_type.equalsIgnoreCase(adult) && mc1.journey==0)
                    {
                        mc1.m_balance=mc1.m_balance-200;
                        if(mc1.m_balance<=0){
                            per=mc1.m_balance*2/100;
                            mc1.m_balance=0;
                        }
                        mc1.journey=1;

                        if(c1.Station.equalsIgnoreCase("Central"))
                        {
                            Result.central_collection=Result.central_collection+200-per;
                            Result.c_adult+=1;
                        }
                        else
                        {Result.air_collection=Result.air_collection+200-per;
                            Result.a_adult+=1;
                        }

                    }
                    else if(c1.p_type.equalsIgnoreCase(adult) && mc1.journey==1)
                    {
                        mc1.m_balance=mc1.m_balance-100;
                        if(mc1.m_balance<=0){
                            per=mc1.m_balance*2/100;
                            mc1.m_balance=0;
                        }
                        mc1.journey=0;
                        if(c1.Station.equalsIgnoreCase("Central"))
                        { Result.central_collection=Result.central_collection+100-per;
                            Result.c_adult+=1;
                        }
                        else
                        {Result.air_collection=Result.air_collection+100-per;
                            Result.a_adult+=1;
                        }

                    }
                    else if(c1.p_type.equalsIgnoreCase(kid) && mc1.journey==0)
                    {
                        mc1.m_balance=mc1.m_balance-50;
                        if(mc1.m_balance<=0){
                            per=mc1.m_balance*2/100;
                            mc1.m_balance=0;
                        }
                        mc1.journey=1;

                        if(c1.Station.equalsIgnoreCase("Central"))
                        { Result.central_collection=Result.central_collection+50-per;
                            Result.c_kid+=1;
                        }
                        else
                        {Result.air_collection=Result.air_collection+50-per;
                            Result.a_kid+=1;
                        }

                    }
                    else if(c1.p_type.equalsIgnoreCase(kid) && mc1.journey==1)
                    {
                        mc1.m_balance=mc1.m_balance-25;
                        if(mc1.m_balance<=0){
                            per=mc1.m_balance*2/100;
                            mc1.m_balance=0;
                        }
                        mc1.journey=0;

                        if(c1.Station.equalsIgnoreCase("Central"))
                        {Result.central_collection=Result.central_collection+25-per;
                            Result.c_kid+=1;
                        }
                        else
                        {Result.air_collection=Result.air_collection+25-per;
                            Result.a_kid+=1;
                        }
                    }

                }
                // displayResult();
            }
        }
        //display(mc);
        //displayElements(li);
        displayResult();
    }

    public static void display(ArrayList<MetroCard> mc)
    {   System.out.println("-----------------------------");
        for (int i = 0; i < mc.size(); i++)
        {
            MetroCard mc1 = mc.get(i);
            System.out.print(   mc1.m_id+"    "+mc1.m_balance);
        }
    }
    public static void displayElements(ArrayList<Checkin> li)
    {
        System.out.println("-----------------------------");
        for (int i = 0; i <li.size(); i++)
        {
            Checkin c1 = li.get(i);
            System.out.println(   c1.m_id+"    "+c1.p_type+"   "+c1.Station);
        }

    }
    public static void displayResult(/*ArrayList<Result> rs*/)
    {
         /* for (int i = 0; i < mc.size(); i++)
          {
             Result res1 ;*/
        System.out.println(  "Central Collection: " +Result.central_collection+
                "\n    c_Senior_Citizen:"+Result.c_Senior_Citizen+
                "    c_adult:"+Result.c_adult+
                "    c_kid:"+Result.c_kid+
                "\nAirPort Collection: " +Result.air_collection+
                "\n    c_Senior_Citizen:"+Result.a_Senior_Citizen+
                "    c_adult:"+Result.a_adult+
                "    c_kid:"+Result.a_kid);
        // }
    }
}


