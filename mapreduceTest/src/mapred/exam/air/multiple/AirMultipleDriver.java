package mapred.exam.air.multiple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AirMultipleDriver  extends Configured implements Tool{

	@Override
	public int run(String[] optionlist) throws Exception {
		//run 메소드는 사용자가 입력한 모든 옵션에 대한 정보를 String[]으로 전달받음
		//-D를 입력하고 설정한 옵션과 사용자가 입력한 명령행 매개변수를 분리하여 관리해야 함
		//getRemainingArgs()를 이용해 공통 옵션(-D와 입력한 값 이외의 입력값)과 사용자가 입력한 옵션을 따로 분리함 > 
		GenericOptionsParser parser = new GenericOptionsParser(getConf(), optionlist);
		String[] otherArgs = parser.getRemainingArgs();
		Job job = new Job(getConf(), "air_multiple");
		
		job.setMapperClass(AirMultipleMapper.class);
		job.setReducerClass(AirMultipleReducer.class);
		job.setJarByClass(AirMultipleDriver.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		
		MultipleOutputs.addNamedOutput(job, "arrDelay", TextOutputFormat.class, Text.class, IntWritable.class);
		MultipleOutputs.addNamedOutput(job, "arrDelayNA", TextOutputFormat.class, Text.class, IntWritable.class);
		MultipleOutputs.addNamedOutput(job, "depDelay", TextOutputFormat.class, Text.class, IntWritable.class);
		MultipleOutputs.addNamedOutput(job, "depDelayNA", TextOutputFormat.class, Text.class, IntWritable.class);
		
		job.waitForCompletion(true);
		return 0;
	}
	
	public static void main(String[] args) 
			throws Exception{
		ToolRunner.run(new Configuration(), new AirMultipleDriver(), args);
		
	}

}

