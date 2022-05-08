package apachebeam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

class CustFilter extends DoFn<String, String> {

	private static final long serialVersionUID = 1L;

	@ProcessElement
	public void processElement(ProcessContext c) {
		String line = c.element();
		String arr[] = line.split(",");
		
		if(arr[3].equals("Los Angeles")) {
			c.output(line);
		}

	}
}

public class ParDoExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> pCustList = p.apply(TextIO.read().from(
				"/Users/salonijain/Documents/apachebeam/apachebeam/apachebeam/src/main/resources/customer_pardo.csv"));

		// Using ParDO

		PCollection<String> pOutput = pCustList.apply(ParDo.of(new CustFilter()));
		
		pOutput.apply(TextIO.write().to(
				"/Users/salonijain/Documents/apachebeam/apachebeam/apachebeam/target/output/customer_pardo_output.csv")
				.withHeader("Id,Name,Last Name,City").withNumShards(1).withSuffix(".csv"));
		
		p.run();

	}

}
