package com.MiniAssignment.service;

import java.util.List;
import com.MiniAssignment.model.Notes;

public interface NotesService {
	
	public void scheduledDeleteNote();
	
	//Get all notes
	public List<Notes> fetchAllNotes(String userId);
	
	//Get note details by note ID
	public Notes fetchNoteByNoteId(int noteId);
	//Add new note
	public void saveNote(Notes note, String userId);
	
	//delete node with noteId
	public void deleteById(int noteId);

	//Edit note with noteId
	public void editNote(Notes note, int noteId);
}
