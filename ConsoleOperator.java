import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleOperator {

    public boolean execute() {
        Scanner scanner = new Scanner(System.in);
        String action = getInput(scanner, new String[] { "1", "2", "3" },
                new String[] { "列車の時刻表を表示する", "列車の時刻表を検索する", "終了" });
        switch (Integer.parseInt(action)) {
            case 1:
                String displayBy = getInput(scanner, new String[] { "1", "2", "3", "4", "5", "6", "7" },
                        new String[] { "全ての列車を表示", "発車駅から絞り込み", "到着駅から絞り込み", "発車時間から絞り込み", "到着時間から絞り込み",
                                "列車タイプから絞り込み", "停車駅から絞り込み" });
                String inputKey_tmp[] = new String[Main.AllStations.length];
                String inputValue_tmp[] = new String[Main.AllStations.length];
                for (int i = 0; i < Main.AllStations.length; i++) {
                    inputKey_tmp[i] = Integer.toString(i);
                    inputValue_tmp[i] = Main.AllStations[i].getName();
                }
                switch (Integer.parseInt(displayBy)) {
                    case 1:
                        printTrainInfo(Main.trains);/// 実装
                        break;
                    case 2:
                        String selectedStation = getInput(scanner, inputKey_tmp, inputValue_tmp);
                        filteredTrains[] = filterByDepartureStation(selectedStation);
                        printTrainInfo(filteredTrains);
                        break;
                    case 3:
                        String selectedStation = getInput(scanner, inputKey_tmp, inputValue_tmp);
                        filteredTrains = filterByArrivalStation(selectedStation);
                        printTrainInfo(filteredTrains);
                        break;
                    case 4:
                        int[] departureTime = getTimeInput(scanner, "発車時間を入力してください");
                        filteredTrains[] = filterByDepartureTime(departureTime);
                        printTrainInfo(filteredTrains);
                        break;
                    case 5:
                        int[] arrivalTime = getTimeInput(scanner, "到着時間を入力してください");
                        filteredTrains[] = filterByArrivalTime(arrivalTime);
                        printTrainInfo(filteredTrains);
                        break;
                    case 6:
                        
                        String selectedTrainType = getInput(scanner, new String[] { "1", "2", "3", "4" }, Main.RouteList);
                        filteredTrains[] = filterByTrainType(selectedTrainType);
                        printTrainInfo(trains);
                        break;
                    case 7:
                        String selectedStation = getInput(scanner, inputKey_tmp, inputValue_tmp);
                        filteredTrains = filterByStopsStation(selectedStation);
                        printTrainInfo(filteredTrains);
                        break;
                    default:
                        System.err.println("Error: displayBy incorrect");
                        System.exit(0);
                }
                break;
            case 2:
                break;
            case 3:
                System.out.println("終了します");
                return false;
        }
    }

    public String getInput(Scanner scanner, String[] inputKeys, String[] inputValues) {
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
            index = Arrays.asList(inputValues).indexOf(tempLine);
            if (index != -1) {
                break;
            }
            System.out.println("入力が正しくありません");
        }
        return inputValues[index];
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

    public static void printTimetable(Train train) {
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

    public static void printCongestionInfo(Train train) {
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
        System.out.println();
    }

    public static void printTimetable(Train[] trains) {
        System.out.println("=== 時刻表 ===");
        for (Train train : trains) {
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
    }

    public static void printCongestionInfo(Train[] trains) {
        System.out.println("=== 列車混雑情報 ===");
        for (Train train : trains) {
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
            System.out.println();
        }
    }
}