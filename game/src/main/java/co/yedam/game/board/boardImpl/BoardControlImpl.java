package co.yedam.game.board.boardImpl;

import org.apache.ibatis.session.SqlSession;

import co.yedam.game.board.Mapper.BoardMapper;
import co.yedam.game.board.control.BoardControl;
import co.yedam.game.board.control.PlayerVO;
import co.yedam.game.common.DataSource;

public class BoardControlImpl implements BoardControl {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);

	

	@Override
	public void saveRecord(PlayerVO pl) {
 

	}

	@Override
	public void RecordView(PlayerVO pl) {
		// TODO Auto-generated method stub

	}

}
