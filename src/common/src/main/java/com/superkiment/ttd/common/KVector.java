package com.superkiment.ttd.common;

public class KVector {
    public double x, y, z;
    private boolean isMagToRecalculate = true;
    private double mag = 0;

    public KVector() {
        this(0, 0, 0);
    }

    public KVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public KVector(double x, double y) {
        this(x, y, 0);
    }

    public void add(KVector v) {
        x += v.x;
        y += v.y;
        z += v.z;
        this.isMagToRecalculate = true;
    }

    public void sub(KVector v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        this.isMagToRecalculate = true;
    }

    public void mult(KVector v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
        this.isMagToRecalculate = true;
    }

    public double mag() {
        if (this.isMagToRecalculate) {
            mag = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
            this.isMagToRecalculate = false;
        }

        return mag;
    }

    public static KVector add(KVector v1, KVector v2) {
        return new KVector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static KVector sub(KVector v1, KVector v2) {
        return new KVector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static KVector mult(KVector v1, KVector v2) {
        return new KVector(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
    }
}
