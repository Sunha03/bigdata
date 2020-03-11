package mapreduce.product.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyKeyComparator extends WritableComparator{

	protected MyKeyComparator() {
		super(MyKey.class, true);
	}

	//Warning 발생 > WritableComparable의 타입이 정확하지 않기 때문에
	//@SuppressWarnings : 타입에 대한 부분을 체크하지 않고 무시하여 처리하겠음
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		MyKey k1 = (MyKey) obj1;
		MyKey k2 = (MyKey) obj2;
		
		return k1.compareTo(k2);
	}
	
	
}
