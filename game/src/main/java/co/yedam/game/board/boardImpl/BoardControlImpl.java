package co.yedam.game.board.boardImpl;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import co.yedam.game.board.Mapper.BoardMapper;
import co.yedam.game.board.control.BoardControl;
import co.yedam.game.board.control.PlayerVO;
import co.yedam.game.common.DataSource;

public class BoardControlImpl implements BoardControl {
	Scanner sc = new Scanner(System.in);
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);

	@Override
	public void saveRecord(PlayerVO vo) {
		map.saveRecord(vo);

	}

	@Override
	public void recordView(PlayerVO vo) {
		map.recordView(vo);

	}

	@Override
	public int setting(PlayerVO vo) {

		return map.setting(vo);

	}

	@Override
	public PlayerVO login(PlayerVO vo) {
		return map.login(vo);

	}

}
