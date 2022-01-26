package com.example.cgeo.sections;

import java.lang.Math;

public class HSection implements Section {
    private final double x, y, a, d, h, r;
    private double area, perimeter, cy, cx, iz, iy, scgz, scgy, kz, ky, fibra;

    public HSection(double x, double y, double a, double d, double h, double r) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.d = d;
        this.h = h;
        this.r = r;

        setArea();
        setPerimeter();
        setCy();
        setCx();
        setIz();
        setIy();
        setScgz();
        setScgy();
        setKz();
        setKy();
    }

    @Override
    public double getArea() {
        return area;
    }

    public void setArea() {
        area = x * y + h * a + d * r;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter() {
        perimeter = 2 * d + 2 * y + r * x + 2 * h + (x - a) + (r * a);
    }

    @Override
    public double getCy() {
        return cy;
    }

    public void setCy() {
        cy = (
                ((a * r * (a / 2)) + (h * d * (a + (h / 2))) + (y * x * (a + h + (y / 2))))
                /
                ((a * r) + (d * h) + (y * x))
        );
    }

    @Override
    public double getCx() {
        return cx;
    }

    public void setCx() {
        if (x >= r) {
            cx = x / 2;
        } else if (x < r) {
            cx = r / 2;
        }
    }

    @Override
    public double getIz() {
        return iz;
    }

    public void setIz() {
        iz = (
            (((r * Math.pow(a, 3)) / (12)) + ((a * r * (Math.pow(cy - (a / 2), 2)))))
        +
            (((d * Math.pow(h, 3)) / 12) + (h * d * Math.pow(((h / 2) + a) - cy, 2)))
        +
            (((x * Math.pow(y, 3)) / 12) + (y * x * Math.pow((a + h + (y / 2)) - cy, 2)))
        );
    }

    @Override
    public double getIy() {
        return iy;
    }

    public void setIy() {
        iy = (d * Math.pow(r, 3)) / 12 + ((h * Math.pow(a, 3)) / 12) + ((y * Math.pow(x, 3))/ 12);
    }

    @Override
    public double getScgz() {
        return scgz;
    }

    public void setScgz() {
        if (cy >= y + h + d) {
            scgz = (y + h + d - cy) * x * ((y + h + d - cy) / 2);
        } else if (cy < h + d) {
            scgz = d * r * ((d / 2) + (cy - d)) + (cy - d) * a * ((cy - d) / 2);
        } else if (cy <= d) {
            scgz = cy * r * (cy / 2);
        }
    }

    @Override
    public double getScgy() {
        return scgy;
    }

    public void setScgy() {
        scgy = (r / 2) * d * (r / 4) + y * (x / 2) * (x / 4) + h * (a / 2) * (a / 4);
    }

    @Override
    public double getKz() {
        return kz;
    }

    public void setKz() {
        kz = Math.sqrt(iz / area);
    }

    @Override
    public double getKy() {
        return ky;
    }

    public void setKy() {
        ky = Math.sqrt(iy / area);
    }

    public void setFibra(double length, String position) {
        if ((position.equals("up") && (cy + length <= y + d + h)) || ((position.equals("down")) && (cy - length >= 0))) {
            if (cy >= h + d) {
                if (position.equals("up")) {
                    if ((cy + length) < (y + d + h)) {
                        double i = ((cy + length) - (y + h + d));
                        fibra = i * x * ((i/2) + length);
                    }
                } else if (position.equals("down")) {
                    if ((cy - length) <= (d + h) && (cy - length) > d) {
                        double i = ( d + h) - (cy - length);
                        fibra = ((i * a * ((i / 2) + length)) + (d * r * ((d / 2) + i + length)));
                    } else if (cy - length <= d) {
                        double u = (cy - length);
                        fibra = u * r * ((u / 2) + length);
                    } else if (cy - length > d + h) {
                        double u = (cy - length) - (h + d);
                        fibra = (u * x * ((u / 2 ) + length)) + (h * a * ((h / 2) + u + length)) + d * r * ((d / 2) + h + u + length);
                    }
                }
            } else if ((cy > d) && (cy <= d + h)) {
                if (position.equals("up")) {
                    if (cy + length >= d + h) {
                        double i = ( d + h + y) - (cy + length);
                        fibra = i * x * ((i / 2) + length);
                    } else if ((cy + length) <= (d + h) && (cy + length) >= d) {
                        double i = (d + h) - (cy + length);
                        fibra = (y * x * ((y / 2) + i + length)) + (i * a * ((i / 2) + length));
                    }
                } else if (position.equals("down")) {
                    if (cy - length > d) {
                        double v = (d + h) - (cy - length);
                        fibra = (v * a * ((v / 2) + length)) + (d * r * ((d / 2) + length));
                    } else if (cy - length <= d) {
                        double v = (cy - length);
                        fibra = v * r * ((v / 2) + length);
                    }
                }
            } else if (cy <= d) {
                if (position.equals("down")) {
                    if (cy - length <= d) {
                        double g = (cy - length);
                        fibra = g * r * ((g / 2)+ length);
                    }
                } else if (position.equals("up")) {
                    if (cy + length >= d + h) {
                        double i = (d + h + length) - (cy + length);
                        fibra = (i * x * ((i / 2)+ length));
                    } else if (cy + length >= d) {
                        double m = (h + d) - (cy + length);
                        fibra = y * x * ((y / 2) + length);
                    } else if (cy + length < d) {
                        double m = (d) - (cy + length);
                        fibra = (y * x * ((y / 2) + h + m + length)) + (h * a * ((h / 2) + m + length)) + (m * r * ((m / 2) + length));
                    }
                }
            }
        }
    }
}
