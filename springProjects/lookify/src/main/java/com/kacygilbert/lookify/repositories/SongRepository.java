package com.kacygilbert.lookify.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	ArrayList<Song> findAll();
	@Query(value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery = true)
	ArrayList<Song> getTopTen();
	//List<Passenger> findByOrderBySeatNumberAsc();
	ArrayList<Song> findByArtistContaining(String search);
}


