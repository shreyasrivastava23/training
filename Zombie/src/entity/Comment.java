package entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Comments1")
@SequenceGenerator(name="sc", sequenceName="sequence_cmnt")
public class Comment {
	@Id
	@GeneratedValue(generator="sc")
	private int commentId;
	private String response;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cmntTime;
	
	@ManyToOne
	@JoinColumn(name="feedId")	
	private Feed feed;
	
	@ManyToOne
	@JoinColumn(name ="userId")
	private User user;



	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return response;
	}

	public void setComment(String comment) {
		this.response = comment;
	}

	
	public Date getCmntTime() {
		return cmntTime;
	}

	public void setCmntTime(Date cmntTime) {
		this.cmntTime = cmntTime;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}


}