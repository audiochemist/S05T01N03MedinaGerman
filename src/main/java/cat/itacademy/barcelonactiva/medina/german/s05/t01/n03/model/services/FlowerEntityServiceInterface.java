package cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.model.dto.FlowerEntityDTO;

import java.util.List;

public interface FlowerEntityServiceInterface {
    FlowerEntityDTO createFlower (FlowerEntityDTO florEntityDTO);

    FlowerEntityDTO updateFlower (int id, FlowerEntityDTO florEntityDTO);

    void deleteFlower(int id);

    FlowerEntityDTO getOneFlower(int id);

    List<FlowerEntityDTO> getAllFlowers();
}
