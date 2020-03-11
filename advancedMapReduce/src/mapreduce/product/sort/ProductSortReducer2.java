package mapreduce.product.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ProductSortReducer2 extends Reducer<MyKey, Text, Text, Text>{
	Text resultVal = new Text();
	Text resultKey = new Text();
	
	@Override
	protected void reduce(MyKey key, Iterable<Text> values,
			Reducer<MyKey, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		int userSum = 0;
		int clickSum = 0;
		String beforeUser = key.getUserId();
		
		for(Text value:values) {
			String currentUser = value.toString();

			if(beforeUser.equals(currentUser)) {		//사용자가 다른 경우
				userSum++;
			}
			
			clickSum++;			//상품 조회 수 + 1
			beforeUser = currentUser;
		}
		
		//상품 코드 변경되는 경우
		resultKey.set(key.getProductId());
		StringBuffer data = new StringBuffer();
		data.append(userSum).append("\t").append(clickSum);
		resultVal.set(data.toString());
		context.write(resultKey, resultVal);
	}
}

