package peilingli.com;

import java.util.Arrays;

public class Triangle {
	public Triangle (int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean IsTriangle() {
		if (a >= b + c) {
			return false;
		}
		
		if (b >= a + c) {
			return false;
		}
		
		if (c >= b + a) {
			return false;
		}
		
		return true;
	}
	
	public String EdgesIsInRange() {
		if (a > 100 || a < 1) {
			return "a";
		} 
		
		if (b > 100 || b < 1) {
			return "b";
		}
		
		if (c > 100 || c < 1) {
			return "c";
		}
		
		return "";
	}
	
	public boolean IsRegular() {
		return (a == b && b == c);
	}
	
	public boolean IsIsoceles() {
		return (a == b && a != c) ||
				(a == c && a != b) ||
				(b == c && a != b);
	}
	
	public boolean IsRect() {
		int [] edges = {a, b, c};
		Arrays.sort(edges);
		return edges[0] * edges[0] + edges[1] * edges[1] == edges[2] * edges[2];	
	}
	
	public String CheckTriangle() {
		String whichNotInRanger = EdgesIsInRange();
		if (false == whichNotInRanger.isEmpty()) {
			return whichNotInRanger + "的取值不在允许范围之内";
		}
		
		if (false == IsTriangle()) {
			return "非三角形";
		}
		
		if (true == IsRegular()) {
			return "等边三角形";
		} else if (true == IsIsoceles()) {
			return "等腰三角形";
		} else if (true == IsRect()) {
			return "直角三角形";
		} else {
			return "一般三角形";
		}
	}
	
	private int a = 10, b = 10, c = 10;
}

