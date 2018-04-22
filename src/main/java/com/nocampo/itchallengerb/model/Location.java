package com.nocampo.itchallengerb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.fedy2.weather.data.Channel;

@Document(collection = "locations")
public class Location {
	
	@Id
	private String id;
	private String location;
	private Channel channel;
	
	
	
	
	public Location() {
		
	}
	public Location(String location) {
		super();
		this.location = location;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
	
	
	
	
	
	

}
