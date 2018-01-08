package snake;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class HighScoresList
{
	File filePath = new File( "/Users/Starfox/Desktop/CSIS 1410 eclipse workspace/TeamProject/HighScores.ser" );
	List<HighScore> highScores = new ArrayList<>();
	
	/**
	 * The constructor tries deserialize.
	 * If it is unable to, it resets the list and serializes.
	 */
	public HighScoresList()
	{
		try {
			deserialize();
		} catch ( IOException | ClassNotFoundException ex ) {
			System.out.println( "Resetting High Scores List to default list" );
			resetHighScores();
			serialize();
		}
	}

	/**
	 * returns the HighScore object at the specified index
	 */
	public HighScore get( int index ) 
	{	
		return highScores.get( index );
	}
	
	/**
	 * Serializes highScores to disk
	 */
	public void serialize() {
		
		try( ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( filePath ) ) ) {
			out.writeObject( highScores );
		 } catch( IOException ex ) {
			 System.out.println( "A problem occurred during serialization" );
			 System.out.println( ex.getMessage() );
		 }
	}
	
	/**
	 * Writes highScores to a .csv file
	 */
	public void writeCsvFile()
	{
		try( PrintWriter writer = new PrintWriter( "HighScores.csv" ) )
		{
			for( HighScore el: highScores )
			{
				writer.printf( "%s,%d,%d%n", el.getName(), el.getApples(), el.getPoints() );
			}
		} catch ( FileNotFoundException e )
		{
			System.out.println( e.getMessage() );
		}
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Deserializes highScores from file
	 */
	public void deserialize() throws IOException, ClassNotFoundException {
		
		try ( ObjectInputStream in = new ObjectInputStream( new FileInputStream( filePath ) ) ) {
			highScores = ( List<HighScore>) in.readObject();
		} catch ( IOException | ClassNotFoundException ex ) {
			System.out.println( "A problem occurred during deserialization" );
			System.out.println( ex.getMessage() );
			throw ex;
		}
	}
	
	/**
	 * resets the highScores to a default list
	 */
	public void resetHighScores()
	{		
		int avePntsPerApple = 70;
		
		String[] names = {
				"John Doe",
				"Julia Webster",
				"Michael Thomas",
				"Melinda Green",
				"Ben Smith",
				"Adele",
				"Holly",
				"Matt",
				"Christa",
				"David", };
		
		highScores.clear();
		
		for( int index = 0; index < 10; index++ )
		{
			int apples = ( index + 1 ) * ( index + 1 );
			highScores.add( new HighScore( names[index], apples, apples * avePntsPerApple ) );
		}
		
		sort();
		serialize();		
	}
	
	/**
	 * returns true if the passed score is higher than the lowest high score
	 */
	public boolean newHighScore( int score )
	{		
		sort();
		if ( score > highScores.get( 9 ).getPoints() )
			return true;
		else return false;
	}

	/**
	 * Displays a dialog box that tells the user that they got a new High Score,
	 * and how many apples and points they got. Prompts them to enter their name.
	 * adds a new HighScore to highScores, sorts the list, and removes the lowest HighScore
	 */
	public void enterNewHighScore( int applesCollected, int score ) 
	{
		String name = JOptionPane.showInputDialog( null, String.format(
				"You got a new High Score\n" +
				"%d apples\n" +
				"%d points\n" +
				"Enter your name:", applesCollected, score ), 
				"Congratulations!", JOptionPane.PLAIN_MESSAGE );
		
		if ( name != null ) {
			name = name.trim();
			if ( name.length() > 20 )
				name = name.substring( 0, 20 );
		} else name = "";
			
		highScores.add( new HighScore( name, applesCollected, score ) );
		sort();
		highScores.remove( 10 );
	}
	
	@Override
	public String toString()
	{		
		StringBuilder sb = new StringBuilder( "" );
		for ( HighScore el : highScores )
			sb.append( el.toString() + "\n" );
		return sb.toString();
	}

	/**
	 * Sorts highScores
	 */
	private void sort()
	{	
		Collections.sort( highScores );
	}
	
}
