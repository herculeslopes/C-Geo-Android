package com.example.cgeo.sections;

public class USection implements Section {
    private final double x, y, a, h;
    private double area, perimeter, cy, cx, j, iz, iy, scgz, scgy, kz, ky;
    
    public USection(double x, double y, double a, double h) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.h = h;

        setArea();
        setPerimeter();
        setCy();
        setCx();
        setJ();
        setIz();
        setIy();
        setScgz();
        setScgy();
        setKz();
        setKy();
    }

    @Override public double getArea() {
        return area;
    }

    public void setArea() {
        area = 2 * a * y + x * h;
    }

    @Override public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter() {
        perimeter = 2 * y + 2 * (2 * a + h) + 2 * (y - x);
    }

    @Override public double getCy() {
        return cy;
    }

    public void setCy() {
        cy = (
                ((2 * (a * y * (y / 2))) + (h * x * (x / 2)))
                        /
                        ((2 * (a * y)) + (x * h))
        );
    }

    @Override public double getCx() {
        return cx;
    }

    public void setCx() {
        cx = (h + 2 * a) / 2;
    }

    public double getJ() {
        return j;
    }

    public void setJ() {
        j = h + (2 * a) - cx;
    }

    @Override public double getIz() {
        return iz;
    }

    public void setIz() {
        iz = (
                (2 * (((a * Math.pow(y, 3)) / (12)) + ((y * a * Math.pow(((y / 2) - cy), 2)))))
                        +
                        ((((h) * Math.pow(x, 3)) / (12)) + (x * h * (Math.pow((cy - (x / 2)), 2))))
        );
    }

    @Override public double getIy() {
        return iy;
    }

    public void setIy() {
        double g = y - x;
        iy = (x * Math.pow(cx, 3)) / 12 + cx * x * Math.pow((cx / 2), 2) + (g * Math.pow(a, 3)) + (g * a * Math.pow((cx - (a / 2)), 2));
    }

    @Override public double getScgz() {
        return scgz;
    }

    public void setScgz() {
        double v = y - x;
        if (cy <= x) {
            scgz = cy * (a + h + a) * (cy / 2);
        } else {
            scgz = ((y - cy) * a * ((v - cy) / 2)) * 2;
        }
    }

    @Override public double getScgy() {
        return scgy;
    }

    public void setScgy() {
        double g = y - x;
        scgy = (j * x * (j / 2)) + (g * a * (j * (a / 2)));
    }

    @Override public double getKz() {
        return kz;
    }

    public void setKz() {
        kz = Math.sqrt(iz / area);
    }

    @Override public double getKy() {
        return ky;
    }

    public void setKy() {
        ky = Math.sqrt(iy / area);
    }

    public static double setFibra(double x, double y, double a, double h, double cy, double length, String position) {
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
