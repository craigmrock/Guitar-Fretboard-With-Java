
public class Guitar
{
	private int [] majorScalePattern = {2, 2, 1, 2, 2, 2, 1, 2};
	private int [] minorScalePattern = {2, 1, 2, 2, 1, 2, 2, 2};
	private String [] cMajorScale = {"C", "D", "E", "F", "G", "A", "B", "C"};
	private String [] aMinorScale = {"A", "B", "C", "D", "E", "F", "G", "A"};
	private Fretboard fretboard; //has-a relationship to the Fretboard class
	
	
	
	
	public Guitar()
	{
		
		fretboard = new Fretboard();
	}
	
	public void playScale()
	{
		fretboard.printFretboard(buildMajorScale(Scales.MAJORC));
	}
	
	public String [] buildMajorScale(String rootNote)
	{
		String [] scale = new String [8];
		for (int x = 0; x < fretboard.getFretboard().length; x++ )
		{

			if(fretboard.getFretboard()[x][0].equalsIgnoreCase(rootNote))
			{
				                                   
				int noteIndex = x;
				scale[0] = rootNote;
				noteIndex += 2;
				scale[1] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[2] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 1;
				scale[3] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[4] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[5] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[6] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 1;
				scale[7] = fretboard.getFretboard()[noteIndex][0];
				break;
			}
		}
		return scale;
	}
	
	public String [] buildMinorScale(String rootNote)
	{
		String [] scale = new String [8];
		for (int x = 0; x < fretboard.getFretboard().length; x++ )
		{
			
			if(fretboard.getFretboard()[x][0].equalsIgnoreCase(rootNote))
			{
				                                  
				int noteIndex = x;
				scale[0] = rootNote;
				noteIndex += 2;
				scale[1] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 1;
				scale[2] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[3] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[4] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 1;
				scale[5] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[6] = fretboard.getFretboard()[noteIndex][0];
				noteIndex += 2;
				scale[7] = fretboard.getFretboard()[noteIndex][0];
				break;
			}
		}
		return scale;
	}
	
	public String [] playMajorScaleString1() //This method returns location of selected scale
	{
		String[] result = new String [8];
		int fretStart = 8;
		int stringIndex = 0; 
		int noteCount = 0;
		int fretIndex= fretStart;
		
		for(int scaleIndex = 0; scaleIndex < result.length; scaleIndex++)
		{
			System.out.println(fretIndex);
			result [noteCount++] = fretboard.getFretboard() [fretIndex][stringIndex];
			fretIndex += majorScalePattern[scaleIndex];
			
	    } 
		
		return result;
	}
	
	public String [] playMajorScaleString2() //This method returns location of selected scale
	{
		String[] result = new String [8];
		int fretStart = 3; //change starting position
		int stringIndex = 1; //change string
		int noteCount = 0;
		int fretIndex= fretStart;
		
		for(int scaleIndex = 0; scaleIndex < result.length; scaleIndex++)
		{
			System.out.println(fretIndex);
			result [noteCount++] = fretboard.getFretboard() [fretIndex][stringIndex];
			fretIndex += majorScalePattern[scaleIndex];
			
	        
	    } 
		
		return result;
	}
	
	private int determineRootNote(int stringNumber)//This method uses the rootNote to determine which scale to display
	{
		String rootNote = cMajorScale[0];//this needs to be able to find any element 
		int startingFret = 0;
		for (int fretIndex = 0; fretIndex < 12; fretIndex++)
		{
			if(rootNote.equals(fretboard.getFretboard()[fretIndex][stringNumber]))
			{
				startingFret = fretIndex;
				break;
			}
		}
		return startingFret;
	}
	
	public String [] playMajorScale(int stringNumber) //This method returns location of selected scale on the guitar string
	{
		String[] result = new String [8];
		int fretStart = determineRootNote(stringNumber); //change starting position
		int stringIndex = stringNumber; //change string
		int noteCount = 0;
		int fretIndex= fretStart;
		
		for(int scaleIndex = 0; scaleIndex < result.length; scaleIndex++)
		{
			System.out.println(fretIndex);
			result [noteCount++] = fretboard.getFretboard() [fretIndex][stringIndex];
			fretIndex += majorScalePattern[scaleIndex];
				        
	    } 
		
		return result;
	}
	
	public String [] playMinorScale(int stringNumber) //This method returns location of selected scale on the guitar string
	{
		String[] result = new String [8];
		int fretStart = determineRootNote(stringNumber); //change starting position
		int stringIndex = stringNumber; //change string
		int noteCount = 0;
		int fretIndex= fretStart;
		
		for(int scaleIndex = 0; scaleIndex < result.length; scaleIndex++)
		{
			System.out.println(fretIndex);
			result [noteCount++] = fretboard.getFretboard() [fretIndex][stringIndex];
			fretIndex += minorScalePattern[scaleIndex];
				        
	    } 
		
		return result;
	}

}
