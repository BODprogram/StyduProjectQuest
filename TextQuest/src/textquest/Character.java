package textquest;

class Character extends MaterialObjectInTheWorld {
    Character(int thisX, int thisY, String thisName) {
        x = thisX;
        y = thisY;
        name = thisName;
    }

    void go(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
