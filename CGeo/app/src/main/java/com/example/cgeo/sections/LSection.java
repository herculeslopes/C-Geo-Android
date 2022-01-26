package com.example.cgeo.sections;

public class LSection implements Section {
    private final double y, k, x, u;
    private double area, perimeter, cy, cx, iz, iy, scgz, scgy, kz, ky;

    public LSection(double y, double k, double x, double u) {
        this.y = y;
        this.k = k;
        this.x = x;
        this.u = u;

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
        area = x * u + k * y;
    }

    @Override public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter() {
        perimeter = 2 * u + 2 * x + 2 * k;
    }

    @Override public double getCy() {
        return cy;
    }

    public void setCy() {
        cy = ((x * u * (x / 2)) + (k * y * ((k / 2) + x))) / (x * u + k * y);
    }

    @Override public double getCx() {
        return cx;
    }

    public void setCx() {
        cx = ((y * k * (y / 2)) + (x * u * (u / 2))) / (x * u + y * k);
    }

    @Override public double getIz() {
        return iz;
    }

    public void setIz() {
        double t = x + (k / 2);
        double h = (x / 2);
        iz = (
                ((y * Math.pow(k, 3)) / 12 + y * k * Math.pow((t - cy), 2))
                +
                ((u * Math.pow(x, 3) / 12) + u * x * Math.pow((cy - h), 2))
        );
    }

    @Override public double getIy() {
        return iy;
    }

    public void setIy() {
        iy = (
                (
                        ((k * Math.pow(y, 3)) / 12) + (y * k * Math.pow((cx - (y / 2)), 2))
                )
                        +
                (
                        ((x * (Math.pow(u, 3))) / 12) + (u * x * (Math.pow((cx - (u / 2)), 2)))
                )
        );
    }

    @Override public double getScgz() {
        return scgz;
    }

    public void setScgz() {
        double a = k + x;
        if (cy >= x) {
            scgz = (a - cy) * y * ((a - cy) / 2);
        } else {
            scgz = cy * u * (cy / 2);
        }
    }

    @Override public double getScgy() {
        return scgy;
    }

    public void setScgy() {
        if (x >= y) {
            scgy = x * (u - cx) * (u - cx / 2);
        } else {
            scgy =  cx * k * (cx / 2);
        }
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
}
