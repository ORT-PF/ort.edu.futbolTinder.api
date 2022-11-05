package ort.edu.futbolTinder.utils.geography;

import static java.lang.Math.sqrt;

public class GeographyUtils {
    private final static double AVERAGE_RADIUS_OF_EARTH = 6371;

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        double latDistance = Math.toRadians(lat1 - lat2);
        double lngDistance = Math.toRadians(lon1 - lon2);

        double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)) +
                (Math.cos(Math.toRadians(lat1))) *
                        (Math.cos(Math.toRadians(lat2))) *
                        (Math.sin(lngDistance / 2)) *
                        (Math.sin(lngDistance / 2));

        double c = 2 * Math.atan2(sqrt(a), sqrt(1 - a));

        return AVERAGE_RADIUS_OF_EARTH * c;

    }
}
