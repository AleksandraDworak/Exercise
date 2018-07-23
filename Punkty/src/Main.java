public class Main {
    public static void main(String[] args) {
        Punkt2d punkt = new Punkt2d(5, 5);
        Punkt2d punkt2 = new Punkt2d();

        System.out.println(punkt2.x + " " + punkt2.y);

        Punkt3d test = new Punkt3d(5, 5, 7);
        System.out.println(test.x + " " + test.y + " " + test.z);


    }

}


class Punkt2d {
    int x;
    int y;

    Punkt2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Punkt2d() {
        x = 0;
        y = 0;
    }

}

class Punkt3d extends Punkt2d {
    int z;

    Punkt3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    ;


}

class Test {
    static void zwieksz(Punkt2d punkt) {
        punkt.x++;
        punkt.y++;
    }

}