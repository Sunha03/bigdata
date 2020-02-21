package mapred.exam.stock.option;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockOptionMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();
	String jobType;
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		jobType = context.getConfiguration().get("jobType");
	}



	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
				double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
				
				outputKey.set(line[2].substring(0, 4));
				if(jobType.equals("increase")) {
					if (result > 0) { // 상승마감
						context.write(outputKey, outputVal);
					}
				} else if(jobType.equals("decrease")) {
					if (result < 0) { // 하락마감
						context.write(outputKey, outputVal);
					}
				} else if(jobType.equals("same")) {
					if (result == 0) { // 동일금액마감
						context.write(outputKey, outputVal);
					}
				}
			}
		}
	}
}
	