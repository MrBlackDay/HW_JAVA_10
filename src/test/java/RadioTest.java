import org.example.Radio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test // переключение станций вперед в диапазоне частот от 0 до 9
    public void shouldSetToNextStationInRange() {
        Radio radio = new Radio();

        radio.setNextStation(8);
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций вперед вне диапазона частот от 0 до 9
    public void shouldSetToNextStationOutsideRange() {
        Radio radio = new Radio();

        radio.setNextStation(9);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад в диапазоне частот от 0 до 9
    public void shouldSetToPrevStationInRange() {
        Radio radio = new Radio();

        radio.setPrevCurrentStation(9);
        int expected = 8;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад вне частот от 0 до 9
    public void shouldSetToPrevStationOutsideRange() {
        Radio radio = new Radio();

        radio.setPrevCurrentStation(0);
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }
//Тесты переключения громкости

    @Test // увеличение громкости в пределах доступных значения от 0 до 100
    public void shouldIncreaseVolumeInRange() {
        Radio radio = new Radio();

        radio.setIncreaseVolume(99);
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // увеличение громкости при максимальном значении текущей громкости 100
    public void shouldIncreaseVolumeOutsideRange() {
        Radio radio = new Radio();

        radio.setIncreaseVolume(100);
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // уменьшение громкости звука в пределах допустимых значений от 0 до 100
    public void shouldDecreaseVolumeInRange() {
        Radio radio = new Radio();

        radio.setDecreaseVolume(100);
        int expected = 99;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // уменьшение громкости звука при минимальном значении текущей громкости 0
    public void shouldDecreaseVolumeOutsideRange() {
        Radio radio = new Radio();

        radio.setDecreaseVolume(0);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


}