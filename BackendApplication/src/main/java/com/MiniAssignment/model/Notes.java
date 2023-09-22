package com.MiniAssignment.model;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


@Entity
@Table(name="notes")
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;
	
	@Column(name="title")
	private String noteTitle;
	
	@Column(name="description")
	private String noteDescription;
	
	@Column(name="time")
	private Timestamp noteTime;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    
    public Notes() {}
    
	public Notes(int noteId, String noteTitle, String noteDescription, Timestamp noteTime, User user) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteDescription = noteDescription;
		this.noteTime = noteTime;
		this.user = user;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteDescription() {
		return noteDescription;
	}

	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}

	public Timestamp getNoteTime() {
		return noteTime;
	}

	public void setNoteTime(Timestamp noteTime) {
		this.noteTime = noteTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
