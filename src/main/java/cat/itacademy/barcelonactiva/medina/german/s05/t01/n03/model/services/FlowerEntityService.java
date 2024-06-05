package cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.medina.german.s05.t01.n03.model.dto.FlowerEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

@Service
public class FlowerEntityService implements FlowerEntityServiceInterface {

    @Autowired
    WebClient webClient;
    @Override
    public FlowerEntityDTO createFlower(FlowerEntityDTO flowerEntityDTO) {
        return webClient.post()
                .uri("/flower/add")
                .bodyValue(flowerEntityDTO)
                .retrieve()
                .bodyToMono(FlowerEntityDTO.class)
                .block();
    }

    @Override
    public FlowerEntityDTO updateFlower(int id, FlowerEntityDTO flowerEntityDTO) {
        return webClient.put()
                .uri("/flower/update/{id}", id)
                .bodyValue(flowerEntityDTO)
                .retrieve()
                .bodyToMono(FlowerEntityDTO.class)
                .block();
    }

    @Override
    public void deleteFlower(int id) {
                webClient.delete()
                .uri("/flower/delete/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public FlowerEntityDTO getOneFlower(int id) {
        return webClient.get()
                .uri("/flower/getOne/{id}", id)
                .retrieve()
                .bodyToMono(FlowerEntityDTO.class)
                .block();
    }

    @Override
    public List<FlowerEntityDTO> getAllFlowers() {
        return webClient.get()
                .uri("/flower/getAll")
                .retrieve()
                .bodyToFlux(FlowerEntityDTO.class)
                .collectList()
                .block();
    }
}
