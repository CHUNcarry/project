package co.yedam.game.event.eventImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.game.common.DataSource;
import co.yedam.game.event.control.EventControl;
import co.yedam.game.event.control.EventVO;
import co.yedam.game.event.mapper.EventMapper;

public class EventControlImpl implements EventControl {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private EventMapper map = sqlSession.getMapper(EventMapper.class);
	List<EventVO> eventlist = new ArrayList<EventVO>();

	@Override
	public List<EventVO> lineEvent(EventVO event) {

		return map.lineEvent(event);
	}

	@Override
	public List<EventVO> firstLine(EventVO event){
		return map.firstLine(event);

	}
}
