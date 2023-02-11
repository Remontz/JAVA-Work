package com.kacygilbert.lookify.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kacygilbert.lookify.models.Song;
import com.kacygilbert.lookify.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songServ;
	
	// Welcome to Lookify!
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	// Dashboard
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("song") Song song,Model model) {
		ArrayList<Song> songs = songServ.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	// Add Song Page
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song,
			Model model) {
		return "newSong.jsp";
	}
	// Create a new Song
	@PostMapping("/songs/create")
	public String createSong(@Valid
			@ModelAttribute("song") Song song,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			ArrayList<Song> songs = songServ.allSongs();
			model.addAttribute("song", songs);
			return "index.jsp";
		}
		songServ.createSong(song);
		return "redirect:/";
	}
	
	// Renders Top-Ten Page
	@GetMapping("/search/topTen")
//	public String topTen(@ModelAttribute("song") Song song, Model model) {
//		ArrayList<Song> topTenSongs = songServ.findTopTen();
//		System.out.println(topTenSongs);
//		model.addAttribute("topTenSongs", topTenSongs);
//		return "topTen.jsp";
//	}
//}
	public String topTen(Model model) {
		ArrayList<Song> topTenSongs = songServ.topTen();
		model.addAttribute("topTenSongs",topTenSongs);
		return "topTen.jsp";
	}
	
	// Renders Details Page (One Song)
	@GetMapping("/songs/{id}")
	public String songDetails(@PathVariable("id") Long id,
			Model model) {
			Song song = songServ.findSong(id);
			model.addAttribute("song", song);
			return "details.jsp";
	}
	
	// Deletes a Song
	@DeleteMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	// Searches for songs by artist
	@PostMapping("/search")
	public String search(@RequestParam("search") String search, Model model, RedirectAttributes redirectAttributes) {
		if(search.length() <=2) {
			ArrayList<Song> songs = songServ.allSongs();
			model.addAttribute("song", songs);
			redirectAttributes.addFlashAttribute("error", "The artist name you search must be 3+ characters!");
			return "redirect:/dashboard";
		}
		model.addAttribute("search", search);
		return "redirect:/search/" + search;
	}
	@GetMapping("/search/{search}")
	public String searchArtist(@PathVariable("search") String search, Model model) {
		ArrayList<Song> songs = songServ.findArtistSongs(search);
		model.addAttribute("songs", songs);
		songServ.findArtistSongs(search);
		return "search.jsp";
	}
}
