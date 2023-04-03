package textquest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Record {
    public  int score=0;
    public  String name="Gamer";
    public  int turns=0;
    public  int Interactions=1;
    public  int Success=1;


    public List<Record> Scoretable= new ArrayList<>();
    List<Record>  LoadStatistics(){
        File file = new File("Files/Records.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            List<Record> Scoretable= new ArrayList<>();
            Record newrecord = new Record();
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] words = line.split(" ");
                newrecord.score=Integer.parseInt(words[0]);
                newrecord.name=words[4];
                newrecord.turns=Integer.parseInt(words[1]);
                newrecord.Interactions=Integer.parseInt(words[2]);
                newrecord.Success=Integer.parseInt(words[3]);
                Scoretable.add(newrecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return Scoretable;}

    void SaveStatistics( List<Record> Scoretable){
        try(FileWriter writer = new FileWriter("Files/Records.txt", false))
        {
            String text = "Человек_тест 233!\n";
            for(int i = 0; i < Scoretable.size(); i++) {
                text = Scoretable.get(i).score+" "+Scoretable.get(i).turns+" "+Scoretable.get(i).Interactions+" "+Scoretable.get(i).Success+" "+Scoretable.get(i).name;
                writer.append(text);
                //System.out.println(i);
            }

            writer.flush();
        }
        catch(IOException ex){
    }

}
    List<Record> SortStatistics(List<Record> Scoretable,Record ThisRecord){
        Scoretable.add(ThisRecord);//добавляем в конец
        int Vstavka=-1;
        for(int i = 0; i < Scoretable.size(); i++) {
            if ((Scoretable.get(i).score < ThisRecord.score)&&(Vstavka==-1)) {
                Vstavka=i;
                }
        }
        for(int i = Scoretable.size(); i > Vstavka; i--) {
            if (i>1)  { Scoretable.set(i, Scoretable.get(i-1));}
        }
        if (Vstavka>1)  {Scoretable.set(Vstavka, ThisRecord);}
        return Scoretable;}

    String PrintStatistics(List<Record> Scoretable){
        System.out.println("StatisticTable");
        for(int i = 0; i < Scoretable.size(); i++) {
            System.out.println(i+" place, score - "+ Scoretable.get(i).score+", turns "+Scoretable.get(i).turns+",Interactions  "+Scoretable.get(i).Interactions+",Success "+Scoretable.get(i).Success/*+"name- "+Scoretable.get(i).name*/);
        }
        return " " ;}


    @Override
    public String toString() {
        return "Record{" +
                "score=" + score +
                ", name='" + name + '\'' +
                ", turns=" + turns +
                ", Interactions=" + Interactions +
                ", Success=" + Success +
                '}';
    }
}
