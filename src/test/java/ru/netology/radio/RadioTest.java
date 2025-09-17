package ru.netology.radio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    //Тесты с параметрами количества станций
    @Test
    void shouldSetCurrentStationWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationWhenCountInvalidTooHighWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(20);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationWhenCountInvalidTooLowWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void notChangeStationWhenCountInvalidTooHigh() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        radio.setCurrentStation(22);
        assertEquals(15, radio.getCurrentStation());
    }

    @Test
    void notChangeStationWhenCountInvalidTooLow() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(5);
        radio.setCurrentStation(-5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void nextStationWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        radio.next();
        assertEquals(16, radio.getCurrentStation());
    }
    @Test
    void shouldSwitchToFirstStationIfNextFromLastWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prevRadioStationWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        radio.prev();
        assertEquals(14, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToLastStationIfPrevFromFirstWithCustomStationsCount() {
        Radio radio = new Radio(20);
        radio.prev();
        assertEquals(19, radio.getCurrentStation());
    }
    //Тесты без параметров
    @Test
    void setCurrentStationValid() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void setCurrentStationInvalidTooHigh() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void setCurrentStationInvalidTooLow() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void setCurrentStationDoesNotChangeIfInvalidHigh() {
        Radio radio = new Radio();
        radio.setCurrentStation(5); // Set initial state
        radio.setCurrentStation(15);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void setCurrentStationDoesNotChangeIfInvalidLow() {
        Radio radio = new Radio();
        radio.setCurrentStation(5); // Set initial state
        radio.setCurrentStation(-5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void nextStationNotMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void nextStationIsMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prevStationNotMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.prev();
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void prevStationIsMin() {
        Radio radio = new Radio();
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void increaseVolumeNotMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeIsMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeNotMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeIsMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeValid() {
        Radio radio = new Radio();
        radio.setCurrentVolume(75);
        assertEquals(75, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeInvalidTooHigh() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeInvalidTooLow() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeDoesNotChangeIfInvalidHigh() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // set initial state
        radio.setCurrentVolume(105);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void setCurrentVolumeDoesNotChangeIfInvalidLow() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // set initial state
        radio.setCurrentVolume(-5);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void nextStationFrom8to9() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevStationFrom1to0() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }

    // Дополнительные тесты для полного покрытия
    @Test
    void radioConstructorInitialStationAndVolumeAreZero() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    // Тесты для граничных значений громкости
    @Test
    void setVolumeToZero() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldCreateRadioWithCustomNumberOfStations() {
        Radio radio = new Radio(30);
        assertEquals(30, radio.getNumberOfStations());
    }

    @Test
    void shouldSetCurrentStationWithinCustomStationsCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation());
    }
}


