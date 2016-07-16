package algorithms.geometric;

/**
 * Check if a point lies inside or outside of a triangle.
 * @author Joy Ghosh
 * @version 1.0
 * @since 1.0
 */
public class PointInTriangle {

	class Point{
		double x;
		double y;
		
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		
		PointInTriangle pit = new PointInTriangle();
		PointInTriangle.Point a = pit.new Point(0.0,0.0);
		PointInTriangle.Point b = pit.new Point(10.0,30.0);
		PointInTriangle.Point c = pit.new Point(20.0,0.0);
		PointInTriangle.Point p = pit.new Point(10.0,15.0);
		PointInTriangle.Point _p = pit.new Point(25.0,15.0);
		
		System.out.println("p lies "+((pit.isInsideTriangle(a, b, c, p) == true)?"inside":"outside")+" the triangle");
		System.out.println("_p lies "+((pit.isInsideTriangle(a, b, c, _p) == true)?"inside":"outside")+" the triangle");
	}
	
	/**
	 * Check if a given point p lies inside of a triangle.
	 * @param a
	 * @param b
	 * @param c
	 * @param p
	 * @return
	 */
	private boolean isInsideTriangle(Point a, Point b, Point c, Point p){
		
		double area = areaOfTriangle(a,b,c);
		double area1 = areaOfTriangle(a,b,p);
		double area2 = areaOfTriangle(a,c,p);
		double area3 = areaOfTriangle(c,b,p);
		
		return (area == (area1 + area2 + area3));
	}
	
	/**
	 * Area of a triangle given three vertices.
	 * Time-complexity: O(1)
	 * Space-complexity: O(1)
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	private double areaOfTriangle(Point p1, Point p2, Point p3){
		return  Math.abs((p1.x*(p2.y - p3.y)+ p2.x*(p3.y-p1.y) +p3.x*(p1.y-p2.y))/2.0);
	}
}
