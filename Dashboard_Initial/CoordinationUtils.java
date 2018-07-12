
import static java.lang.Math.*;

public class CoordinationUtils {

  
      public static float mercX(float lon, int zoom) {
        lon = (float) Math.toRadians((double) lon);
        float a = (float) ((256 / PI) * Math.pow(2, zoom));
        float b = (float) (lon + PI);
        return a * b;
    }

    public static float mercY(float lat, int zoom) {
        lat = (float) Math.toRadians(lat);
        float a = (float) ((256 / PI) * Math.pow(2, zoom));
        float b = (float) Math.tan(PI / 4 + lat / 2);
        float c = (float) (PI - log(b));
        return a * c;
    }
  
}
