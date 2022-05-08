package apachebeam;


import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.values.PCollection;

public class LocalFileExample {
	
	public static void main(String[] args) {
		
		try {
		//creating pipeline object
		Pipeline pipeline = Pipeline.create();
		
		//reading input file and creating PCollection object
		PCollection<String> output = pipeline.apply(TextIO.read().from("input.csv"));
		
		//writing the contents of the PCollection object to output file
		//withNumShards lets us specify how output files we want the output to be written to
		output.apply(TextIO.write().to("output.csv").withNumShards(1).withSuffix(".csv"));
		
		pipeline.run();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
