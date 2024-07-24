package code;


//interface Shape{ 
//	
//	float getArea();
//	float getPerimeter();
//	
//}

abstract class Shape{
	
	int sides;
	abstract float getArea();
	abstract float getPerimeter();
	
	public void setSides() {
		
		sides = 4;
		
	}
}

public class Circle extends Shape{
	
	int radius = 4;

	@Override
	public float getArea() {
		return (float) (3.14*radius*radius);
	}

	@Override
	public float getPerimeter() {
		return (float) (2*3.14*radius);
	}
	
	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c.getArea());
		System.out.println(c.getPerimeter());
		
		Rectangle r = new Rectangle();
		
		System.out.println(r.getArea());
		System.out.println(r.getPerimeter());
	}
	
	

}


class Rectangle extends Shape{
	int length = 4;
	int breadth = 5;
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return (float) length*breadth;
	}

	@Override
	public float getPerimeter() {
		// TODO Auto-generated method stub
		return (float) (2*(length+breadth));
	}
	
	
}
