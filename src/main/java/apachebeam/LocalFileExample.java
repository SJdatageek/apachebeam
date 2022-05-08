package apachebeam;


import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;

public class LocalFileExample {
	
	public static void main(String[] args) {
		
		try {
		
		Myoptions option = PipelineOptionsFactory.fromArgs(args).withValidation().as(
				Myoptions.class);
			
		//creating pipeline object
		Pipeline pipeline = Pipeline.create(option);
		
		//reading input file and creating PCollection object
		PCollection<String> output = pipeline.apply(TextIO.read().from(
				option.getInputFile()));
		
		//writing the contents of the PCollection object to output file
		//withNumShards lets us specify how output files we want the output to be written to
		output.apply(TextIO.write().to(option.getOutputFile()).withNumShards(1).withSuffix(
				option.getExtn()));
		
		pipeline.run();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
