package mapreduce.product.sort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProductSortPartitioner extends Partitioner<MyKey, IntWritable>{

	@Override
	public int getPartition(MyKey key, IntWritable value, int numPartitions) {
		
		return key.getProductId().hashCode() % numPartitions;
	}
	
}
