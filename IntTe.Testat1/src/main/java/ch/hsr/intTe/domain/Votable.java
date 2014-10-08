package ch.hsr.intTe.domain;

public interface Votable {
	int getVotes();
	
	int voteUp();
	
	int voteDown();
}
