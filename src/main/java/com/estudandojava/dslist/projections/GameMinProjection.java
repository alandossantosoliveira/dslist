package com.estudandojava.dslist.projections;

public interface GameMinProjection {

	Long getId();
	String getTitle();
	Integer getGameYear();//year
	String getImgUrl();//imgUrl
	String getShortDescription();//shortDescription
	Integer getPosition();
}
