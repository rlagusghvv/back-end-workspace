package person.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @NoArgsConstructor - 기본 생성자
// @AllArgsConstructor - 모든 필드값 파라미터로 받는 생성자
// @Data : 기본 생성자, @AllArgsConstructor 제외 나머지들 한꺼번에 만들어주는 어노테이션
// @RequiredArgsConstructor - 필드값에 final이 붙어있거나 
//							@NonNull이 붙어 있는 필드들을 파라미터로 받는 생성자
// @Setter - Setter
// @Getter - getter

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private int id;
	private String name;
	private int age;
	private String addr;
	
	
}
