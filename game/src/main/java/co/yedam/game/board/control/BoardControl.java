package co.yedam.game.board.control;

public interface BoardControl {

	public void saveRecord(PlayerVO vo); // 종료 후 기록 저장

	public void recordView(PlayerVO vo);// 기록 보기

	public int setting(PlayerVO vo);

	PlayerVO login(PlayerVO vo);

}
