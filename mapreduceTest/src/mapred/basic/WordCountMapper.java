package mapred.basic;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Mapper
/* 1. Mapper 클래스 상속
 *    > mapper에 전달될 input 데이터의 key, value 타입과 mapper의 실행결과로 출력되는 output 데이터의 key, value 값 정의
 *    Mapper<입력 key 타입, 입력 value 타입, 출력 key 타입, 출력 value 타입>
 * 2. map 메소드를 오버라이딩해서 map 작업을 수행하면서 처리할 내용을 구현
 *	  > 입력된 값을 분석하기 위한 메소드 : 입력된 데이터에 조건을 적용 & 원하는 데이터를 추출하기 위한 반복작업 수행
 * 	  map 메소드의 매개변수 - 입력데이터 키, 입력값, context
 * 	  * context : 맵리듀스 작업을 수행하며 맵메소드의 실행결과(출력 데이터를 기록하고 shuffle하고 리듀서로 내보내는 작업)을 수행하는 객체
 * 				    프레임워크 내부에서 기본작업을 처리하는 객체
 * 				    내부에서 머신들끼리 통신할 때 필요한 여러가지 정보를 갖고 있음
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	//output 데이터를 mapper의 실행결과로 내보내기 < key, value를 저장하는 변수 선언
	static final IntWritable outputVal = new IntWritable(1);		//항상 1 > 상수로 정의
	Text outputKey = new Text();									//output value > 문자열(Text)
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		//key : linenumber,
		//value : 입력데이터의 한 라인에 해당하는 문장 ex)read a book
		StringTokenizer st = new StringTokenizer(value.toString());		//공백으로 자르기
		while(st.hasMoreTokens()) {
			String token = st.nextToken();			//잘라낸 Token 1개 반환
			outputKey.set(token);
			context.write(outputKey, outputVal);	//Context의 write 메소드로 output으로 내보낼 데이터의 key, value 정의
			
		}
	}
	
}
