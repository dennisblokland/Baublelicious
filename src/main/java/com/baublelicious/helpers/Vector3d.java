package com.baublelicious.helpers;

public class Vector3d {
  public double x, y, z;

  public Vector3d(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Vector3d sub(Vector3d vec) {
    return new Vector3d(x - vec.x, y - vec.y, z - vec.z);
  }

  public double magnitude() {
    return Math.sqrt(x * x + y * y + z * z);
  }

  public Vector3d normalise() {
    double d = this.magnitude();
    if (d != 0.0D) {
      multiply(1.0D / d);
    }
    return this;
  }

  private Vector3d multiply(double d) {
    x *= d;
    y *= d;
    z *= d;
    return this;
  }
}
