package com.example.cgeo.formulas;

import java.lang.Math;

public class UFormulas {
    public static double getArea(double x, double y, double a, double h) {
        return 2 * a * y + x * h;
    }

    public static double getPerimeter(double x, double y, double a, double h) {
        return 2 * y + 2 * (2 * a + h) + 2 * (y - x);
    }

    public static double getCy(double x, double y, double a, double h) {
        return (
                ((2 * (a * y * (y / 2))) + (h * x * (x / 2)))
                /
                ((2 * (a * y)) + (x * h))
        );
    }

    public static double getCx(double a, double h) {
        return (h + 2 * a) / 2;
    }

    public static double getJ(double a, double h, double cx) {
        return h + (2 * a) - cx;
    }

    public static double getIz(double x, double y, double a, double h, double cy) {
        return (
                (2 * (((a * Math.pow(y, 3)) / (12)) + ((y * a * Math.pow(((y / 2) - cy), 2)))))
                +
                ((((h) * Math.pow(x, 3)) / (12)) + (x * h * (Math.pow((cy - (x / 2)), 2))))
        );
    }

    public static double getIy(double x, double y, double a, double cx) {
        double g = y - x;
        return (x * Math.pow(cx, 3)) / 12 + cx * x * Math.pow((cx / 2), 2) + (g * Math.pow(a, 3)) + (g * a * Math.pow((cx - (a / 2)), 2));
    }

    public static double getScgz(double x, double y, double a, double h, double cy) {
        double v = y - x;
        double scgz;

        if (cy <= x) {
            scgz = cy * (a + h + a) * (cy / 2);
        } else {
            scgz = ((y - cy) * a * ((v - cy) / 2)) * 2;
        }

        return scgz;
    }

    public static double getScgy(double x, double y, double a, double j) {
        double g = y - x;
        return (j * x * (j / 2)) + (g * a * (j * (a / 2)));
    }

    public static double getKz(double area, double iz) {
        return Math.sqrt(iz / area);
    }

    public static double getKy(double area, double iy) {
        return Math.sqrt(iy / area);
    }

    public static double getFibra(double x, double y, double a, double h, double cy, double length, String position) {
        double fibra = -1;
        if ((position.equals("up") && (cy + length <= y)) || (position.equals("down") && (cy - length >= 0))) {
            if (cy > x) {
                if (position.equals("up")) {
                    if (cy + length < y) {
                        double m = y - (cy + length);
                        fibra = m * (a + h + a) * ((m / 2) + length);
                    }
                } else if (position.equals("down")) {
                    if (cy - length > x) {
                        double i = (cy - x) - length;
                        fibra = (x * (h + a + a) * ((x / 2) + i + length)) + ( 2 * (i * a * ((i / 2) + length)));
                    } else if (cy - length <= x) {
                        double m = cy - length;
                        fibra = m * (h + a + a) * ((m / 2 ) + length);
                    }
                }
            } else if (cy < x) {
                if (position.equals("down")) {
                    if (cy - length < x) {
                        double i = cy - length;
                        fibra = i * (a + a + h) * ((i / 2) + length);
                    }
                } else if (position.equals("up")) {
                    if (cy + length >= x) {
                        double m = y - (cy + length);
                        fibra = 2 * (m * a * ((m / 2) + length));
                    } else if (cy + length < x) {
                        double v = y - x;
                        double m = (cy + length) - x;
                        fibra = (m * (a + h + a) * ((m / 2)+ length)) + (2 * (a * v * ((v / 2) + length + m)));
                    }
                }
            } else {
                if (position.equals("down")) {
                    if (cy - length <= x) {
                        double i = cy - length;
                        fibra = (h + a + a) * i * ((i / 2) + length);
                    }
                } else if (position.equals("up")) {
                    if (cy + length >= x) {
                        double v = cy + length;
                        fibra = (v * a * ((v / 2) + length)) * 2;
                    }
                }
            }
        }

        return fibra;
    }
}
