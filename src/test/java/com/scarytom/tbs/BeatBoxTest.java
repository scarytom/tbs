package com.scarytom.tbs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeatBoxTest {

    @Test
    public void kick() {
        BeatBox beatBox = JavaInterop.makeBeatbox();
        assertEquals("BOOMBOOMBOOM", beatBox.kick(3));
    }
}