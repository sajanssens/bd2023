package labs.h3;

import java.awt.*;

public class SmallPrograms {

    public static void main(String[] args) {
        SmallPrograms sp = new SmallPrograms();

        // 1.
        int i = 1;
        int j = 1;
        System.out.println(i++);
        System.out.println(i);
        System.out.println(++j);
        System.out.println(j);

        // 2.
        i = 3;
        int k = i < 3 ? i++ + ++i : ++i >>> 1;

        System.out.println(j);
        // Explanation:
        // j = ++i >>> 1;
        // ++i is 4, so j = 3 >>> 1; this means: shift all bits one to the right and fill with 0.
        // 4 is 0100 in binary.
        // 0100 >>> 1 is 0010
        // 0010 is 2;
        // so j == 2;

        // 3.
        byte a = 0b1010; // 10
        byte b = 0b100;  // 4
        byte c = (byte) (a + b);
        System.out.println(c);

        // 4.
        i = sp.klok(23, 5);
        i = sp.klok(12, 7);

        System.out.println(i);

        // 5.
        PrimitiveSizeTypes.print();

        // 6.
        Client client1 = new Client("Jan");
        Client client2 = new Client("Piet");
        client2 = client1;
        client2.setName("Joris");
        System.out.println(client1.getName());
    }

    int klok(int huidigeTijd, int urenLater) {
        return (huidigeTijd + urenLater) % 24;
    }

    static void resetNaam(Client c) {
        c.setName("");
    }

    Point howManyHoursAndMinutes(int hoursAndMinutes) {
        if (hoursAndMinutes == 0) {
            return new Point(0, 0);
        }

        int hours = hoursAndMinutes / 60;
        int min = hoursAndMinutes % 60;

        return new Point(hours, min);
    }
}
