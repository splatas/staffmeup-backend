package com.postres.staffing_follower.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void equalNullAndEmpty() {
        assertTrue(Field.equal(null, "   "));
    }

    @Test
    public void equalEmptyAndEmpty() {
        assertTrue(Field.equal("", "   "));
    }

    @Test
    public void equalUpperAndLow() {
        assertTrue(Field.equal("test", "  TEST "));
    }

    @Test
    public void equalDifferent() {
        assertFalse(Field.equal("test", "  TESTing "));
    }



    @Test
    public void equalDateTrue() {
        Date field = new Date();
        Date otherField = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            field = formatter.parse("05/01/1991");
            otherField = formatter.parse("05/01/1991");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertTrue(Field.equal(field, otherField));
    }

    @Test
    public void getValueTrue() {
        String value = Field.getValueNormalized("formatteD ");
        assertEquals(value, "formatted");
    }

    @Test
    public void getValueDefault() {
        String value = Field.getValueNormalized(null, "other");
        assertEquals(value, "other");
    }
    @Test
    public void getValueDefaultTrue() {
        String value = Field.getValueNormalized("formatteD", "other");
        assertEquals(value, "formatted");
    }

    @Test
    public void getDate() {
        Date date= Field.getDate("1/5/1991");
        assertEquals(date.getMonth(),0);

    }
}