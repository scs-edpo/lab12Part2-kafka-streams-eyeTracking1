package magicalpipelines.utils;

public class Utils {

    public static String[] AOIS = {"AOI1","AOI2","AOI3","AOI4","AOI5"};

    /*
    This method should translate the xPos and yPos of gazes into AOIs.
    For sake of simulation, in this example, the AOIs are returned randomly
     */
    public static String findAOI(double xPos, double yPos) {

        return AOIS[getRandomNumber(0, AOIS.length)];

    }

    /*
    Generate a random nunber
    */
    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
