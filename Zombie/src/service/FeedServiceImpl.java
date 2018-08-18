package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.CommentBean;
import entity.Comment;
import entity.Feed;
import repo.FeedRepo;
@Service
public class FeedServiceImpl implements FeedService {
@Autowired
private FeedRepo repo;
	@Override
	public void askQuestion(Feed feed) {
 feed.setFeedTime(new Date());
 repo.askQuestion(feed);
	}

	@Override
	public List<Feed> getMyFeeds(String userId) {
		return repo.getMyFeeds(userId);
	}

	@Override
	public List<Feed> searchFeeds(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feed getQuestion(int fid) {

		return repo.getQuestion(fid);
	}

	@Override
	public Feed submitComment(Comment comment) {
		comment.setCmntTime(new Date());
		return repo.submitComment(comment);
	}

}
