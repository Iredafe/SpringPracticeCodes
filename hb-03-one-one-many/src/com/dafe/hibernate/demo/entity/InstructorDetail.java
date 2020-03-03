package com.dafe.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youTubeChannel;
	
	@Column(name="hobby")
	private String hobby;
//add a new field for instructor
	//add @one to one annotation
	
	@OneToOne(mappedBy="instructorDetail", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private Instructor Instructor;
	
	
public Instructor getInstructor() {
		return Instructor;
	}

	public void setInstructor(Instructor instructor) {
		Instructor = instructor;
	}

//create no-arg constructor
public InstructorDetail() {
	
}
	
	//generate getters/setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYouTubeChannel() {
		return youTubeChannel;
	}


	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	
	//create constructors

	public InstructorDetail(String youTubeChannel, String hobby) {
		
		this.youTubeChannel = youTubeChannel;
		this.hobby = hobby;
	}

	
	//generate toString() method

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby + "]";
	}
		
}
