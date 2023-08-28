package co.yedam.game.board;

import java.util.Scanner;

import cd.yedam.game.event.control.EventControl;
import cd.yedam.game.event.eventImpl.EventControlImpl;
import co.yedam.game.board.boardImpl.BoardControlImpl;
import co.yedam.game.board.control.BoardControl;

public class GameBoard {
	// 제품관리메뉴
	Scanner sc = new Scanner(System.in);
	BoardControl bc = new BoardControlImpl();
	EventControl ec = new EventControlImpl();
	boolean power = true;

	private void start() {
		System.out.println("이름을 입력하세요");

		String name = sc.nextLine();

		System.out.println("123124");

		int i = 1;
		ec.firstEvent(null);
		ec.eventPlay();
		stream();
	}

	private void stream() {
		for (int i = 0; i<30; i++) {
			
			System.out.println();
			ec.eventPlay();
			
			
			
		}
		
	}

	public void menu() {

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
	
	
	
	
	

}
