package cd.yedam.game.event.eventImpl;

import org.apache.ibatis.session.SqlSession;

import cd.yedam.game.event.control.EventControl;
import cd.yedam.game.event.control.EventVO;
import cd.yedam.game.event.mapper.EventMapper;
import co.yedam.game.common.DataSource;

public class EventControlImpl implements EventControl {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private EventMapper map = sqlSession.getMapper(EventMapper.class);
	
	
	
	@Override
	public void firstEvent(EventVO ev) {
	return map.firstEvent(ev);
		
	}
	@Override
	public void eventLoad(EventVO ev) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eventPlay() {
		// TODO Auto-generated method stub
		
	}
	
	


}
