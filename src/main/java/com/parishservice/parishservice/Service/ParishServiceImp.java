package com.parishservice.parishservice.Service;

import com.parishservice.parishservice.Entity.Parish;
import com.parishservice.parishservice.Repository.ParishRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParishServiceImp implements ParishService{

    @Autowired
    private ParishRepository parishRepository;

    @Override
    public Parish saveParish(Parish parish) {
        return parishRepository.save(parish);
    }

    @Override
    public List<Parish> getAllParishData() {
        return parishRepository.findAll();
    }

    @Override
    public Parish updateParishData(Long id, Parish updatedParish) {
        // Fetch the parish from the repository
        Parish parish = parishRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Parish not available"));

        // Update the fields of the existing Parish with values from updatedParish
        parish.setParishName(updatedParish.getParishName());
        parish.setParishLeaderName(updatedParish.getParishLeaderName());
        parish.setDeputyParishLeaderName(updatedParish.getDeputyParishLeaderName());
        parish.setParishSecretary(updatedParish.getParishSecretary());
        parish.setParishCommittee(updatedParish.getParishCommittee());
        parish.setDescription(updatedParish.getDescription());
        parish.setParishEmail(updatedParish.getParishEmail());
        parish.setDateCreated(updatedParish.getDateCreated());
        parish.setCountry(updatedParish.getCountry());
        parish.setAddress(updatedParish.getAddress());
        parish.setState(updatedParish.getState());
        parish.setCity(updatedParish.getCity());
        parish.setZipCode(updatedParish.getZipCode());

        // Save and return the updated Parish
        return parishRepository.save(parish);
    }


    @Override
    public void deleteParish() {
        parishRepository.deleteAll();
    }

    @Override
    public void deleteParishById(Long id) {
        parishRepository.deleteById(id);
    }

    @Override
    public Parish getParishById(Long id) {
        return parishRepository.findById(id).orElse(null);
    }
}
