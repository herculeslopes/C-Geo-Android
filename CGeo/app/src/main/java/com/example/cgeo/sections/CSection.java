package com.example.cgeo.sections;

import java.lang.Math;

public class CSection implements Section {
    private final double b, h, a, m;
    private double area, perimeter, cy, cx, iz, iy, scgz, scgy, kz, ky;

    public CSection(double b, double h, double a, double m) {
        this.b = b;
        this.h = h;
        this.a = a;
        this.m = m;

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
        area = 2 * (a + m) * b + h * a;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter() {
        perimeter = 2 * (a + m) + 2 * (2 * b + h) + 2 * m;
    }

    @Override
    public double getCy() {
        return cy;
    }

    public void setCy() {
        double x = a + m;
        cy = ((b * x * (b / 2)) + h * a * (b + (h / 2)) + (b * x * (b + h + (b / 2)))) / h * a + b * x + b * x;
    }

    @Override
    public double getCx() {
        return cx;
    }

    public void setCx() {
        double x = a + m;
        cx = (b * x * (x / 2) + h * a * (a / 2) + b * x * (x / 2)) / h * a + b * x + b * x;
    }

    @Override
    public double getIz() {
        return iz;
    }

    public void setIz() {
        double x = a + m;
        iz = (
                ((x * Math.pow(b, 3) / 12) + (x * b * Math.pow((cy - (b / 2)), 2)))
        +
                ((a * Math.pow(h, 3) / 12) + (Math.pow(cy - ((h / 2) + b), 2) * (a * h)))
        +
                ((x * Math.pow(b, 3) / 12) + (x * b * (cy - Math.pow(((b / 2) + h + b), 2))))
        );
    }

    @Override
    public double getIy() {
        return iz;
    }

    public  void setIy() {
        iy = 2 * (
                (((b * Math.pow((m + a), 3)) / 12) + b * (m + a) * (Math.pow((cy - ((m + a) / 2)), 2)))
        +
                (h * Math.pow(a, 3) / 12 + h * a * (Math.pow((cy - (a / 2)), 2)))
        );
    }

    @Override
    public double getScgz() {
        return scgz;
    }

    public void setScgz() {
        if (cy >= 2 * b + h) {
            scgz = (2 * b + h - cy) * (a + m) * ((2 * b + h - cy) / 2);
        } else if (cy < h + b) {
            scgz = b * (a + m) * (cy - b / 2) + (cy - b) * a * ((cy - b) / 2);
        } else if (cy <= b) {
            scgz = cy * (a + m) * (cy / 2);
        }
    }

    @Override
    public double getScgy() {
        return scgy;
    }

    public void setScgy() {
        scgy = 0;
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

    public void setFibra() {

    }
}
