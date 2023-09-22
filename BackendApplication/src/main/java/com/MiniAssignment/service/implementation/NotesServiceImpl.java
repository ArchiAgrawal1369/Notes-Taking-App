package com.MiniAssignment.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiniAssignment.repo.NotesRepo;
import com.MiniAssignment.repo.UserRepo;
import com.MiniAssignment.service.NotesService;

import com.MiniAssignment.model.Notes;
import com.MiniAssignment.model.User;

@Service
public class NotesServiceImpl implements NotesService{
	@Autowired
	private NotesRepo repo;
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void scheduledDeleteNote() {
		System.out.print("Deleteing notes every hour /n");
		List <User> users = userRepo.findAll();
		for(User user:users) {
			List <Notes> notes = repo.findAllByUserEmailIdOrderByNoteTimeDesc(user.getEmailId());
			if (notes.size()>10) {
				List<Notes> delNotes = notes.subList(10, notes.size());
				for(Notes delNote:delNotes)
				{
				repo.delete(delNote);
				}
			}	
		}
	}
	//Get all notes
	@Override
	public List<Notes> fetchAllNotes(String userId)
	{	return repo.findTop3ByUserEmailIdOrderByNoteTimeDesc(userId);
	}
	
	//Get note details by note ID
	@Override
	public Notes fetchNoteByNoteId(int noteId) {
		return repo.findByNoteId(noteId);
	}
	
	//Add new note
	@Override
	public void saveNote(Notes note, String userId) {
		User user = userRepo.findByEmailId(userId);
		note.setUser(user);
		repo.save(note);
	}
	
	//delete node with noteId
	@Override
	public void deleteById(int noteId) {
		Notes note = repo.getById(noteId);
		repo.delete(note);
	}

	//Edit note with noteId
	@Override
	public void editNote(Notes note, int noteId) {
		Notes newnote = repo.findByNoteId(noteId);
		newnote.setNoteTitle(note.getNoteTitle());
		newnote.setNoteDescription(note.getNoteDescription());
		repo.save(newnote);
	}
}
