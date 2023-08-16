import org.example.Radio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {


    //ТЕСТЫ КОНСТРУКТОРОВ NEW
    @Test
    public void shouldSetBasicRangeRadioStations(){ //использование стандартных станций

        Radio target = new Radio();

        Assertions.assertEquals(0, target.getMinStationStandard());
        Assertions.assertEquals(9, target.getMaxStationStandard());
    }
    @Test
    public void shouldSetAmountStations(){

        Radio target = new Radio(20); // установка валидного значения диапазона станций

        Assertions.assertEquals(0, target.getMinStationStandard());
        Assertions.assertEquals(20, target.getMaxStationStandard());
    }

    @Test
    public void shouldNotSetAmountStations(){

        Radio target = new Radio(-20); // установка невалидного значения диапазона станций

        Assertions.assertEquals(0, target.getMinStationStandard());
        Assertions.assertEquals(9, target.getMaxStationStandard());
    }

    @Test
    public void shouldNotSetAmountStationsOutsideLimit(){

        Radio target = new Radio(-1); // установка невалидного отрицательного значения диапазона станций (граничные значения)

        Assertions.assertEquals(0, target.getMinStationStandard());
        Assertions.assertEquals(9, target.getMaxStationStandard());
    }
    @Test
    public void shouldNotSetAmountStationsZero(){

        Radio target = new Radio(0); // установка невалидного нулевого значения диапазона станций (граничные значения)

        Assertions.assertEquals(0, target.getMinStationStandard());
        Assertions.assertEquals(9, target.getMaxStationStandard());
    }
    @Test
    public void shouldSetAmountStationsInsideLimit(){

        Radio target = new Radio(1); // установка валидного значения диапазона станций (граничные значения)

        Assertions.assertEquals(0, target.getMinStationStandard());
        Assertions.assertEquals(1, target.getMaxStationStandard());
    }


    // 1. ТЕСТЫ ПЕРЕКЛЮЧЕНИЯ ГРОМКОСТИ
    // 1.1. ПОВЫШЕНИЕ ГРОМКОСТИ ЗВУКА
    @Test // увеличение громкости при недопустимом исходном значении (больше максимально допустимого)
    public void shouldSetIncreaseVolumeOutsideLimitMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(205);

        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // увеличение громкости при допустимом исходном значении
    public void shouldSetIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(55);

        radio.increaseVolume();
        int expected = 56;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }



    // 1.1.1 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (ВЕРХНЯЯ ГРАНИЦА ДОПУСТИМЫХ ЗНАЧЕНИЙ)
    @Test
    // увеличение громкости при недопустимом исходном значении (больше максимально допустимого, граничное значение)
    public void shouldSetIncreaseVolumeOutsideLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);

        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // увеличение громкости при максимально возможном исходном значении (граничное значения)
    public void shouldSetIncreaseVolumeInsideToOutsideLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // увеличение громкости при допустимом исходном значении (граничное значение)
    public void shouldSetIncreaseVolumeInsideLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);

        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // 1.1.2 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (НИЖНЯЯ ГРАНИЦА ДОПУСТИМЫХ ЗНАЧЕНИЙ)
    @Test // увеличение громкости при недопустимом исходном значении (меньше нижнего предела, граничное значение)
    public void shouldSetIncreaseVolumeOutsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        radio.increaseVolume();
        int expected = 1;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // увеличение громкости при минимальном исходном значении (граничное значения)
    public void shouldSetIncreaseVolumeInsideLimitFromMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.increaseVolume();
        int expected = 1;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // увеличение громкости в границах допустимых значений (граничное значения)
    public void shouldSetIncreaseVolumeInsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);

        radio.increaseVolume();
        int expected = 2;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // 1.2. ПОНИЖЕНИЕ ГРОМКОСТИ ЗВУКА
    @Test // понижение громкости при недопустимом исходном значении
    public void shouldSetDecreaseVolumeOutsideMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-205);

        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // понижение громкости при допустимом исходном значении
    public void shouldSetDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(45);

        radio.decreaseVolume();
        int expected = 44;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
    // 1.2.1 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (ВЕРХНЯЯ ГРАНИЦА ДОПУСТИМЫХ ЗНАЧЕНИЙ)

    @Test
    // понижение громкости при максимально допустимом исходном значении (граничное значение)
    public void shouldSetDecreaseVolumeOutsideToInsideLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);

        radio.decreaseVolume();
        int expected = 99;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // понижение громкости при максимально допустимом исходном значении (граничное значение)
    public void shouldSetDecreaseVolumeInsideLimitFromMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.decreaseVolume();
        int expected = 99;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // понижение громкости в границах допустимых значений (граничное значение)
    public void shouldSetDecreaseVolumeInsideLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);

        radio.decreaseVolume();
        int expected = 98;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // 1.2.2.ГРАНИЧНЫЕ ЗНАЧЕНИЯ (НИЖНЯЯ ГРАНИЦА ДОПУСТИМЫХ ЗНАЧЕНИЙ)

    @Test // понижение громкости в границах допустимых значений (граничное значения)
    public void shouldSetDecreaseVolumeInsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);

        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // понижение громкости при минимально допустимом исходном значении (граничное значения)
    public void shouldSetDecreaseVolumeLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test // понижение громкости при недопустимом исходном значении (граничное значения)
    public void shouldSetDecreaseVolumeOutsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    // 2. ТЕСТИРОВАНИЕ ПЕРЕКЛЮЧЕНИЯ СТАНЦИЙ
    // 2.1. ПЕРЕКЛЮЧЕНИЕ СТАНЦИЙ ВПЕРЁД

    @Test // переключение станций вперед в допустимом диапазоне частот
    public void shouldSetToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.nextStation();
        int expected = 6;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций вперед при недопустимом исходном значении
    public void shouldNotSetToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(52);

        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    //2.1.1 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (ВЕРХНЯЯ ГРАНИЦА)
    @Test // переключение станций вперед при недопустимом исходном значении (граничное значении)
    public void shouldNotSetToNextStationOutsideLimitMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);

        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций вперед с максимально допустимого значения (граничное значении)
    public void shouldNotSetToNextStationLimitMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.nextStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций вперед при допустимом исходном значения (граничное значении)
    public void shouldSetToNextStationInsideLimitMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);

        radio.nextStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    //2.1.2 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (НИЖНЯЯ ГРАНИЦА)
    @Test // переключение станций вперед при допустимом исходном значения (граничное значении)
    public void shouldSetToNextStationInsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);

        radio.nextStation();
        int expected = 2;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций вперед с минимального допустимого исходного значения (граничное значении)
    public void shouldSetToNextStationLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций вперед при недопустимом исходном значении (граничное значении)
    public void shouldNotSetToNextStationOutsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    // 2.2. ПЕРЕКЛЮЧЕНИЕ СТАНЦИЙ НАЗАД

    @Test // переключение станций назад при недопустимом исходном значении
    public void shouldNotSetToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(300);

        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад при допустимом исходном значении
    public void shouldSetToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);

        radio.prevStation();
        int expected = 2;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    //2.2.1 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (ВЕРХНЯЯ ГРАНИЦА)

    @Test // переключение станций назад при допустимом исходном значении (граничное значения)
    public void shouldSetToPrevStationInsideMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);

        radio.prevStation();
        int expected = 7;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад при максимально допустимом исходном значении (граничное значения)
    public void shouldSetToPrevStationMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.prevStation();
        int expected = 8;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад при недопустимом исходном значении (граничное значения)
    public void shouldNotSetToPrevStationMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);

        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    //2.2.2 ГРАНИЧНЫЕ ЗНАЧЕНИЯ (НИЖНЯЯ ГРАНИЦА)
    @Test // переключение станций назад при недопустимом исходном значении (граничное значения)
    public void shouldNotSetToPrevStationMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад при допустимом минимальном исходном значении (граничное значения)
    public void shouldSetToPrevStationMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станций назад при допустимом исходном значении (граничное значения)
    public void shouldSetToPrevStationInsideLimitMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);

        radio.prevStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

}



