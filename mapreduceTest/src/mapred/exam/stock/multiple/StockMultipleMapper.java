package mapred.exam.stock.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
			if (line != null & line.length > 0) {
				if (result > 0) { // 상승마감
					outputKey.set("increase," + line[2].substring(0, 4));
					context.write(outputKey, outputVal);
				}
				if (result < 0) { // 하락마감
					outputKey.set("decrease," + line[2].substring(0, 4));
					context.write(outputKey, outputVal);
				}
				if (result == 0) { // 동일금액마감
					outputKey.set("equal," + line[2].substring(0, 4));
					context.write(outputKey, outputVal);
				}
			}
		}
	}
}
	