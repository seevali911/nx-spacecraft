package com.nationalexpress.spacecraft;

import com.nationalexpress.spacecraft.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpacecraftCoachApplicationTests {
    @Autowired
    HomeController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
