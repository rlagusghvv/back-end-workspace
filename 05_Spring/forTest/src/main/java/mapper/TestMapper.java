package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.model.vo.User;



@Mapper
public interface TestMapper {

   void register(User vo);
   List<User> view();
}
