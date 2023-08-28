package co.yedam.game.board.Mapper;

import co.yedam.game.board.control.PlayerVO;

public interface BoardMapper {
	public void eventLoad(PlayerVO pl);// 이벤트 불러오기

	public void levelLoad(PlayerVO pl);// 레벨 불러오기

	public void saveRecord(PlayerVO pl); // 종료 후 기록 저장

	public void RecordView(PlayerVO pl);// 기록 보기
}
