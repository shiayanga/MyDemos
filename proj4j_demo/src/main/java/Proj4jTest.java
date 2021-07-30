import org.osgeo.proj4j.*;
import org.osgeo.proj4j.io.Proj4FileReader;

import java.io.IOException;

import static util.coordinateReferenceSystem.CoordinateReferenceSystem.*;
import static util.transform.Transform.*;

/**
 * @author LiYang
 * @version V1.0
 * @className Proj4jTest
 * @description TODO
 * @date 2021/7/25 14:57
 */
public class Proj4jTest {

    public static void main(String[] args) throws IOException {
        // wgs842beijing54(117.700169, 49.430177, 0);
        // ProjCoordinate beijing542wgs84 = beijing542wgs84(5479133.603, 39554440.85, 329.9);
        // wgs8423857(beijing542wgs84.x, beijing542wgs84.y, beijing542wgs84.z);

        Cgcs2000ToWgs84(37405640.08091,4284252.26297,"4508");
        Cgcs2000ToWgs84(4284252.26297,37405640.08091,"4495");
    }




}
