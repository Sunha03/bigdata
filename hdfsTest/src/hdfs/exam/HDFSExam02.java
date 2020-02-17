package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSExam02 {

	public static void main(String[] args) {
		//1. hdfs를 제어하기 위해 설정 파일을 읽어서 사용해야 함
		//   > hadoop 설치 폴더의 설정 파일을 접근하기 위해 제공되는 클래스
		Configuration conf = new Configuration();
		
		//2. hdfs를 접근하기 위해 제공되는 객체 생성 - hdfs 객체
		FileSystem hdfs = null;
		
		//3. hdfs로부터 input하기 위한 스트림객체
		FSDataInputStream hdfsin = null;
		try {
			hdfs = FileSystem.get(conf);
			
			//4. hdfs의 경로를 표현할 수 있는 객체
			//	 > hdfs로부터 읽을 파일의 경로를 명령행 매개변수로 받아 적용
			Path path = new Path(args[0]);
			
			//5. hdfs에 저장된 파일을 읽을 스트림 생성
			hdfsin = hdfs.open(path);
			
			//6. 입력스트림을 통해 데이터 읽기
			System.out.println(hdfsin.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
