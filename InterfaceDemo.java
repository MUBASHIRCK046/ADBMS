import java.util.Scanner;

// =========================================================================
// PART A: ARCHITECTURE DEFINITION
// =========================================================================

// Interface
interface Shape {
    double area();
    double perimeter();
}

// Circle class
class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = Math.abs(radius);
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class
class Rectangle implements Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = Math.abs(length);
        this.width = Math.abs(width);
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}

// =========================================================================
// PART B: EXECUTION LOGIC
// =========================================================================

public class InterfaceDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Polymorphic reference
        Shape currentShape = null;

        while (true) {

            System.out.println("\n--- Shape Calculator ---");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Execution terminated.");
                break;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    currentShape = new Circle(r);   // Upcasting
                    break;

                case 2:
                    System.out.print("Enter length and width: ");
                    double l = sc.nextDouble();
                    double w = sc.nextDouble();
                    currentShape = new Rectangle(l, w);   // Upcasting
                    break;

                default:
                    System.out.println("Invalid selection. Try again.");
                    continue;
            }

            // Dynamic method dispatch
            System.out.printf("Area: %.2f\n", currentShape.area());
            System.out.printf("Perimeter: %.2f\n", currentShape.perimeter());
        }

        sc.close();
    }
}
