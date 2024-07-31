package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.vo.Member;

// member.xml이랑 연결됨. 1:1 매핑
@Mapper
public interface MemberMapper {
	void register(Member member); // 1:1 Mapping. (Member member의 member) -> member.xml > parameterType="com.kh.mybatis.model.vo.Member에 담김
	List<Member> allMember();
	Member login(Member member);
	void update(Member member);
	void updatePwd(Member member);
	
}

