# Apache Beam
## Introduction to apache beam

Apache Beam is a unified model for defining both batch and streaming data-parallel processing pipelines.

## PCollection
A PCollection represents a distributed dataset that your beam pipeline operates on. It's characterstics are listed below:

- Element type should be same
- Immutability 
- Random access not allowed in PCollection object
- PCollection can be either bounded (eg: database table) or unbounded (eg: real time data like sensor data)
- Element timestamps
- In big data every object should be serialised because the object will be processed on the distributed nodes

## PTransform
PTransform (.apply) represents a data processing operation or a step in your pipeline.

 MapElement is element wise transformation, one to one mapping. Implementation approach:
 - TypeDescriptors
 - SimpleFunction
