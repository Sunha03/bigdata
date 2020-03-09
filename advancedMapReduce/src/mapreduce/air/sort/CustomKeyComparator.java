package mapreduce.air.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class CustomKeyComparator extends WritableComparator{

	protected CustomKeyComparator() {
		super(CustomKey.class, true);
	}

	//Warning 발생 > WritableComparable의 타입이 정확하지 않기 때문에
	//@SuppressWarnings : 타입에 대한 부분을 체크하지 않고 무시하여 처리하겠음
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		CustomKey key1 = (CustomKey)obj1;
		CustomKey key2 = (CustomKey)obj2;
		
		return key1.compareTo(key2);
	}
	
	
}
