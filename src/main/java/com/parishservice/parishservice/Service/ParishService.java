package com.parishservice.parishservice.Service;


import com.parishservice.parishservice.Entity.Parish;

import java.util.List;

public interface ParishService {

    Parish saveParish(Parish parish);

    List<Parish>getAllParishData();

    Parish updateParishData(Long parishId, Parish updatedParish);

    void deleteParish();

    void deleteParishById(Long id);

    Parish getParishById(Long id);
}
