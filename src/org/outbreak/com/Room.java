package org.outbreak.com;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
@Builder

class Room{
	
	
	private int floorNumber;
	private int  roomNumber;
	private String pattern;
	private boolean patternmatch;
	
	
	public Room(boolean b) {
		pattern= Boolean.toString(b);
				
	}


	

	
}