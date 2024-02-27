package tw.com.jeff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MemComment")
public class UsercommentBean {
	private Integer MemberCommenId;
	private Double StarNum;
	private String Comment;
	private Integer MemberBean;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMemberCommenId() {
		return MemberCommenId;
	}
	public void setMemberCommenId(Integer memberCommenId) {
		MemberCommenId = memberCommenId;
	}	
	public Double getStarNum() {
		return StarNum;
	}	
	public void setStarNum(Double starNum) {
		StarNum = starNum;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public Integer getMemberBean() {
		return MemberBean;
	}
	public void setMemberBean(Integer memberBean) {
		MemberBean = memberBean;
	}

}
