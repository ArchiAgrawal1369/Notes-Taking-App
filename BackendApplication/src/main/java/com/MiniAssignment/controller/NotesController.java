package com.MiniAssignment.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.MiniAssignment.service.NotesService;
import com.MiniAssignment.model.Notes;
import com.MiniAssignment.model.User;

@RestController
public class NotesController {

	@Autowired 
	private NotesService service;
		
	//Add new notes
		@PostMapping("/addNotes/{userId}")
		@CrossOrigin(origins="http://localhost:4200")
		public boolean addNote(@RequestBody Notes note, @PathVariable("userId") String userId){
			service.saveNote(note,userId);
			return true;
		}
		
	//Get the list of all notes 
		@GetMapping("/viewNotes/{userId}")
		@CrossOrigin(origins="http://localhost:4200")
		public List<Notes> getNotes(@PathVariable("userId") String userId)
		{	return service.fetchAllNotes(userId);
		}
		
	//Get note details by Id 
		@GetMapping("/note/{noteId}")
		@CrossOrigin(origins="http://localhost:4200")
		public Notes noteDetails(@PathVariable int noteId) {
			return service.fetchNoteByNoteId(noteId);
		}	
		
		//Update Note by NoteId
		@PutMapping("/note/{noteId}")
		@CrossOrigin(origins="http://localhost:4200")
		public boolean updateNote(@RequestBody Notes note, @PathVariable("noteId") int noteId) 
		{	service.editNote(note, noteId);
			return true;	
		}
		
	//Delete Note by noteId
		@DeleteMapping("/note/{noteId}")
		@CrossOrigin(origins="http://localhost:4200")
		public boolean delete(@PathVariable("noteId") int noteId)
		{	service.deleteById(noteId);
			return true;
		}
		
}
