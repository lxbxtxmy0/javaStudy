public class UtilConverter {
    public UtilConverter() {}

    public double convertFromCtoF(double degrees) {
        return degrees * 1.8 + 32;
    }

    public double convertFromFtoC(double degrees) {
        return (degrees - 32) / 1.8;
    }
}
