package util.coordinateReferenceSystem;

import org.osgeo.proj4j.CRSFactory;
import org.osgeo.proj4j.io.Proj4FileReader;

import java.io.IOException;

/**
 * @author LiYang
 * @version V1.0
 * @className CoordinateReferenceSystem
 * @description TODO
 * @date 2021/7/30 10:21
 */
public class CoordinateReferenceSystem {
    private static CRSFactory crsFactory;
    private static Proj4FileReader proj4FileReader;
    public static org.osgeo.proj4j.CoordinateReferenceSystem getBeijing54() {
        proj4FileReader = new Proj4FileReader();
        crsFactory = new CRSFactory();
        // 第一种创建坐标参考系的方法
        String sourceCrsName = "Beijing1954";
        String sourceCrsParams1 = "+proj=tmerc +lat_0=0 +lon_0=69 +k=1 +x_0=25500000 +y_0=0 +ellps=krass +towgs84=15.8,-154.4,-82.3,0,0,0,0 +units=m +no_defs";
        org.osgeo.proj4j.CoordinateReferenceSystem beijing54fromParameters = crsFactory.createFromParameters(sourceCrsName, sourceCrsParams1);

        // 第二种创建坐标参考系的方法
        Proj4FileReader proj4FileReader = new Proj4FileReader();
        String[] sourceCrsParams = new String[0];
        try {
            sourceCrsParams = proj4FileReader.readParametersFromFile("epsg", "2401");
        } catch (IOException e) {
            e.printStackTrace();
        }
        org.osgeo.proj4j.CoordinateReferenceSystem beijing1954 = crsFactory.createFromParameters("Beijing1954", sourceCrsParams);
        return beijing1954;
    }

    public static org.osgeo.proj4j.CoordinateReferenceSystem get3857() {
        crsFactory = new CRSFactory();
        proj4FileReader = new Proj4FileReader();

        String[] targetCrsParams = new String[0];
        try {
            targetCrsParams = proj4FileReader.readParametersFromFile("epsg", "3857");
        } catch (IOException e) {
            e.printStackTrace();
        }
        org.osgeo.proj4j.CoordinateReferenceSystem wgs84 = crsFactory.createFromParameters("WGS84", targetCrsParams);
        return wgs84;
    }

    public static org.osgeo.proj4j.CoordinateReferenceSystem getWgs84() {
        crsFactory = new CRSFactory();
        proj4FileReader = new Proj4FileReader();

        String[] targetCrsParams = new String[0];
        try {
            targetCrsParams = proj4FileReader.readParametersFromFile("epsg", "4326");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crsFactory.createFromParameters("WGS84", targetCrsParams);
    }

    public static org.osgeo.proj4j.CoordinateReferenceSystem getCgcs2000(String epsg) {
        crsFactory = new CRSFactory();
        proj4FileReader = new Proj4FileReader();

        String[] targetCrsParams = new String[0];
        try {
            targetCrsParams = proj4FileReader.readParametersFromFile("epsg", epsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crsFactory.createFromParameters("CGCS2000", targetCrsParams);
    }
}
