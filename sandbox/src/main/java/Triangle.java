import org.example.MyException;

public class Triangle {

    public double side1;
    public double side2;
    public double side3;
    public double halfPerimeter;

    public Triangle (double side1, double side2, double side3) throws MyException {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.halfPerimeter = perimeter() / 2;

        if (this.side1 <= 0 || this.side2 <= 0 || this.side3 <= 0) {
            throw new MyException("Triangle can not have negative sides!");}

        if (this.side1 + this.side2 <= this.side3 || this.side2 + this.side3 <= this.side1 || this.side1 + this.side2 <= this.side2) {
            throw new MyException("Triangle is impossible to have such sides!");}
    }

    public double perimeter () {
      return this.side1 + this.side2 + this.side3;
    }

  public double square () {
      return Math.sqrt(this.halfPerimeter * (this.halfPerimeter - this.side1) * (this.halfPerimeter - this.side2) * (this.halfPerimeter - this.side3));
  }
}







