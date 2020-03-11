package mapreduce.product.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ProductSortReducer extends Reducer<MyKey, IntWritable, MyKey, Text>{
	Text resultVal = new Text();
	MyKey resultKey = new MyKey();
	
	@Override
	protected void reduce(MyKey key, Iterable<IntWritable> values,
			Reducer<MyKey, IntWritable, MyKey, Text>.Context context) throws IOException, InterruptedException {
		int userSum = 0;
		int clickSum = 0;
		String beforeUser = key.getUserId();
		
		for(IntWritable value:values) {
			/*if(!beforeUser.equals(key.getUserId())) 		//userId가 바뀌는 순간
				userSum++;
			
			clickSum++;
			beforeUser = key.getUserId();
			*/
			
			userSum++;
			clickSum += value.get();
		}
		
		resultKey.setProductId(key.getProductId());
		resultVal.set(Integer.toString(userSum) + "\t" + Integer.toString(clickSum));
		context.write(resultKey, resultVal);
	}
}

