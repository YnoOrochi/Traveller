package io.ynoorochi.traveller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.ynoorochi.traveller.Customization.OFF_THE_SHELF;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

class SpaceShipTest {

    private SpaceShip ship;

    @BeforeEach
    void setup() {
        this.ship = new SpaceShip("A", "tst", 100, OFF_THE_SHELF);
    }

    @Test
    void getCostMCr() {

        assertThat(this.ship.getCostMCr(), is(0.0));
    }

    @Test
    void hullOptions() {
        final var opts = this.ship.cHull.hullOpt;

        for (var option: opts) {
            System.out.println(option);
        }

        assertThat(opts.length, greaterThan(0));

    }
}
