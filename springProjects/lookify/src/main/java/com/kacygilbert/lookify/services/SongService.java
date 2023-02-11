package com.kacygilbert.lookify.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.lookify.models.Song;
import com.kacygilbert.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	// returns ALL Songs
	public ArrayList<Song> allSongs() {
		return songRepo.findAll();
	}
	
	// CREATES a Song
	public Song createSong(Song newSong) {
		return songRepo.save(newSong);
	}
	// RETRIEVE Song by Id
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	// UPDATE a Song
	public void updateSong(Song song) {
		songRepo.save(song);
	}
	// DELETE a Song by Id
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	// Deliver a Top Ten Songs Array List
//	public ArrayList<Song> findTopTen() {
//		ArrayList<Song> allSongs = songRepo.findByOrderByRatingDesc();
//		ArrayList<Song> topTen = new ArrayList<Song>();
//		if(topTen.size()<=10) {
//			for (int i = 0; i < topTen.size(); i++) {
//				System.out.println("test");
//				topTen.add(allSongs.get(i));
//			}
//		} else {
//			for (int i = 0; i < 10; i++) {
//				topTen.add(allSongs.get(i));
//			}
//		}
//		return topTen;
//	}
	public ArrayList<Song> topTen() {
		return songRepo.getTopTen();
	}
	
	// Finds all songs by a search:containing artist
	public ArrayList<Song> findArtistSongs(String search) {
		return songRepo.findByArtistContaining(search);
	}
	
}
