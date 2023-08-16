public class RadioSecondVesion {

    package org.example;

    public class Radio {

        private int maxStationStandard = 9;
        private int minStationStandard = 0;
        private int currentStation= minStationStandard; //Текущая частота станции

        private int maxVolumeStandard = 100;
        private int minVolumeStandard = 0;
        private int currentVolume = minVolumeStandard; //Текущая громкость звука

        public int getMinStationStandard() { //Получение значения станции

            return minStationStandard;
        }

        public int getMaxStationStandard() { //Получение значения станции

            return maxStationStandard;
        }

        public int getCurrentStation() { //Получение значения станции

            return currentStation;
        }

        public int getCurrentVolume() { //Получение значения громкости

            return currentVolume;
        }

//КОНСТРУКТОРЫ

        public Radio (int amountStation) {
            this.maxStationStandard = this.minStationStandard + amountStation;

        }

        public Radio () {
            int maxStation = this.maxStationStandard;
            int minStation = this.minStationStandard;
        }



        // ПЕРЕКЛЮЧЕНИЕ ГРОМКОСТИ
        public void setCurrentVolume(int newCurrentVolume) { //Изменение громкости в пределах допустимых значений
            if (newCurrentVolume < minVolumeStandard) {
                this.currentVolume = minVolumeStandard;
                return;
            }
            if (newCurrentVolume > maxVolumeStandard) {
                this.currentVolume = maxVolumeStandard;
                return;
            }
            this.currentVolume = newCurrentVolume;
        }

        public void IncreaseVolume() { //Повышение громкости
            if (currentVolume < maxVolumeStandard) {
                currentVolume++;
                return;
            }
            currentVolume = maxVolumeStandard;
        }

        public void DecreaseVolume() { //Уменьшение громкости
            if (currentVolume > minVolumeStandard) {
                currentVolume--;
                return;
            }
            currentVolume = minVolumeStandard;
        }

        // ПЕРЕКЛЮЧЕНИЕ СТАНЦИЙ

        public void setCurrentStation(int newCurrentStation) { //Переключение станций в пределах допустимого диапазона
            if (newCurrentStation < minStationStandard) {
                return;
            }
            if (newCurrentStation > maxStationStandard) {
                return;
            }
            this.currentStation = newCurrentStation;
        }

        public void nextStation() { //Переключение станций вперед
            if (currentStation != maxStationStandard) {
                currentStation++;
            } else {
                currentStation = minStationStandard;
            }

        }

        public void prevStation() { //Переключение станций назад
            if (currentStation > minStationStandard) {
                currentStation--;
                return;
            }
            currentStation = maxStationStandard;
        }
}
