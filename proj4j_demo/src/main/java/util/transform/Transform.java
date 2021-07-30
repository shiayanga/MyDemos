package util.transform;

import org.osgeo.proj4j.CoordinateReferenceSystem;
import org.osgeo.proj4j.CoordinateTransform;
import org.osgeo.proj4j.CoordinateTransformFactory;
import org.osgeo.proj4j.ProjCoordinate;

import java.io.IOException;

import static util.coordinateReferenceSystem.CoordinateReferenceSystem.*;
import static util.coordinateReferenceSystem.CoordinateReferenceSystem.getWgs84;

/**
 * @author LiYang
 * @version V1.0
 * @className Transform
 * @description TODO
 * @date 2021/7/30 10:26
 */
public class Transform {
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

    public static void Cgcs2000ToWgs84(double x, double y,String cgcs) throws IOException {
        CoordinateReferenceSystem epsg3857 = getCgcs2000(cgcs);
        CoordinateReferenceSystem wgs84 = getWgs84();

        CoordinateTransformFactory coordinateTransformFactory = new CoordinateTransformFactory();
        CoordinateTransform transform = coordinateTransformFactory.createTransform(epsg3857,wgs84);

        ProjCoordinate projCoordinate = new ProjCoordinate(x, y, 0);

        ProjCoordinate coordinate = transform.transform(projCoordinate, projCoordinate);
        System.out.println("原坐标（CGCS 2000） >>>>>> " + x + "," + y);
        System.out.println("转换后（EPSG:4326） >>>>>> " + coordinate.toShortString() + "\n");

    }

}
