package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			if(line!=null & line.length > 0) {	
				if(line[14].equals("NA")) {				//도착 지연
					outputKey.set("arrDelayNA," + line[1]);
					context.write(outputKey, outputVal);
				}else if(!line[14].equals("NA") && Integer.parseInt(line[14])>0)  {
					outputKey.set("arrDelay," + line[1]);
					context.write(outputKey, outputVal);
				}

				if(line[15].equals("NA")) {			//출발 지연
					outputKey.set("depDelayNA," + line[1]);
					context.write(outputKey, outputVal);
				}else if(!line[15].equals("NA") && Integer.parseInt(line[15])>0)  {
					outputKey.set("depDelay," + line[1]);
					context.write(outputKey, outputVal);
				}
			}
		}
	}
}
