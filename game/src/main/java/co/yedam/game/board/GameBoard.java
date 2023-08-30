package co.yedam.game.board;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Scanner;

import co.yedam.game.board.boardImpl.BoardControlImpl;
import co.yedam.game.board.control.BoardControl;
import co.yedam.game.board.control.PlayerVO;
import co.yedam.game.common.SHA256;
import co.yedam.game.event.control.EventControl;
import co.yedam.game.event.control.EventVO;
import co.yedam.game.event.eventImpl.EventControlImpl;

public class GameBoard {
	//
	Scanner sc = new Scanner(System.in);
	BoardControl boardControl = new BoardControlImpl();
	EventControl eventControl = new EventControlImpl();
	boolean power = false;
	PlayerVO vo = new PlayerVO();
	EventVO eventResult;
	List<String> playLog = new ArrayList<>();
	SHA256 sha256 = new SHA256();

	int i;
	int failCount = 0;

	public void Login() {

		while (!power) {

			System.out.println("로그인");
			vo.setPlayerName(sc.nextLine());
			System.out.println("비밀번호");
			vo.setPlayerPassword(sc.nextLine());
			vo.setPlayerPassword(sha256.encrypt(vo.getPlayerPassword()));
			vo = boardControl.login(vo);
			if (vo != null) {
				System.out.println("로그인 성공");
				space();
				power = true;
				failCount = 0;
				mainTitle();
			} else {
				System.out.println("아이디 또는 패스워드가 일치하지않습니다.");
				failCount++;
				vo = new PlayerVO();
				if (failCount > 2) {
					addPlayer();

				}

			}

		}

	}

	private void addPlayer() {

		System.out.println("신규 사용자 이름");
		vo.setPlayerName(sc.nextLine());
		System.out.println("신규 비밀번호");
		vo.setPlayerPassword(sc.nextLine());
		vo.setPlayerPassword(sha256.encrypt(vo.getPlayerPassword()));
		boardControl.setting(vo);
		failCount = 0;
		Login();
	}

	private void mainTitle() {

		System.out.println(" 나도 작가다 ");
		System.out.println();
		System.out.println("아무 키나 입력하세요");
		sc.nextLine();
		String nextLine = "";
		if (nextLine != null) {
			menu();
		}

	}

	private void menu() {

		while (power) {
			System.out.println("1. 시작하기");
			System.out.println("2. 기록보기");
			System.out.println("3. 나가기");
			int titleMenu = sc.nextInt();
			sc.nextLine();
			switch (titleMenu) {
			case 1:
				start();
				power = false;
				break;
			case 2:
				record();
			case 3:
				power = false;

			default:
				break;
			}
		}
	}

	private void record() {
		vo.setPlayerName(sc.nextLine());

		boardControl.recordView(vo);

	}

	private void start() {
		System.out.println("이야기를 시작합니다");
		System.out.println("=============================================");
		System.out.println("=============================================");
		System.out.println("=============================================");

		eventPlay();
	}

	private void eventPlay() {
		List<EventVO> eventList = new ArrayList<>();
		EventVO event = new EventVO();
		List<EventVO> selectList = eventControl.firstLine(event);
		eventList.addAll(selectList);

		selectList = eventControl.firstLine(event);
		System.out.println(eventList.get(0).getEventContent());

		for (i = 2; i <= 30; i++) {
			space();

			eventList = new ArrayList<>();
			event = new EventVO();
			event.setEventTurn(i);
			selectList = eventControl.lineEvent(event);
			eventList.addAll(selectList);

			System.out.println("====");
			System.out.println("[" + i + "." + "]");
			System.out.println("1.	" + eventList.get(0).getEventContent());
			System.out.println();
			System.out.println("2.	" + eventList.get(1).getEventContent());
			System.out.println();
			System.out.println("3.	" + eventList.get(2).getEventContent());
			System.out.println();
			int choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1:
				System.out.println("++" + eventList.get(0).getEventContent());
				playLog.add(eventList.get(0).getEventContent());
				break;
			case 2:
				System.out.println(eventList.get(1));
				playLog.add(eventList.get(1).getEventContent());
				break;
			case 3:
				System.out.println(eventList.get(2));
				playLog.add(eventList.get(2).getEventContent());
				break;

			default:
				--i;
				break;

			}

		}

		save();
		System.out.println("END");

		menu();

	}

	private void save() {
		System.out.println("--------------------------");
		vo.setLine1(playLog.get(0));
		vo.setLine2(playLog.get(1));
		vo.setLine3(playLog.get(2));
		vo.setLine4(playLog.get(3));
		vo.setLine5(playLog.get(4));
		vo.setLine6(playLog.get(5));
		vo.setLine7(playLog.get(6));
		vo.setLine8(playLog.get(7));
		vo.setLine9(playLog.get(8));
		vo.setLine10(playLog.get(9));

		vo.setLine11(playLog.get(10));
		vo.setLine12(playLog.get(11));
		vo.setLine13(playLog.get(12));
		vo.setLine14(playLog.get(13));
		vo.setLine15(playLog.get(14));
		vo.setLine16(playLog.get(15));
		vo.setLine17(playLog.get(16));
		vo.setLine18(playLog.get(17));
		vo.setLine19(playLog.get(18));
		vo.setLine20(playLog.get(19));

		vo.setLine21(playLog.get(20));
		vo.setLine22(playLog.get(21));
		vo.setLine23(playLog.get(22));
		vo.setLine24(playLog.get(23));
		vo.setLine25(playLog.get(24));
		vo.setLine26(playLog.get(25));
		vo.setLine27(playLog.get(26));
		vo.setLine28(playLog.get(27));
		vo.setLine29(playLog.get(28));
		vo.setLine30(playLog.get(29));

		boardControl.saveRecord(vo);
		System.out.println("==========================");

	}

	private void space() {

		for (int i = 0; i < 15; i++) {
			System.out.println("  ");
		}

	}
}
