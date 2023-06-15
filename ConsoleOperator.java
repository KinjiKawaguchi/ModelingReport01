import java.time.LocalTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleOperator {

    public boolean execute() {
        Scanner scanner = new Scanner(System.in);
        String action[] = getInput(scanner, new String[] { "1", "2", "3" },
                new String[] { "列車の時刻表を表示する", "列車の時刻表を検索する", "終了" });
        switch (Integer.parseInt(action[0])) {
            case 1:
                executeDisplayTrainMenu(scanner);
                return true;
            case 2:
                executeDisplayConditionMenu(scanner);
                return true;
            case 3:
                System.out.println("終了します");
                return false;
        }
        return false;
    }

    public void executeDisplayTrainMenu(Scanner scanner) {
        String displayBy[] = getInput(scanner, new String[] { "1", "2", "3", "4", "5", "6" },
                new String[] { "全ての列車を表示", "発車駅から絞り込み", "到着駅から絞り込み", "発車時間から絞り込み", "列車タイプから絞り込み", "停車駅から絞り込み" });
        String inputKey_tmp[] = new String[Main.AllStations.length];
        String inputValue_tmp[] = new String[Main.AllStations.length];
        for (int i = 0; i < Main.AllStations.length; i++) {
            inputKey_tmp[i] = Integer.toString(i);
            inputValue_tmp[i] = Main.AllStations[i].getName();
        }
        switch (Integer.parseInt(displayBy[0])) {
            case 1:
                printTrainInfo(Main.trains);/// 実装
                break;
            case 2:
                String[] selectedStationStr = getInput(scanner, inputKey_tmp, inputValue_tmp);
                Station selectedStation = convertStringToStation(selectedStationStr[1]);
                Train filteredTrains[] = filterByDepartureStation(selectedStation);
                printTrainInfo(filteredTrains);
                break;
            case 3:
                selectedStationStr = getInput(scanner, inputKey_tmp, inputValue_tmp);
                selectedStation = convertStringToStation(selectedStationStr[1]);
                filteredTrains = filterByArrivalStation(selectedStation);
                printTrainInfo(filteredTrains);
                break;
            case 4:
                int[] departureTime = getTimeInput(scanner, "発車時間を入力してください");
                filteredTrains = filterByDepartureTime(departureTime);
                printTrainInfo(filteredTrains);
                break;
            case 5:
                String routeName_tmp[] = new String[Main.RouteList.length];
                for (int i = 0; i > Main.RouteList.length; i++) {
                    routeName_tmp[i] = Main.RouteList[i].getName();
                }
                String[] selectedTrainType = getInput(scanner, new String[] { "1", "2", "3", "4" }, routeName_tmp);
                filteredTrains = filterByTrainType(selectedTrainType[1]);
                printTrainInfo(filteredTrains);
                break;
            case 6:
                selectedStationStr = getInput(scanner, inputKey_tmp, inputValue_tmp);
                selectedStation = convertStringToStation(selectedStationStr[1]);
                filteredTrains = filterByStopsStation(selectedStation);
                printTrainInfo(filteredTrains);
                break;
            default:
                System.err.println("Error: displayBy incorrect");
                System.exit(0);
        }
    }

    public Station convertStringToStation(String string) {
        Station selectedStation;
        for (int i = 0; i < Main.AllStations.length; i++) {
            if (string.equals(Main.AllStations[i].getName())) {
                selectedStation = Main.AllStations[i];
                return selectedStation;
            }
        }
        System.out.println("Error: selectedStation is null");
        System.exit(0);
        return null;
    }

    public Train[] filterByDepartureStation(Station station) {
        ArrayList<Train> filteredTrains = new ArrayList<Train>();
        for (Train train : Main.trains) {
            if (train.getRoute().getStations().get(0).equals(station)) {
                filteredTrains.add(train);
            }
        }
        Train[] array = (Train[]) filteredTrains.toArray();
        return array;
    }

    public Train[] filterByArrivalStation(Station station) {
        ArrayList<Train> filteredTrains = new ArrayList<Train>();
        for (Train train : Main.trains) {
            if (train.getRoute().getStations().get(train.getRoute().getStations().size() - 1).equals(station)) {
                filteredTrains.add(train);
            }
        }
        Train[] array = (Train[]) filteredTrains.toArray();
        return array;
    }

    public Train[] filterByDepartureTime(int[] time) {
        ArrayList<Train> filteredTrains = new ArrayList<Train>();
        for (Train train : Main.trains) {
            if (train.getDepartureTime().getHour() == time[0] && train.getDepartureTime().getMinute() == time[1]) {
                filteredTrains.add(train);
            }
        }
        Train[] array = (Train[]) filteredTrains.toArray();
        return array;
    }

    public Train[] filterByTrainType(String trainType) {
        ArrayList<Train> filteredTrains = new ArrayList<Train>();
        for (Train train : Main.trains) {
            if (train.getRoute().getName().equals(trainType)) {
                filteredTrains.add(train);
            }
        }
        Train[] array = (Train[]) filteredTrains.toArray();
        return array;
    }

    public Train[] filterByStopsStation(Station station) {
        ArrayList<Train> filteredTrains = new ArrayList<Train>();
        for (Train train : Main.trains) {
            if (train.getRoute().getStations().contains(station)) {
                filteredTrains.add(train);
            }
        }
        Train[] array = (Train[]) filteredTrains.toArray();
        return array;
    }

    public void printTrainInfo(Train[] trains) {
        String inputKey_tmp[] = new String[trains.length];
        String inputValue_tmp[] = new String[trains.length];
        for (int i = 0; i < trains.length; i++) {
            inputKey_tmp[i] = Integer.toString(i);
            inputValue_tmp[i] = trains[i].getName();
        }
        CONTINUE: while (true) {
            System.out.println("==該当列車==");
            for (Train train : trains) {
                System.out.println(train.getName() + " " + train.getRoute().getName() + train.getDepartureStation()
                        + train.getDepartureTime() + "発" + " " + train.getArrivalStation() + "行き");
            }
            System.out.println("詳細を表示しますか？");
            Scanner scanner = new Scanner(System.in);
            String yesOrNo[] = getInput(scanner, new String[] { "1", "2" }, new String[] { "はい", "いいえ", });
            switch (Integer.parseInt(yesOrNo[0])) {
                case 1:
                    String selectedTrainStr[] = getInput(scanner, inputKey_tmp, inputValue_tmp);
                    Train selectedTrain = convertStringToTrain(selectedTrainStr[1]);
                    printTimetable(selectedTrain);
                    break;
                case 2:
                    break CONTINUE;
                default:
                    System.err.println("Error: yesOrNo incorrect");
                    System.exit(0);
            }
        }
    }

    public Train convertStringToTrain(String string) {
        Train selectedTrain;
        for (int i = 0; i < Main.trains.length; i++) {
            if (string.equals(Main.trains[i].getName())) {
                selectedTrain = Main.trains[i];
                return selectedTrain;
            }
        }
        System.out.println("Error: selectedStation is null");
        System.exit(0);
        return null;
    }

    public void printTimetable(Train train) {
        System.out.println(train.getName() + " (" + train.getRoute().getName() + ")");
        LocalTime time = train.getDepartureTime();
        List<Station> stations = train.getRoute().getStations();
        for (int i = 0; i < stations.size() - 1; i++) {
            StationPair stationPair = new StationPair(stations.get(i), stations.get(i + 1));
            System.out.println(stationPair.getFrom().getName() + " " + time);
            time = time.plusMinutes(train.getRoute().getTravelTimes().get(stationPair));
        }
        // 終点の到着時間を表示する
        Station lastStation = stations.get(stations.size() - 1);
        System.out.println(lastStation.getName() + " " + time);
        System.out.println();
    }

    public void printCongestionInfo(Train train) {
        System.out.println(train.getName() + " (" + train.getRoute().getName() + ")");
        int totalPassengers = 0;
        for (int i = 0; i < train.getRoute().getStations().size() - 1; i++) {
            StationPair stationPair = new StationPair(train.getRoute().getStations().get(i),
                    train.getRoute().getStations().get(i + 1));
            PassengerFlow passengers = train.getRoute().getPassengerFlows().get(stationPair.getFrom());
            int passengersIn = passengers.getPassengersIn();
            int passengersOut = passengers.getPassengersOut();
            totalPassengers += passengersIn - passengersOut;
            double congestionRate = (double) totalPassengers / train.getRoute().getMaxPassengers() * 100;
            System.out.println(stationPair.getFrom().getName() + " - " + stationPair.getTo().getName() + ": "
                    + congestionRate + "%");
        }
    }

    public void printTimetable(Train[] trains) {
        System.out.println("=== 時刻表 ===");
        for (Train train : trains) {
            printTimetable(train);
        }
        System.out.println();
    }

    public static void printCongestionInfo(Train[] trains) {
        System.out.println("=== 列車混雑情報 ===");
        for (Train train : trains) {
            //printCongestionInfo(train);///実装必須
        }
        System.out.println();
    }

    public void executeDisplayConditionMenu(Scanner scanner) {

    }

    public String[] getInput(Scanner scanner, String[] inputKeys, String[] inputValues) {
        String tempLine = "";
        int index;
        while (true) {
            for (int i = 0; i < inputKeys.length; i++) {
                System.out.print(inputKeys[i]);
                System.out.println("(" + inputValues[i] + ")");
                if (i > inputKeys.length - 1) {
                    System.out.println(":");
                }
            }
            tempLine = scanner.nextLine();
            index = Arrays.asList(inputKeys).indexOf(tempLine);
            if (index != -1) {
                break;
            }
            System.out.println("入力が正しくありません");
        }
            return new String[] {inputKeys[index], inputValues[index]};
        }

    public static int[] getTimeInput(Scanner scanner, String message) {
        int time[] = new int[2];
        while (true) {
            System.out.println(message);
            String departureTime = scanner.next();
            if (departureTime.matches("\\d{2}:\\d{2}")) {
                int hh = Integer.parseInt(departureTime.split(":")[0]);
                int mm = Integer.parseInt(departureTime.split(":")[1]);
                if (hh >= 0 && hh <= 23 && mm >= 0 && mm <= 59) {
                    time[0] = hh;
                    time[1] = mm;
                    break;
                } else {
                    System.out.println("不正な入力です。hh:mmの形式で入力してください。");
                }
            } else {
                System.out.println("不正な入力です。hh:mmの形式で入力してください。");
            }
        }
        return time;
    }
}