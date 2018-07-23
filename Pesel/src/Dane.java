class Dane {

    private String pesel;
    private String nazwisko;
    private String imie;
    private int rUrodzenia;
    private int mUrodzenia;
    private int dUrodzenia;

    Dane(String pesel, String nazwisko, String imie, int rUrodzenia, int mUrodzenia, int dUrodzenia) {
        this.pesel = pesel;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.rUrodzenia = rUrodzenia;
        this.mUrodzenia = mUrodzenia;
        this.dUrodzenia = dUrodzenia;
    }

    void run() {

        spawdzDlugosc();
        sprawdzTypImie();
        sprawdzTypNazwisko();
        sprawdzPesel();
        System.out.println("done");
    }

    private void spawdzDlugosc() {
        if (!((imie.length()) > 1 && (nazwisko.length() > 1)))
            System.out.println("error - surname too short");

    }

    private void sprawdzTypImie() {
        int i;
        for (i = 0; i < (imie.length()); i++) {
            char z = imie.charAt(i);
            if (!(z > '@'))
                System.out.println("error - name too short");
        }
    }

    private void sprawdzTypNazwisko() {
        int i;
        for (i = 0; i < (nazwisko.length()); i++) {
            char z = nazwisko.charAt(i);
            if (!(z > '@'))
                System.out.println("error data type - surname");
        }
    }

    private void sprawdzPesel() {
        if (!(pesel.length() == 11)) {
            System.out.println("error - pesel lenhgt");
        } else {
            peselCyfraKontrolna();
            peselMUrodzenia();
            peselDUrodzenia();
            peselRUrodzenia();
            peselPlec();

        }
    }

    private void peselCyfraKontrolna() {
        int i = 0;
        int[] kontrolna = new int[11];
        for (i = 0; i < (pesel.length()); i++) {
            int a = Character.getNumericValue(pesel.charAt(i));
            kontrolna[i] = a;
        }

        int sumaKontrolna =
                (1 * (kontrolna[0] + kontrolna[4] + kontrolna[8] + kontrolna[10])) +
                        (3 * (kontrolna[1] + kontrolna[5] + kontrolna[9])) +
                        (7 * (kontrolna[2] + kontrolna[6])) +
                        (9 * (kontrolna[3] + kontrolna[7]));
        int sum = sumaKontrolna % 10;
        if (sum != 0) {
            System.out.println("error - incorrect control number");
        }


    }

    private void peselMUrodzenia() {

        String tmp = pesel.substring(2, 4);
        int a = Integer.parseInt(tmp);


        if (a >= 1 && a <= 12) {
            if (mUrodzenia != a) {
                System.out.println("error - birth date month");
            }
        } else if (a >= 21 && a <= 32) {
            if (mUrodzenia != (a - 20)) {
                System.out.println("error - birth date month");
            }
        } else if (a >= 41 && a <= 52) {
            if (mUrodzenia != (a - 40)) {
                System.out.println("error - birth date month");
            }
        } else if (a >= 61 && a <= 72) {
            if (mUrodzenia != (a - 60)) {
                System.out.println("error - birth date month");
            }
        } else if (a >= 81 && a <= 92) {
            if (mUrodzenia != (a - 80)) {
                System.out.println("error - birth date month");
            }
        }
    }

    private void peselDUrodzenia() {
        String tmp = pesel.substring(4, 6);
        int a = Integer.parseInt(tmp);
        if (a != dUrodzenia) {
            System.out.println("error - birth date day");
        }
    }

    private void peselRUrodzenia() {

        String tmpM = pesel.substring(2, 4);
        String tmpY = pesel.substring(0, 2);
        int a = Integer.parseInt(tmpM);

        if (a >= 1 && a <= 12) {
            int b = Integer.parseInt("19" + tmpY);
            if (b != rUrodzenia) {
                System.out.println("error birth date year");
            }
        } else if (a >= 21 && a <= 32) {
            int b = Integer.parseInt("20" + tmpY);
            if (b != rUrodzenia) {
                System.out.println("error birth date year");
            }
        } else if (a >= 41 && a <= 52) {
            int b = Integer.parseInt("21" + tmpY);
            if (b != rUrodzenia) {
                System.out.println("error birth date year");
            }
        } else if (a >= 61 && a <= 72) {
            int b = Integer.parseInt("22" + tmpY);
            if (b != rUrodzenia) {
                System.out.println("error birth date year");
            }
        } else if (a >= 81 && a <= 92) {
            int b = Integer.parseInt("18" + tmpY);
            if (b != rUrodzenia) {
                System.out.println("error birth date year");
            }
        }

    }

    private void peselPlec() {


        int a = Character.getNumericValue(pesel.charAt(10));
        char c = imie.charAt((imie.length()) - 1);
        int r = a % 2;

        if (!((c == 'a' && r == 1) || (c != 'a' && r != 1))) {

            System.out.println("gender unknown");
        }
    }
}




























