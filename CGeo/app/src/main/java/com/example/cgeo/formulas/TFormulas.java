package com.example.cgeo.formulas;

import java.lang.Math;

public class TFormulas {
    private double area, perimeter, cy, cx, iz, iy, scgz, scgy, kz, ky;



    public static double getArea(double x, double b, double y, double z) {
        return x * b + y * z;
    }

    public static double getPerimeter(double x, double b, double y, double z) {
        return z + 2 * y + 2 * b + x + x - z;
    }

    public static double getCy(double x, double b, double y, double z) {
        return (z * y * (y / 2) + b * x * (y + (b / 2))) / (z * y + b * x);
    }

    public static double getCx(double x) {
        return x / 2;
    }

    public static double getIz(double x, double b, double y, double z, double cy) {
        return (
                (((x * (Math.pow(b, 3))) / (12) ) + (b * x * Math.pow(((y + (b / 2) - cy)), 2)))
                +
                (((z * Math.pow(y, 3)) / (12)) + (y * z * (Math.pow(cy - (y / 2), 2))))
            );
    }

    public static double getIy(double x, double b, double y, double z) {
        return ((y * Math.pow(z, 3)) / 12) + ((b * Math.pow(x, 3)) / 12);
    }

    public static double getScgz(double x, double b, double y, double z, double cy) {
        double scgz;
        if (cy == y) {
            scgz = y * z * (y / 2);
        } else if (cy < y) {
            scgz = cy * z * (cy / 2);
        } else {
            scgz = scgz = (b + y - cy) * x * ((b + y - cy) / 2);
        }

        return scgz;
    }

    public static double getScgy(double x, double b, double y, double z) {
        return (z / 2) * y * (z / 4) + (x / 2) * b * (x / 4);
    }

    public static double getKz(double area, double iz) {
        return Math.sqrt(iz / area);
    }

    public static double getKy(double area, double iy) {
        return Math.sqrt(iy / area);
    }

    public static double getFibra(double x, double b, double y, double z, double cy, double length, String position) {
        double fibra = -1;
        if ((position.equals("up") && (cy + length <= y + b)) || ((position.equals("down") && (cy - length >= 0)))) {
            if (cy > y) {
                if (position.equals("down")) {
                    if (cy - length < y) {
                        double h = cy - length;
                        fibra = h * z * ((h / 2) + length);
                    } else if (cy - length > y) {
                        double d = cy - length  - y;
                        fibra = (d * x * ((d / 2) + length)) + (y * z * ((y / 2) + d + length));
                    } else if (cy - length == y) {
                        fibra = y * z * (y / 2) + length;
                    }
                } else if (position.equals("up")) {
                    if (cy + length < (y + b)) {
                        double i = y + b - (cy + length);
                        fibra = i * x * ((i / 2) + length);
                    }
                }
            } else if (cy < y) {
                if (position.equals("up")) {
                    if (cy + length == y) {
                        fibra = b * x * ((b / 2) + length);
                    } else if (cy + length < y) {
                        double i = y - (cy + length);
                        fibra = (b * x * ((b / 2 )+ (fibra + i))) + (i * z * ((i / 2) + fibra));
                    } else if (cy + length > y) {
                        double a = (y + b) - (cy + length);
                        fibra = a * x * ((a / 2) + fibra);
                    }
                } else if (position.equals("down")) {
                    if (cy - length < y) {
                        double d = cy - length;
                        fibra = d * z * ((d / 2) + length);
                    }
                }
            } else {
                if (position.equals("up")) {
                    if (cy + length > y) {
                        double a = b - length;
                        fibra = a * x * ((a / 2) + fibra);
                    }
                } else if (position.equals("down")) {
                    if (cy - length < y) {
                        double a = cy - length;
                        fibra = a * z * ((a / 2) + length);
                    }
                }
            }
        }

        return fibra;
    }

}
