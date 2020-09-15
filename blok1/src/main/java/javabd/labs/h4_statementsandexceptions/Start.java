package javabd.labs.h4_statementsandexceptions;

public class Start {

    public static void main(String[] args) {
        HourglassRefactored hgr = new HourglassRefactored();

        while (true) {
            try {
                int n = hgr.lees(); //1
                hgr.printHourglass(n); //2
                break; //3
            } catch (EvenNumberException | NumberFormatException bom) {
                System.out.println(bom.getMessage()); //4
            } catch (Throwable t) {
                System.err.println("Er ging iets anders mis: " + t.getMessage()); //5
            } finally {
                System.out.println("finally"); //6
            }
            System.out.println("retrying...");//7
        }

    }
}
