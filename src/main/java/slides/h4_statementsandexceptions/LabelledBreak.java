package slides.h4_statementsandexceptions;

public class LabelledBreak {
    public static void main(String[] args) {

        loopouter:
        for (int i = 0; i < 2; i++) {
            loopinner:
            for (int j = 0; j < 5; j++) {
                if (j == 2) {
                    break loopinner;
                    // break loopouter; // check the difference!
                }

                System.out.println("i = " + i);
                System.out.println("j = " + j);

                System.out.println("inner end");
            }
            System.out.println("outer end");
        }

        System.out.println("out of the loops");

    }
}
