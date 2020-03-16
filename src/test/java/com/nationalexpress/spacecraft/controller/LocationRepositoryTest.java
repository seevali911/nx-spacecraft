package com.nationalexpress.spacecraft.controller;

import com.nationalexpress.spacecraft.model.Location;
import com.nationalexpress.spacecraft.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LocationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LocationRepository locationRepository;

//    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Location location = new Location(1, "Mercury", "Y", "mercury.png");
        entityManager.persist(location);
        entityManager.flush();

        // when
        Optional<Location> locationById = locationRepository.findById(1);

        // then
        assertThat(locationById.get().getLocationName())
                .isEqualTo(location.getLocationName());
    }

}
