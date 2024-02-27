package tw.com.jeff.board.dao;

import java.util.List;

import tw.com.jeff.model.Boardmessage;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;



public interface MessageBoardDao {
void addMessageBoard(Boardmessage Bms);

List<String> getAllNeedId();
List<Boardmessage> getBmsByNeedid(Integer needid);
NeedBean getNeedBeanFromNeedid(Integer needid);
MemberBean getMemberBeanFromMemberid(Integer memberid);
}
