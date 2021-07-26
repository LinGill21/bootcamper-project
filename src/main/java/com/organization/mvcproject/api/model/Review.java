package com.organization.mvcproject.api.model;

public interface Review {
	public String getAuthor() ;

	void setAuthor(String author);
	Integer getRating() ;

	void setRating(Integer rating);

	public String getReviewBody();

	public void setReviewBody(String reviewBody);
}
