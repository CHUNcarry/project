package co.yedam.game.board.Mapper;

import co.yedam.game.board.control.PlayerVO;

public interface BoardMapper {

	public void saveRecord(PlayerVO vo); // 종료 후 기록 저장

	public int setting(PlayerVO vo); // 시작 시 key id 생성

	public void recordView(PlayerVO vo);

	PlayerVO login(PlayerVO vo);
}
