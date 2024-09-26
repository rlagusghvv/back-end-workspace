package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {

	void insert(Board vo);
	List<Board> selectAll(Paging paging);
	int total();
	Board select(int no);
	void update(Board vo);
	void delete(int no);
}






