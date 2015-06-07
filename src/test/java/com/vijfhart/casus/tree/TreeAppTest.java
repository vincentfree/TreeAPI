package com.vijfhart.casus.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 1-6-2015.
 */
public class TreeAppTest {
    @Test
    public void testlistVolgorde() throws Exception {
        TreeApp app = new TreeApp();
        app.main(new String[0]);
        assertNotNull(app);
    }
}