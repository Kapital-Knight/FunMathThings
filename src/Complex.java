public class Complex implements Cloneable, Comparable<Complex>{
    private double a;
    private double b;

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public Complex(double a) {
        this.a = a;
        this.b = 0;
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex add(Complex other) {
        return new Complex(
                this.a + other.a,
                this.b + other.b);
    }

    public Complex subtract(Complex other) {
        return new Complex(
                this.a - other.a,
                this.b - other.b);
    }

    public Complex multiply(Complex other) {
        return new Complex(
                this.a * other.a - this.b * other.b,
                this.a * other.b + this.b * other.a);
    }

    public Complex divide(Complex other) {
        double denominator = other.a * other.a + other.b * other.b;
        return new Complex(
                (this.a * other.a + this.b * other.b) / denominator,
                (this.a * other.b - this.b * other.a) / denominator);
    }

    public double abs () {
        return Math.sqrt(a*a + b*b);
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    @Override
    public int compareTo(Complex o) {
        return (int)(this.abs() - ((Complex)o).abs());
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format(a + "+ " + b + "i");
    }
}
