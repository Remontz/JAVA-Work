package com.kacygilbert.authentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.authentication.models.Note;
import com.kacygilbert.authentication.repositories.NoteRepository;

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
