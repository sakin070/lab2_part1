package lab2;

public class PointCPThree {
	//private char typeCoord;
	private double x;
	private double y;
	 public PointCPThree(char type, double xOrRho, double yOrTheta){
	    if(type != 'C' && type != 'P')
	      throw new IllegalArgumentException();
	    if (type == 'P') {
		    	this.x = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
		    	this.y = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
	    	
	    }
	    else {
		    	this.x = xOrRho;
		    	this.y = yOrTheta;
	    }
	    
	    //typeCoord = type;
	    
	    
	  }
	 
	 public double getX() {
		 return x;
	 }
	 public double getY() {
		 return y;
	 }
	 public double getRho() {
		 return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	 }
	 public double getTheta() {
		 return Math.toDegrees(Math.atan2(y, x));
	 }
	 public double getDistance(PointCPThree pointB)
	  {
	    // Obtain differences in X and Y, sign is not important as these values
	    // will be squared later.
	    double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	  }
	 public String toString(){
	    return "Stored as "+ "Cartesian  (" + getX() + "," + getY() + ")" +"\n";
	  }
}
