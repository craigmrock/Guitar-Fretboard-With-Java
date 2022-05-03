
public class Fretboard
{
	private String [][] guitarFretboard = 
			{{"E", "A", "D", "G", "B", "E"},//open string, low to high (thickest string to thinnest string)
			{"F", "A#/Bb", "D#/Eb", "G#/Ab", "C", "F"},//1st fret
			{"F#/Gb", "B", "E", "A", "C#/Db", "F#/Gb"},//2nd fret
			{"G", "C", "F", "A#/Bb", "D", "G"},//3rd fret
			{"G#/Ab", "C#/Db", "F#/Gb", "B", "D#/Eb", "G#/Ab"},//4th fret
			{"A", "D", "G", "C", "E", "A"},//5th fret
			{"A#/Bb", "D#/Eb", "G#/Ab", "C#/Db", "F", "A#/Bb"},//6th fret
			{"B", "E", "A", "D", "F#/Gb", "B"},//7th fret
			{"C", "F", "A#/Bb", "D#/Eb", "G", "C"},//8th fret
			{"C#/Db", "F#/Gb", "B", "E", "G#/Ab", "C#/Db"},//9th fret
			{"D", "G", "C", "F", "A", "D"},//10th fret
			{"D#/Eb", "G#/Ab", "C#/Db", "F#/Gb", "A#/Bb", "D#/Eb"},//11th fret
			{"E", "A", "D", "G", "B", "E"},//12th fret
			{"F", "A#/Bb", "D#/Eb", "G#/Ab", "C", "F"},//13th fret
			{"F#/Gb", "B", "E", "A", "C#/Db", "F#/Gb"},//14th fret
			{"G", "C", "F", "A#/Bb", "D", "G"},//15th fret
			{"G#/Ab", "C#/Db", "F#/Gb", "B", "D#/Eb", "G#/Ab"},//16th fret
			{"A", "D", "G", "C", "E", "A"},//17th fret
			{"A#/Bb", "D#/Eb", "G#/Ab", "C#/Db", "F", "A#/Bb"},//18th fret
			{"B", "E", "A", "D", "F#/Gb", "B"},//19th fret
			{"C", "F", "A#/Bb", "D#/Eb", "G", "C"},//20th fret
			{"C#/Db", "F#/Gb", "B", "E", "G#/Ab", "C#/Db"},//21st fret
			{"D", "G", "C", "F", "A", "D"},//22nd fret
			{"D#/Eb", "G#/Ab", "C#/Db", "F#/Gb", "A#/Bb", "D#/Eb"},//23rd fret
			{"E", "A", "D", "G", "B", "E"}};//24th fret
	//I made this 24 frets so the display would show the entire fretboard.
	//Lots of guitarists only memorize the top 12 frets. This helps them see the full fretboard.
	public void voidTest()
	{
		System.out.println(guitarFretboard[0][5]); //test to determine fret number and string number. This series produces E, F, F#/Gb on the high E string
		System.out.println(guitarFretboard[1][5]);
		System.out.println(guitarFretboard[2][5]);
	}
	
	public void printFretboard(String [] scale)
	{
		int rowCount, dashCount;
		int fretLength = 6;
		int fret;
		int guitarString = 6;
		
		String strings [] = {"E","B","G","D","A","E"};
		
	 
        for (rowCount = 0; rowCount < 7; rowCount++) //produce 6 strings
        {
        	int counter = 1;
        	int fretCounter = 1; //positions the fret marker above the fretboard
        	fret = 0;
        	for (dashCount = 0; dashCount < 150; dashCount++) //create 6 dashes and repeat. 150 gives you the whole 24 fret fretboard.
        	{
        		if (rowCount == 0)
        		{
        			if (dashCount == 0)
            		{
            			System.out.print("  |");
            		}
        			else if (dashCount == fretCounter * fretLength - 3) //adds the number reference above each fret up to the 9th fret
        			{
        				System.out.print(fretCounter - 1); //
        				fretCounter ++;
        				
        			}
        			else if (dashCount == fretCounter * fretLength - 4 && fretCounter > 10) //needed another to accommodate 2-digit frets and their distance.
        			{
        				
        			}
        			else
        			{
        				System.out.print(" ");
        			}
        			
        		}
        		else
        		{
        			if (dashCount == 0)
            		{
            			System.out.print(strings[rowCount -1] + " |"); //creates beginning string reference at the left side of the printout.
            		}
        			else if (dashCount == counter * fretLength) //creates frets dashes apart
        			{
        				System.out.print("|");
        				counter++;
        				fret++;
        			}
        			
        			
        			
        			else
        			{
        				if(isNoteInScale(scale,guitarFretboard[fret][guitarString]))
        				{
        					if (dashCount == (fret +1) * fretLength - 3)
            				{
        						if (isRootNote(scale, guitarFretboard[fret][guitarString]))
        						{
        							System.out.print("O");
        						}
        						else
        						{
        							System.out.print("x");
        						}
            				}
        					else
        					{
        						System.out.print("-");
        					}
        				
        				}
        				else
        				{
        					System.out.print("-");
        				}
        				
        				
        			}
        		
        			
        		}
        		
        	}
        	System.out.print("|");
        	System.out.println(); //creates a break after each string and actually creates 6 strings
        	guitarString --;
        }
        
        
	}
	private boolean isRootNote(String [] scale, String note)
	{
		return note.equalsIgnoreCase(scale[0]);
	}
	
	private boolean isNoteInScale(String [] scale, String note)
	{
		boolean isIn = false;
		for (String n : scale)
		{
			isIn = n.equalsIgnoreCase(note);
			if (isIn)
			{
				break;
			}
		}
		return isIn;
	
	}
	public String [][] getFretboard()
	{
		return guitarFretboard;
	}

}
