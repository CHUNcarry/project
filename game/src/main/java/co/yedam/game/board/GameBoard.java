package co.yedam.game.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.game.board.boardImpl.BoardControlImpl;
import co.yedam.game.board.control.BoardControl;
import co.yedam.game.board.control.PlayerVO;
import co.yedam.game.event.control.EventControl;
import co.yedam.game.event.control.EventVO;
import co.yedam.game.event.eventImpl.EventControlImpl;

public class GameBoard {
	//
	Scanner sc = new Scanner(System.in);
	BoardControl boardControl = new BoardControlImpl();
	EventControl eventControl = new EventControlImpl();
	boolean power = true;
	PlayerVO player = new PlayerVO();

	EventVO eventResult;

	public void mainTitle() {
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
			System.out.println("2. 나가기");
			int titleMenu = sc.nextInt();
			sc.nextLine();
			switch (titleMenu) {
			case 1:
				start();
				power = false;
				break;
			case 2:
				power = false;
				sc.close();
			default:
				break;
			}
		}
	}

	private void start() {
		System.out.println("이름을 입력하세요");

		String name = sc.nextLine();

		System.out.println(name + " 첫 문장");//

		eventPlay();

	}

	private void eventPlay() {

		for (int i = 1; i <= 30; i++) {
			space();
			List<EventVO> eventList = new ArrayList<>();
			EventVO event = new EventVO();
			event.setEventTurn(i);
			List<EventVO> selectList = eventControl.lineEvent(event);
			eventList.addAll(selectList);

			System.out.println("====");
			System.out.println("[" + i + "]");
			System.out.println("1.	" + eventList.get(0).getEventName());
			System.out.println("	" + eventList.get(0).getEventContent());
			
			System.out.println("2.	" + eventList.get(1).getEventName());
			System.out.println("	" + eventList.get(1).getEventContent());
			
			System.out.println("3.	" + eventList.get(2).getEventName());
			System.out.println("	" + eventList.get(2).getEventContent());

			int choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1:
				System.out.println(eventList.get(0));
				System.out.println(eventList.get(0).getEventName());
				break;
			case 2:
				System.out.println(eventList.get(1));
				break;
			case 3:
				System.out.println(eventList.get(2));
				break;

			default:
				break;

			}
			space();
		}
	}
	private void space() {
		
		for(int i = 0; i<25; i++) {
			System.out.println("  ");	
		}
		
	}
}
