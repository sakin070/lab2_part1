
public class PointCP2 {
	
	/**
	   * Contains C(artesian) or P(olar) to identify the type of
	   * coordinates that are being dealt with.
	   */
	  private char typeCoord;
	  
	  /**
	   * Contains the current value of X or RHO depending on the type
	   * of coordinates.
	   */
	  private double Rho;
	  
	  /**
	   * Contains the current value of Y or THETA value depending on the
	   * type of coordinates.
	   */
	  private double Theta;
		
	  
	  //Constructors ******************************************************

	  /**
	   * Constructs a coordinate object, with a type identifier.
	   */
	  
	  public PointCP2(char type, double Rho, double Theta)
	  {
	    if(type != 'C' && type != 'P')
	      throw new IllegalArgumentException();
	    
	    if(type=='C')
	    	Rho=(Math.sqrt(Math.pow(Rho, 2) + Math.pow(Theta, 2)));
	    	Theta=Math.toDegrees(Math.atan2(Theta, Rho));
	    	
	    if(type=='P')
	    	this.Rho = Rho;
	    	this.Theta = Theta;	    	
	    	
	    typeCoord = 'P';
	  }
	  public double getX()
	  {
	      return (Math.cos(Math.toRadians(Theta)) * Rho);
	  }
	  
	  public double getY()
	  {
	      return (Math.sin(Math.toRadians(Theta)) * Rho);
	  }
	  
	  public double getRho()
	  {
	      return Rho;

	  }
	  
	  public double getTheta() {
	      return Theta;
	  }
	  /**
	   * Calculates the distance in between two points using the Pythagorean
	   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	   *
	   * @param pointA The first point.
	   * @param pointB The second point.
	   * @return The distance between the two points.
	   */
	  public double getDistance(PointCP pointB)
	  {
	    // Obtain differences in X and Y, sign is not important as these values
	    // will be squared later.
	    double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	  }

	  /**
	   * Rotates the specified point by the specified number of degrees.
	   * Not required until E2.30
	   *
	   * @param point The point to rotate
	   * @param rotation The number of degrees to rotate the point.
	   * @return The rotated image of the original point.
	   */
	  public PointCP rotatePoint(double rotation)
	  {
	    double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointCP('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	  }

	  /**
	   * Returns information about the coordinates.
	   *
	   * @return A String containing information about the coordinates.
	   */
	  public String toString()
	  {
	    return "Stored as " + "Polar [" + getRho() + "," + getTheta() + "]" + "\n";
	  }
}
