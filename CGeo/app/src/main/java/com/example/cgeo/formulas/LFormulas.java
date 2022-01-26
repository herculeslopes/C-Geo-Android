package com.example.cgeo.formulas;

import java.lang.Math;

public class LFormulas {
    public static double getArea(double y, double k, double x, double u) {
        return x * u + k * y;
    }

    public static double getPerimeter(double y, double k, double x, double u) {
        return 2 * u + 2 * x + 2 * k;
    }

    public static double getCy(double y, double k, double x, double u) {
        return ((x * u * (x / 2)) + (k * y * ((k / 2) + x))) / (x * u + k * y);
    }

    public static double getCx(double y, double k, double x, double u) {
        return ((y * k * (y / 2)) + (x * u * (u / 2))) / (x * u + y * k);
    }

    public static double getIz(double y, double k, double x, double u, double cy) {
        double t = x + (k / 2);
        double h = (x / 2);
        return (
                ((y * Math.pow(k, 3)) / 12 + y * k * Math.pow((t - cy), 2))
                +
                ((u * Math.pow(x, 3) / 12) + u * x * Math.pow((cy - h), 2))
        );
    }

    public static double getIy(double y, double k, double x, double u, double cx) {
        return (
                (
                    ((k * Math.pow(y, 3)) / 12) + (y * k * Math.pow((cx - (y / 2)), 2))
                )
                +
                (
                    ((x * (Math.pow(u, 3))) / 12) + (u * x * (Math.pow((cx - (u / 2)), 2)))
                )
        );
    }

    public static double getScgz(double y, double k, double x, double u, double cy) {
        double a = k + x;
        double scgz;
        if (cy >= x) {
            scgz = (a - cy) * y * ((a - cy) / 2);
        } else {
            scgz = cy * u * (cy / 2);
        }

        return scgz;
    }

    public static double getScgy(double y, double k, double x, double u, double cx) {
        double scgy;
        if (x >= y) {
            scgy = x * (u - cx) * (u - cx / 2);
        } else {
            scgy =  cx * k * (cx / 2);
        }

        return scgy;
    }

    public static double getKz(double area, double iz) {
        return Math.sqrt(iz / area);
    }

    public static double getKy(double area, double iy) {
        return Math.sqrt(iy / area);
    }
}
