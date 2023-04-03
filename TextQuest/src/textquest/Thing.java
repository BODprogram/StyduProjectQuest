package textquest;

import java.util.ArrayList;

class Thing extends MaterialObjectInTheWorld {
    boolean taken = false;  //предмет взятый = неправда
    boolean canTake = true; //предмет можно взять = правда //т.е. подбираемость предмета

    ArrayList<String> applicableThings = new ArrayList<>();
    int appliedCounter = 0;
    //ArrayList<String> appliedThings = new ArrayList<>();

    Thing(int thisX, int thisY, String thisName, boolean thisCanTake, boolean thisTaken) {
        x = thisX;
        y = thisY;
        name = thisName;
        canTake = thisCanTake;
        taken = thisTaken;
    }
}
