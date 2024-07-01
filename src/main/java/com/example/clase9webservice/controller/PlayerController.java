package com.example.clase9webservice.controller;
import com.example.clase9webservice.entity.Juegos;

import com.example.clase9webservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class PlayerController {

    @Autowired private PlayerRepository playerRepository;

    @GetMapping("/")
    public List<Juegos> getLeaderboard() {
        String var= "success";
        return playerRepository.findAll();
    }

    @PostMapping("/add")
    public void addPlayer(@RequestBody Juegos player) {
        playerRepository.save(player);
        recalculateLeaderboardPositions(player.getIdjuego());
    }

    @PutMapping("/updateMmr/{idjuego}")
    public void updatePlayerMmr(@PathVariable int idjuego,@RequestParam String newMmr) {
        Juegos player = playerRepository.findById(idjuego).orElse(null);
        if (player != null) {
            player.setName(newMmr);
            playerRepository.save(player);
            recalculateLeaderboardPositions(player.getIdjuego());
        }
    }

    @DeleteMapping("/delete/{idjuego}")
    public void deletePlayer(@PathVariable int playerId) {
        Juegos player = playerRepository.findById(playerId).orElse(null);
        if (player != null) {

            playerRepository.delete(player);

        }
    }

    private void recalculateLeaderboardPositions(Integer juego) {
        List<Juegos> players = playerRepository.findAll();
        for (int i = 0; i < players.size(); i++) {
            Juegos currentPlayer = players.get(i);
            currentPlayer.setIdjuego(i+1);
            playerRepository.save(currentPlayer);
        }
    }

}
