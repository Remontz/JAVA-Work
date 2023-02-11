package com.kacygilbert.houseHunter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.houseHunter.models.Note;
import com.kacygilbert.houseHunter.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepo;
	
	public List<Note> allNotes() {
		return noteRepo.findAll();
	}
	
	public Note createNote(Note newNote) {
		return noteRepo.save(newNote);
	}
	
}
