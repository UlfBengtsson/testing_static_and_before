package se.lexicon.skovde;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.skovde.models.Car;

import static org.junit.Assert.*;

public class CarTest
{
    private Car testCar;
    private final String testBrand = "Saab";//using final to preventing changing of the value
    private final String testModel = "900 Aero";

    @Before //before every test
    public void initCar()
    {
        testCar = new Car(testBrand,testModel);
    }

    @After  //after every test
    public void clearCar()
    {
        testCar = null;
    }

    @Test
    public void infoOk()
    {
        //Arrange done by @Before

        //Act
        String result = testCar.info();

        //Assert
        assertTrue(result.contains(testBrand));
        assertTrue(result.contains(testModel));
        assertTrue((result.contains(String.valueOf(testCar.getId()))));
    }

    @Test
    public void setBrandOk()
    {
        //Arrange done by @Before
        String newBrand = "Volvo";

        //Act
        boolean result = testCar.setBrand(newBrand);

        //Assert
        assertTrue(result);// don´t just test the boolean
        assertNotEquals(testBrand, testCar.getBrand());
        assertEquals(newBrand, testCar.getBrand());
    }


    @Test
    public void setBrandBad()
    {
        //Arrange done by @Before
        String noBrand = "";

        //Act
        boolean result = testCar.setBrand(noBrand);

        //Assert
        assertFalse(result);
        assertNotEquals(noBrand, testCar.getBrand());
        assertEquals(testBrand, testCar.getBrand());
    }

    @Test
    public void setModelNameOk()
    {
        //Arrange done by @Before
        String newModelName = "745";

        //Act
        boolean result = testCar.setModelName(newModelName);

        //Assert
        assertTrue(result);
        assertNotEquals(testModel, testCar.getModelName());
        assertEquals(newModelName, testCar.getModelName());
    }


    @Test
    public void setModelNameBad()
    {
        //Arrange done by @Before
        String noModelName = "";

        //Act
        boolean result = testCar.setModelName(noModelName);

        //Assert
        assertFalse(result);
        assertNotEquals(noModelName, testCar.getModelName());
        assertEquals(testModel, testCar.getModelName());
    }

    @Test
    public void counterIdOk()
    {
        //Arrange
        Car testCarTwo;
        int beforeCreate = 0;
        int afterCreate = 0;

        //Act
        beforeCreate = Car.getCounterId();  //no need to create a car object to access a static
        testCarTwo = new Car(testBrand, testModel);
        afterCreate = Car.getCounterId();

        //Assert
        assertNotEquals(0, testCar.getId());
        assertNotEquals(0, testCarTwo.getId());
        assertTrue(testCar.getId() < testCarTwo.getId());
        assertTrue(beforeCreate < afterCreate);
    }
}
