package textquest;

import java.util.ArrayList;
import java.util.List;

class Interactive {

    private InteractiveEmotion interactiveEmotion = new InteractiveEmotion();


    public void recognizeUserCommand(String userCommand, ArrayList<Thing> things, Character magStudent, ArrayList<Location> locations,Record ThisRecord) {

        //если введена команда "инвентарь"
        if (userCommand.equals("7")) {
            //перебрать все вещи и вывести подобранные
            for (Thing th : things) {
                if (th.taken == true) {
                    System.out.print(" " + th.name + ",");
                }
            }
            System.out.println(".");
        }
        //если введена команда "осмотреться"
        else if (userCommand.equals("5")) {
            lookAround(magStudent, locations);

            //перебрать все вещи и вывести неподобранные и находящиеся в той же локации что и персонаж
            System.out.print("There is:");
            for (Thing th : things) {
                if (th.taken == false && th.x == magStudent.x && th.y == magStudent.y) {
                    System.out.print(" " + th.name + ",");
                }
            }
            System.out.println(".");
        }
        else if (userCommand.equals("9")) {
            ImageViev image = new ImageViev();
            image.img();
        }

        //если введена команда "идти запад"
        else if (userCommand.equals("1")) {
            moveCharacter(-1, 0, magStudent, locations, things,ThisRecord);
        }
        //если введена команда "идти восток"
        else if (userCommand.equals("2")) {
            moveCharacter(1, 0, magStudent, locations, things,ThisRecord);
        }
        //если введена команда "идти вверх"
        else if (userCommand.equals("3")) {
            moveCharacter(0, 1, magStudent, locations, things,ThisRecord);
        }
        //если введена команда "идти вниз"
        else if (userCommand.equals("4")) {
            moveCharacter(0, -1, magStudent, locations, things,ThisRecord);
        }
        //если введена команда "подобрать"
        else if (userCommand.matches("6.*")) {
            //System.out.println("you enter catch");
            for (Thing th : things) {
                //if(th.taken == true)
                if (userCommand.matches("6 " + th.name)) {
                    if (th.taken == true) {
                        System.out.println("It's already catched");
                    } else if (th.canTake == false) {
                        System.out.println("It can't be catched");
                    } else {
                        th.taken = true;
                        System.out.println("You catch: " + th.name);
                    }
                    //System.out.print(" "+th.name+",");

                }
            }
        }
        //если введена команда "применить"
        else if (userCommand.matches("8.*")) {
            ThisRecord.Interactions++;
            String[] splited = userCommand.split("\\s+");
            /*
            if(splited.length == 3)//соединяются два предмета (первое слово в массиве - это команда "применить")
            {
                for(Thing th: things)
                {
                    if(th.name.equals(splited[1]))//найден предмет который применяется к чему либо
                    {
                        if(th.applicableThings.size()==1)//проверка на невыход за пределы списка
                        {
                            if( th.applicableThings.get(0).equals(splited[2]) )//если предметы соединяемые
                            {
                                th.appliedThings.add(splited[2]);//присоединить к первому предмету второй предмет
                                th.name += "_"+splited[2];//переименовать предмет в предмет с присоединенными к нему предметами
                                System.out.println("You applied "+splited[1]+" to "+splited[2]+"!");
                                //проверить закончена ли успешно игра
                                if(th.name.equals("bucket_chain_burner_well_mag"))
                                {
                                    System.out.println("You win!!!");
                                    System.exit(0);
                                }
                            }
                            else
                            {
                                System.out.println("These things are not applicable.");
                            }
                        }
                        else
                        {
                            System.out.println("These things are not applicable. ");
                        }
                    }
                }
            }
            */


            /*
            else if(splited.length == 4)//соединяются три предмета (первое слово в массиве - это команда "применить")
            {
                for(Thing th: things)
                {
                    if(th.name.equals(splited[1]))//найден предмет который применяется к чему либо
                    {
                        if(th.applicableThings.size()==2)//проверка на невыход за пределы списка
                        {
                            if( th.applicableThings.get(0).equals(splited[2]) && th.applicableThings.get(1).equals(splited[3]))
                            {
                                th.appliedThings.add(splited[2]);//присоединить к первому предмету второй предмет
                                th.appliedThings.add(splited[3]);//присоединить к первому предмету третий предмет
                                th.name += "_"+splited[2]+"_"+splited[3];//переименовать предмет в предмет с присоединенными к нему предметами
                                System.out.println("You applied "+splited[1]+" to "+splited[2]+" to "+splited[3]+"!");
                            }
                            else
                            {
                                System.out.println("These things are not applicable.");
                            }
                        }
                        else
                        {
                            System.out.println("These things are not applicable.");
                        }
                    }
                }
            }
            */


            if (splited.length == 3)//соединяются два предмета (первое слово в массиве - это команда "применить")
            {
                for (Thing th : things) {
                    if (th.name.equals(splited[1]))//найден предмет который применяется к чему либо
                    {

                        if (th.appliedCounter < th.applicableThings.size())//проверка на невыход за пределы списка
                        {
                            if (th.applicableThings.get(th.appliedCounter).equals(splited[2]))//найдео то к чему применяется предмет
                            {

                                for (Thing th2 : things)//найти второй предмет по имени
                                {
                                    if (th2.name.equals(splited[2]))//второй предмет найден
                                    {
                                        if (th.x == magStudent.x && th.y == magStudent.y && th2.x == magStudent.x && th2.y == magStudent.y)//проверка на наличие предметов около персонажа
                                        {
                                            System.out.println("You applied " + splited[1] + " to " + splited[2] + "!");
                                            ThisRecord.Success++;
                                            th.appliedCounter++;
                                            if (th.appliedCounter == th.applicableThings.size())//завершена вся цепь применений поздравить с победой
                                            {
                                                System.out.println("You win!!!");
                                                ThisRecord.score=(ThisRecord.Success*100/(ThisRecord.turns*ThisRecord.Interactions));
                                                ThisRecord.Scoretable=ThisRecord.SortStatistics(ThisRecord.LoadStatistics(),ThisRecord);
                                                ThisRecord.SaveStatistics(ThisRecord.Scoretable);
                                                ThisRecord.PrintStatistics(ThisRecord.Scoretable);
                                                System.exit(0);
                                            }
                                        } else {
                                            System.out.println("You don't have this thing.");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("These things are not applicable.");
                            }
                        } else {
                            System.out.println("These things are not applicable.");
                        }


                        //appliedCounter
                        //for(int i=0; i<th.applicableThings.size(); i++)
                        //{

                        //}
                        /*
                        if(th.applicableThings.size()==1)//проверка на невыход за пределы списка
                        {
                            if( th.applicableThings.get(0).equals(splited[2]) )//если предметы соединяемые
                            {
                                //th.appliedThings.add(splited[2]);//присоединить к первому предмету второй предмет
                                th.name += "_"+splited[2];//переименовать предмет в предмет с присоединенными к нему предметами
                                System.out.println("You applied "+splited[1]+" to "+splited[2]+"!");
                                //проверить закончена ли успешно игра
                                if(th.name.equals("bucket_chain_burner_well_mag"))
                                {
                                    System.out.println("You win!!!");
                                    System.exit(0);
                                }
                            }
                            else
                            {
                                System.out.println("These things are not applicable.");
                            }
                        }
                        else
                        {
                            System.out.println("These things are not applicable. ");
                        }
                        */
                    }
                }
            } else {
                System.out.println("Unknown command");
            }

        }
        //если введена команда "выход"
        else if (userCommand.equals("0")) {
            System.exit(0);
        } else {
            System.out.println(interactiveEmotion.getRandomFailureEmotion());
        }
        //System.out.println(КОНЕЦ ХОДА);
    }

    //вспомогательный метод для перемещения персонажа
    public void moveCharacter(int moveX, int moveY, Character mS, ArrayList<Location> lo, ArrayList<Thing> thi,Record ThisRecord) {
        boolean locationExists;
        locationExists = false;
        //пребрать все локации и если в нужном направлении их нет то вывести предупреждение
        for (Location loc : lo) {
            if (loc.x == mS.x + moveX && loc.y == mS.y + moveY) {
                locationExists = true;
            }
        }
        if (locationExists == true) {
            System.out.println(interactiveEmotion.getRandomSuccessEmotion());
            //двинуть персонаж
            mS.go(moveX, moveY);
            //двинуть все подобранные персонажем предметы
            for (Thing th : thi) {
                if (th.taken == true) {
                    th.x = mS.x;
                    th.y = mS.y;
                }
            }
            //оглядеться
            lookAround(mS, lo);
        } else {
            System.out.println(interactiveEmotion.getRandomFailureEmotion());
        }
        ThisRecord.turns++;
        //System.out.println("Ходы:"+ThisRecord.turns);
    }

    //вспомогательный метод осмотра вокруг
    public void lookAround(Character mS, ArrayList<Location> lo) {
        System.out.print("You are in:");
        //пребрать все локации и вывести ту в которой персонаж
        for (Location loc : lo) {
            if (loc.x == mS.x && loc.y == mS.y) {
                System.out.println(" " + loc.name + ". ");

                switch (loc.name){

                    case "livingRoom"-> System.out.println("This is a simple living room. \nIt looks like a old man lived here.");
                    case "garden"-> System.out.println("Green vines wrap around all the objects in this place. \nClearly no one is following this.");
                    case "attic"-> System.out.println("The old dusty attic looks quite cozy. \nI would like to stay here longer.");
                    case "basement"-> System.out.println("Вы спустились в темный подвал,\n который освещает только полоска света из комнаты. \n ");
                    case "garden shed"-> System.out.println("В сарае находится рабочий инвентарь.\nВпрочем, и разного 'полезного' хлама тут хватает.\n" +
                            "Ваш учитель не хочет от него избавляться");
                    case "laboratory"-> System.out.println("Самая обычная лаборатория.\nЗдесь очень много разных емкостей," +
                            "как пустых так и чем-то заполненных");
                    case "Glade under an ancient oak"-> System.out.println("Перед вами возвышается огромный старинный дуб.\n" +
                            "В его тени располагается полянка, на которой вы любите отдыхать");
                    case "Little pond"-> System.out.println("Небольшой прозрачный пруд.\nОн красивый");

                }

                break;
            }
        }
    }


}
