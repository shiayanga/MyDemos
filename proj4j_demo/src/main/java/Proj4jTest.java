import org.osgeo.proj4j.*;
import org.osgeo.proj4j.io.Proj4FileReader;

import java.io.IOException;

/**
 * @author LiYang
 * @version V1.0
 * @className Proj4jTest
 * @description TODO
 * @date 2021/7/25 14:57
 */
public class Proj4jTest {
    private static CRSFactory crsFactory;
    private static Proj4FileReader proj4FileReader;

    public static void main(String[] args) throws IOException {
        wgs842beijing54(117.700169, 49.430177, 0);
        ProjCoordinate beijing542wgs84 = beijing542wgs84(5479133.603, 39554440.85, 329.9);
        wgs8423857(beijing542wgs84.x, beijing542wgs84.y, beijing542wgs84.z);
    }

    public static ProjCoordinate beijing542wgs84(double x, double y, double z) throws IOException {
        CoordinateReferenceSystem beijing54 = getBeijing54();
        CoordinateReferenceSystem wgs84 = getWgs84();

        CoordinateTransformFactory coordinateTransformFactory = new CoordinateTransformFactory();
        CoordinateTransform transform = coordinateTransformFactory.createTransform(beijing54, wgs84);

        ProjCoordinate projCoordinate = new ProjCoordinate(x, y, z);

        ProjCoordinate coordinate = transform.transform(projCoordinate, projCoordinate);
        System.out.println(coordinate.toShortString() + "\n");
        return coordinate;

    }

    public static void wgs842beijing54(double x, double y, double z) throws IOException {
        CoordinateReferenceSystem beijing54 = getBeijing54();
        CoordinateReferenceSystem wgs84 = getWgs84();

        CoordinateTransformFactory coordinateTransformFactory = new CoordinateTransformFactory();
        CoordinateTransform transform = coordinateTransformFactory.createTransform(wgs84, beijing54);

        ProjCoordinate projCoordinate = new ProjCoordinate(x, y, z);

        ProjCoordinate coordinate = transform.transform(projCoordinate, projCoordinate);
        System.out.println("原坐标（WGS84） >>>>>>>>>> " + x + "," + y);
        System.out.println("转换后（Beijing54） >>>>>> " + coordinate.toShortString() + "\n");

    }

    public static void wgs8423857(double x, double y, double z) throws IOException {
        CoordinateReferenceSystem epsg3857 = get3857();
        CoordinateReferenceSystem wgs84 = getWgs84();

        CoordinateTransformFactory coordinateTransformFactory = new CoordinateTransformFactory();
        CoordinateTransform transform = coordinateTransformFactory.createTransform(epsg3857,wgs84);

        ProjCoordinate projCoordinate = new ProjCoordinate(x, y, z);

        ProjCoordinate coordinate = transform.transform(projCoordinate, projCoordinate);
        System.out.println("原坐标（EPSG:3857） >>>>>> " + x + "," + y);
        System.out.println("转换后（EPSG:4326） >>>>>> " + coordinate.toShortString() + "\n");

    }

    public static CoordinateReferenceSystem getBeijing54() {
        proj4FileReader = new Proj4FileReader();
        crsFactory = new CRSFactory();
        // 第一种创建坐标参考系的方法
        String sourceCrsName = "Beijing1954";
        String sourceCrsParams1 = "+proj=tmerc +lat_0=0 +lon_0=69 +k=1 +x_0=25500000 +y_0=0 +ellps=krass +towgs84=15.8,-154.4,-82.3,0,0,0,0 +units=m +no_defs";
        CoordinateReferenceSystem beijing54fromParameters = crsFactory.createFromParameters(sourceCrsName, sourceCrsParams1);

        // 第二种创建坐标参考系的方法
        Proj4FileReader proj4FileReader = new Proj4FileReader();
        String[] sourceCrsParams = new String[0];
        try {
            sourceCrsParams = proj4FileReader.readParametersFromFile("epsg", "2401");
        } catch (IOException e) {
            e.printStackTrace();
        }
        CoordinateReferenceSystem beijing1954 = crsFactory.createFromParameters("Beijing1954", sourceCrsParams);
        return beijing1954;
    }

    public static CoordinateReferenceSystem get3857() {
        crsFactory = new CRSFactory();
        proj4FileReader = new Proj4FileReader();

        String[] targetCrsParams = new String[0];
        try {
            targetCrsParams = proj4FileReader.readParametersFromFile("epsg", "3857");
        } catch (IOException e) {
            e.printStackTrace();
        }
        CoordinateReferenceSystem wgs84 = crsFactory.createFromParameters("WGS84", targetCrsParams);
        return wgs84;
    }

    public static CoordinateReferenceSystem getWgs84() {
        crsFactory = new CRSFactory();
        proj4FileReader = new Proj4FileReader();

        String[] targetCrsParams = new String[0];
        try {
            targetCrsParams = proj4FileReader.readParametersFromFile("epsg", "4326");
        } catch (IOException e) {
            e.printStackTrace();
        }
        CoordinateReferenceSystem wgs84 = crsFactory.createFromParameters("WGS84", targetCrsParams);
        return wgs84;
    }

}
