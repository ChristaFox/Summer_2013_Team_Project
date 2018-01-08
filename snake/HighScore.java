package snake;

import java.io.Serializable;

public class HighScore implements Serializable, Comparable<HighScore>
{
	private static final long	serialVersionUID	= -2559411896953802839L;
	private final String		name;
	private final int			apples;
	private final int			points;
	
	public HighScore( String name, int apples, int score ) {
		
		this.name = name;
		this.apples = apples;
		this.points = score;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the number of apples
	 */
	public int getApples()
	{
		return apples;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		
		return points;
	}
	
	@Override
	public String toString() {
		
		return String.format( "HighScore[Name:%s, Apples:%d, Score:%d]",
				getName(), getApples(), getPoints() );
	}

	@Override
	public int compareTo( HighScore obj ) {
		
		if ( this.equals( obj ) )
			return 0;
		if ( obj instanceof HighScore )
			return ( (HighScore) obj ).getPoints() - this.getPoints();	
		return 0;
	}
}
