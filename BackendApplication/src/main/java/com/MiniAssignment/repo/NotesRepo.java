package com.MiniAssignment.repo;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MiniAssignment.model.Notes;

@Repository
public interface NotesRepo extends JpaRepository<Notes,Integer>{
	
	public Notes findByNoteId(int noteId);
	
	public List<Notes> findTop3ByUserEmailIdOrderByNoteTimeDesc(String userEmailId);
	public List<Notes> findAllByUserEmailIdOrderByNoteTimeDesc(String userEmailId);
	Page<Notes> findAll(Pageable pageable);  
	
	
	
	
}
