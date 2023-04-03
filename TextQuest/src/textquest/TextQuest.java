package textquest;

import java.util.ArrayList;
import java.util.Scanner;

public class TextQuest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Record ThisRecord=new Record();
        //System.setProperty("console.encoding","Cp866");//для ввода русских символов
        Scanner in = new Scanner(System.in);
        //in.nextLine()//получение данных типа стринг введенных пользователем с клавиатуры
        //int num = in.nextInt();//получение данных типа инт введенных пользователем с клавиатуры
        boolean keyGameRun = true; //ключИграБежит = правда;

        
        ArrayList<Location> magicLocations = new ArrayList<>();
        ArrayList<Thing> magicThings = new ArrayList<>();
        
        Location garden = new Location(0,0,"garden");
        Location livingRoom = new Location(1,0,"livingRoom");
        Location attic = new Location(1,1,"attic");
        Location basement = new Location(1,-1, "basement");
        Location garden_shed = new Location(0, -1, "garden shed");
        Location laboratory = new Location(0,1, "laboratory");
        Location bigDub = new Location(-1,0,"Glade under an ancient oak");
        Location pond = new Location(-2,0,"Little pond");


        Character man = new Character(0,0,"man");


        Thing bucket = new Thing(0,0,"bucket",true,true);
        Thing chain = new Thing(0,0,"chain",true,false);
        Thing well = new Thing(0,0,"well",false,false);
        Thing burner = new Thing(1,1,"burner",false,false);
        Thing mag = new Thing(1,0,"mag",false,false);
        Thing alcohol = new Thing(0,0,"alcohol",true,true);
        Thing frog = new Thing(0,0,"frog",false,false);

        
        
        bucket.applicableThings.add("chain");
        bucket.applicableThings.add("burner");
        bucket.applicableThings.add("well");
        bucket.applicableThings.add("mag");
        
        
        ////bucket.applicableThings.add("chain");
        ////bucket.applicableThings.add("burner");
        
        ////well.applicableThings.add("bucket_chain_burner");
        //well.applicableThings.add("chain");
        //well.applicableThings.add("burner");
        
        //mag.applicableThings.add("well");
        ////mag.applicableThings.add("well_bucket_chain_burner");
        //mag.applicableThings.add("chain");
        //mag.applicableThings.add("burner");
        
        
        
        
        magicLocations.add(garden);
        magicLocations.add(livingRoom);
        magicLocations.add(attic);
        magicLocations.add(basement);
        magicLocations.add(garden_shed);
        magicLocations.add(laboratory);
        magicLocations.add(bigDub);
        magicLocations.add(pond);


        magicThings.add(bucket);
        magicThings.add(chain);
        magicThings.add(well);
        magicThings.add(burner);
        magicThings.add(mag);
        magicThings.add(alcohol);
        magicThings.add(frog);
        
        Interactive gamePlay = new Interactive();
        
        System.out.println("Welcome to the game!");
        System.out.println("possible commands: go west - 1 , go east - 2, \n" +
                "go up - 3, go down - 4, exit - 0,");
        System.out.println("inventory - 7, look around - 5, look at map - 9");
        System.out.println("catch THING - 6 THING,\napply THING1 THING2 - 8 THING1 THING2");

        //String textOfUser = in.nextLine();
        //System.out.println(textOfUser);
        while(keyGameRun)
            gamePlay.recognizeUserCommand(in.nextLine(), magicThings, man, magicLocations,ThisRecord);
    }
}


