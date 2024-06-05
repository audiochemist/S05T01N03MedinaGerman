package cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.model.dto.FlowerEntityDTO;
import cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.model.services.FlowerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/clientFlowers")
@RequiredArgsConstructor
public class FlowerController {
    @Autowired
    FlowerEntityService service;

    @PostMapping("/clientFlowerAdd")
    public ResponseEntity<FlowerEntityDTO> addFlower(@RequestBody FlowerEntityDTO flowerEntityDTO) {
        FlowerEntityDTO flowerEntityDTO1 = service.createFlower(flowerEntityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(flowerEntityDTO1);
    }

    @PutMapping("/clientFlowerUpdate")
    public ResponseEntity<FlowerEntityDTO> updateFlower(@PathVariable int id, @RequestBody FlowerEntityDTO flowerEntityDTO) {
        service.updateFlower(id, flowerEntityDTO);
        return ResponseEntity.ok(flowerEntityDTO);
    }

    @DeleteMapping("/clientFlowerDelete/{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable int id) {
        service.deleteFlower(id);
        return ResponseEntity.ok("Flower deleted successfully");
    }

    @GetMapping("/clientFlowerGetOne/{id}")
    public ResponseEntity<FlowerEntityDTO> getOneFlower(@PathVariable int id) {
        FlowerEntityDTO flowerEntityDTO = service.getOneFlower(id);
        return ResponseEntity.ok(flowerEntityDTO);
    }

    @GetMapping("/clientFlowerGetAll")
    public ResponseEntity<List<FlowerEntityDTO>> getAllFlowers() {
        List<FlowerEntityDTO> flowers = service.getAllFlowers();
        if (flowers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flowers);
        }
    }

}
