import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
import java.util.Date;
import java.util.Random;

class ProjectLogs {
	private static final String FILENAME= "/var/log/iis.log";
	
	String pattern = "00";
	DecimalFormat fmt = new DecimalFormat(pattern);
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

	public static String[] reqs = {"GET /Default.htm","POST /index.htm","PUT /blank.htm","DELETE /test.htm"};
	public static String[] users = {"Rushikesh","Akshay","Ipsha","Aditya"};
	public static int[] x={200,300, 400, 404, 500, 406};
	public static int[] year={2006,2007,2008,2009,2010,2011,2012,2013,2014,2015};
	public static int port=80;
	
	public static String getrandstring(String[] fruits) {
		String random = (fruits[new Random().nextInt(fruits.length)]);
		return random;
	}

	public static int getRandom(int[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}	

	public static int randomInteger(int min, int max) {
	    Random rand = new Random();
	    // nextInt excludes the top value so we have to add 1 to include the top value
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	public void generateLogs (int l,int delay) {
		int m=l;
		int d=delay*1000;
		BufferedWriter bw=null;
		FileWriter fw=null;
		
		try {
			//	fw= new FileWriter(ProjectLogs.FILENAME,true);
				//bw=new BufferedWriter(fw);
				
				for(int k=0;k<m;k++) {
					
					try{
						fw= new FileWriter(ProjectLogs.FILENAME,true);
						bw=new BufferedWriter(fw);
								
						
					}catch(IOException e)
					{
						e.printStackTrace();
						
					}
					bw.write(dateFormat.format(new Date())+"T"+dateFormat2.format(new Date())+"Z "+"172.224."+ProjectLogs.randomInteger(0,254)+"."+ProjectLogs.randomInteger(0,254)+" "+ProjectLogs.getrandstring(users)+" "+"206.73.118."+ProjectLogs.randomInteger(0,254)+" "+port+" "+ProjectLogs.getrandstring(reqs)+" "+"-"+" "+ProjectLogs.getRandom(x)+" "+ProjectLogs.randomInteger(0,4000)+" "+ProjectLogs.randomInteger(0,4000)+" "+ProjectLogs.randomInteger(0,600));
					bw.newLine();
					try{
						if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();
						
					}
					System.out.println(dateFormat.format(new Date())+"T"+dateFormat2.format(new Date())+"Z "+"172.224."+ProjectLogs.randomInteger(0,254)+"."+ProjectLogs.randomInteger(0,254)+" "+ProjectLogs.getrandstring(users)+" "+"206.73.118."+ProjectLogs.randomInteger(0,254)+" "+port+" "+ProjectLogs.getrandstring(reqs)+" "+"-"+" "+ProjectLogs.getRandom(x)+" "+ProjectLogs.randomInteger(0,4000)+" "+ProjectLogs.randomInteger(0,4000)+" "+ProjectLogs.randomInteger(0,600));
					Thread.sleep(d);
				}		
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally {
			try{
				if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				
			}
		}			
	}
	
	public static void main(String[] args) {
		ProjectLogs P=new ProjectLogs();
		System.out.println( "Writing logs to file " + ProjectLogs.FILENAME + "....");
		System.out.println("\nGenerating logs with delay of 3 seconds");
		P.generateLogs(1000,3);
	    System.out.println("Finished");
	
	}	
}





