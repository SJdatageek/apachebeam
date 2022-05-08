package apachebeam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;

public class MapElementsExample {

	public static void main(String[] args) {
		
		Pipeline p = Pipeline.create();
		
		PCollection<String> pCustList= p.apply(TextIO.read().from(
				"/Users/salonijain/Documents/apachebeam/apachebeam/apachebeam/src/main/resources/customer.csv"));

		//Using TypeDescriptors

		PCollection<String> pOutput=pCustList.apply(MapElements.into(
				TypeDescriptors.strings()).via((String obj) -> obj.toUpperCase()));
				
		pOutput.apply(TextIO.write().to(
				"/Users/salonijain/Documents/apachebeam/apachebeam/apachebeam/target/output/cust_output.csv")
				.withNumShards(1).withSuffix(".csv"));
		
		p.run();
		
	}
}

