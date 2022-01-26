package com.example.cgeo.sections;

public class ISection implements Section {
    private final double w, h;
    private double area, perimeter, cy, cx, iz, iy, scgz, scgy, kz, ky, fibra;

    public ISection(double w, double h) {
        this.w = w;
        this.h = h;

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
        area = w * h;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter() {
        perimeter = 2 * w + 2 * h;
    }

    @Override
    public double getCy() {
        return cy;
    }

    public void setCy() {
        cy = h / 2;
    }

    @Override
    public double getCx() {
        return cx;
    }

    public void setCx() {
        cx = w / 2;
    }

    @Override
    public double getIz() {
        return iz;
    }

    public void setIz() {
        iz = (w * Math.pow(h, 3)) / 12;
    }

    @Override
    public double getIy() {
        return iy;
    }

    public void setIy() {
        iy = (h * Math.pow(w, 3)) / 12;
    }

    @Override
    public double getScgz() {
        return scgz;
    }

    public void setScgz() {
        scgz = (w * cy * (cy / 2));
    }

    @Override
    public double getScgy() {
        return scgy;
    }

    public void setScgy() {
        scgy = h * (w / 2) * (w / 4);
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

    public void setFibra(double length) {
        if (length <= h / 2) {
            fibra = ((cy - fibra) * w) * (((cy - fibra) / 2) + fibra);
        }
    }
}
