package com.example.cgeo.sections;

public class TSection implements Section {
    private final double x, b, y, z;
    private double area, perimeter, cy, cx, iz, iy, scgz, scgy, kz, ky;

    public TSection(double x, double b, double y, double z) {
        this.x = x;
        this.b = b;
        this.y = y;
        this.z = z;

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

    @Override public double getArea() {
        return area;
    }
    
    public void setArea() {
        area = x * b + y * z;
    }

    @Override public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter() {
        perimeter = z + 2 * y + 2 * b + x + x - z;
    }

    @Override public double getCy() {
        return cy;
    }

    public void setCy() {
        cy = (z * y * (y / 2) + b * x * (y + (b / 2))) / (z * y + b * x);
    }

    @Override public double getCx() {
        return cx;
    }

    public void setCx() {
        cx = x / 2;
    }

    @Override public double getIz() {
        return iz;
    }

    public void setIz() {
        iz = (
                (((x * (Math.pow(b, 3))) / (12) ) + (b * x * Math.pow(((y + (b / 2) - cy)), 2)))
                        +
                        (((z * Math.pow(y, 3)) / (12)) + (y * z * (Math.pow(cy - (y / 2), 2))))
        );
    }

    @Override public double getIy() {
        return iy;
    }

    public void setIy() {
        iy = ((y * Math.pow(z, 3)) / 12) + ((b * Math.pow(x, 3)) / 12);
    }

    @Override public double getScgz() {
        return scgz;
    }

    public void setScgz() {
        if (cy == y) {
            scgz = y * z * (y / 2);
        } else if (cy < y) {
            scgz = cy * z * (cy / 2);
        } else {
            scgz = (b + y - cy) * x * ((b + y - cy) / 2);
        }
    }

    @Override public double getScgy() {
        return scgy;
    }

    public void setScgy() {
        scgy = (z / 2) * y * (z / 4) + (x / 2) * b * (x / 4);
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

    public double setFibra(double length, String position) {
        double fibra = -1;
        if ((position.equals("up") && (cy + length <= y + b)) || ((position.equals("down") && (cy - length >= 0)))) {
            if (cy > y) {
                if (position.equals("down")) {
                    if (cy - length < y) {
                        double h = cy - length;
                        fibra = h * z * ((h / 2) + length);
                    } else if (cy - length > y) {
                        double d = cy - length - y;
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
                        fibra = (b * x * ((b / 2) + (fibra + i))) + (i * z * ((i / 2) + fibra));
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
