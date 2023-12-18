public class Triangle {

    public double side1;
    public double side2;
    public double side3;
    public double halfPerimeter;

    public Triangle (double side1, double side2, double side3) {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.halfPerimeter = perimeter() / 2;

    }

  public double perimeter () {
      return this.side1 + this.side2 + this.side3;
  }

  public double square () {
      return Math.sqrt(this.halfPerimeter * (this.halfPerimeter - this.side1) * (this.halfPerimeter - this.side2) * (this.halfPerimeter - this.side3));
  }
}





