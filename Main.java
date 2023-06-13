import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 駅の定義
    private static Station Tokyo = new Station("Tokyo", "Kanto");
    private static Station Shinagawa = new Station("Shinagawa", "Kanto");
    private static Station ShinYokohama = new Station("Shin-Yokohama", "Kanto");
    private static Station Odawara = new Station("Odawara", "Kanto");
    private static Station Atami = new Station("Atami", "Kanto");
    private static Station Mishima = new Station("Mishima", "Kanto");
    private static Station ShinFuji = new Station("Shin-Fuji", "Kanto");
    private static Station Shizuoka = new Station("Shizuoka", "Chubu");
    private static Station Kakegawa = new Station("Kakegawa", "Chubu");
    private static Station Hamamatsu = new Station("Hamamatsu", "Chubu");
    private static Station Toyohashi = new Station("Toyohashi", "Chubu");
    private static Station MikawaAnjo = new Station("Mikawa-Anjo", "Chubu");
    private static Station Nagoya = new Station("Nagoya", "Chubu");
    private static Station Gifuhashima = new Station("Gifuhashima", "Chubu");
    private static Station Maibara = new Station("Maibara", "Kansai");
    private static Station Kyoto = new Station("Kyoto", "Kansai");
    private static Station ShinOsaka = new Station("ShinOsaka", "Kansai");

    // 路線の定義
    private static Route Nozomi = new Route("Nozomi");
    private static Route HikariNoShizuoka = new Route("HikariNoShizuoka");
    private static Route HikariStopsShizuoka = new Route("HikariStopsShizuoka");
    private static Route Kodama = new Route("Kodama");

    private static Route RouteList[] = { Nozomi, HikariNoShizuoka, HikariStopsShizuoka, Kodama };

    private static Train[] trains;

    private static Station[] AllStaions = { Tokyo, Shinagawa, ShinYokohama, Odawara, Atami, Mishima, ShinFuji, Shizuoka,
            Kakegawa, Hamamatsu, Toyohashi, MikawaAnjo, Nagoya, Gifuhashima, Maibara, Kyoto, ShinOsaka };

    public static void main(String[] args) {
        // 用意された列車データの格納
        DefineDatas();
        trains = defineTrains();

        // オプションとプログラムの実行
        boolean continueIs = true;
        Scanner scanner = new Scanner(System.in);
        while (continueIs) {
            displayOption(0);
            continueIs = getInput(scanner, 0);
        }
    }

    public static void displayOption(int displayFlag) {
        switch (displayFlag) {
            case 0:
                System.out.println("1. 時刻表の表示");
                System.out.println("2. 混雑度の表示");
                System.out.println("3. 終了");
                break;
            case 1:
                System.out.println("1.発車駅から絞り込み");
                System.out.println("2.到着駅から絞り込み");
                System.out.println("3.発車時間から絞り込み");
                System.out.println("4.到着時間から絞り込み");
                System.out.println("5.列車タイプから絞り込み");
                System.out.println("6.到着駅から絞り込み");
                break;
            case 2:// 全駅リストの選択肢を表示
                for (int i = 0; i < AllStaions.length; i++) {
                    System.out.println(i + "." + AllStaions[i].getName());
                }
                break;
            case 3:// 全路線リストの選択肢を表示
                for (int i = 0; i < RouteList.length; i++) {
                    System.out.println(i + "." + RouteList[i].getName());
                }
                break;
            default:
                System.err.println("Error: displayFlag incorrect");
                System.exit(0);
        }
    }

    public static boolean getInput(Scanner scanner, int getInputFlag) {
        int input = scanner.nextInt();
        switch (getInputFlag) {
            case 0:
                switch (input) {
                    case 1:
                        displayOption(1);
                        getInput(scanner, 1);
                        printTimetable(trains);
                        return true;
                    case 2:
                        displayOption(1);
                        getInput(scanner, 1);
                        printCongestionInfo(trains);
                        return true;
                    case 3:
                        System.out.println("終了します");
                        scanner.close();
                        return false;
                    default:
                        System.out.println("1~3の数字を入力してください");
                        return true;
                }
            case 1:/*ここの処理を書く必要があります。スパゲッティコード警報発令*/
                switch (input) {
                    case 1:
                        printTimetable(trains);
                        return true;
                    case 2:
                        System.out.println("発車駅を入力してください");
                        displayOption(2);
                        String departureStation = scanner.next();
                        printTimetable(trains);
                        return true;
                    case 3:
                        System.out.println("到着駅を入力してください");
                        displayOption(2);
                        String arrivalStation = scanner.next();
                        printTimetable(trains);
                        return true;
                    case 4:
                        System.out.println("発車時間を入力してください");
                        /*
                         * ここに発車時間の入力を受け付ける処理を書く
                         */
                        String departureTime = scanner.next();
                        printTimetable(trains);
                        return true;
                    case 5:
                        System.out.println("到着時間を入力してください");
                        /*
                         * ここに到着時間の入力を受け付ける処理を書く
                         */
                        String arrivalTime = scanner.next();
                        printTimetable(trains);
                        return true;
                    case 6:
                        System.out.println("列車タイプを入力してください");
                        displayOption(3);
                        String trainType = scanner.next();
                        printTimetable(trains);
                        return true;
                    case 7:
                        System.out.println("到着駅を入力してください");
                        displayOption(2);
                        String StopStation = scanner.next();
                        printTimetable(trains);
                        return true;
                    default:
                        System.out.println("1~6の数字を入力してください");
                        return true;
                }
            case 2:
                if(input < AllStaions.length && input >= 0){
                    /*
                     * ここに処理を書く
                     */
                    return true;
                }else if(input < 0){
                    System.out.println("0以上の数字を入力してください");
                    return true;
                }else{
                    /*
                     * ここに処理を書く
                     */
                    return false;
                }
            default:
                System.err.println("Error: getInputFlag incorrect");
                System.exit(0);
                return false;
        }
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

    public static Train[] defineTrains() {
        Train Train1 = new Train("Nozomi1Gou", Nozomi, LocalTime.of(6, 0));
        Train Train2 = new Train("Nozomi3Gou", Nozomi, LocalTime.of(6, 15));
        Train Train3 = new Train("Hikari631Gou", HikariNoShizuoka, LocalTime.of(6, 21));
        Train Train4 = new Train("Nozomi103", Nozomi, LocalTime.of(6, 24));
        Train Train5 = new Train("Kodama701Gou", Kodama, LocalTime.of(6, 30));
        Train Train6 = new Train("Nozomi5Gou", Nozomi, LocalTime.of(6, 33));
        Train Train7 = new Train("Nozomi201Gou", Nozomi, LocalTime.of(6, 42));
        Train Train8 = new Train("Nozomi287Gou", Nozomi, LocalTime.of(6, 45));
        Train Train9 = new Train("Nozomi7Gou", Nozomi, LocalTime.of(6, 51));
        Train Train10 = new Train("Kodama703Gou", Kodama, LocalTime.of(6, 57));
        Train Train11 = new Train("Nozomi203Gou", Nozomi, LocalTime.of(7, 0));
        Train Train12 = new Train("Nozomi107Gou", Nozomi, LocalTime.of(7, 0));

        Train trains[] = { Train1, Train2, Train3, Train4, Train5, Train6, Train7, Train8, Train9, Train10, Train11,
                Train12 };
        return trains;
    }

    public static void DefineDatas() {
        // 停車駅の定義
        Station NozomiStop[] = { Tokyo, Shinagawa, ShinYokohama, Nagoya, Kyoto, ShinOsaka };
        Station HikariNoShizuokaStop[] = { Tokyo, Shinagawa, ShinYokohama, Toyohashi, Nagoya, Gifuhashima,
                Maibara, Kyoto, ShinOsaka };
        Station HikariStopsShizuokaStop[] = { Tokyo, Shinagawa, ShinYokohama, Shizuoka, Hamamatsu, Nagoya,
                Kyoto, ShinOsaka };
        Station KodamaStop[] = { Tokyo, Shinagawa, ShinYokohama, Odawara, Atami, Mishima, ShinFuji, Shizuoka,
                Kakegawa, Hamamatsu, Toyohashi, MikawaAnjo, Nagoya, Gifuhashima, Maibara, Kyoto, ShinOsaka };
        Station StopsList[][] = { NozomiStop, HikariNoShizuokaStop, HikariStopsShizuokaStop, KodamaStop };

        // 駅間移動所要時間(分単位)定義
        int NozomiTravelTimes[] = { 7, 11, 83, 35, 24 };
        int HikariNoShizuokaTravelTimes[] = { 7, 11, 16, 67, 16, 18, 20, 14 };
        int HikariStopsShizuokaTravelTimes[] = { 7, 11, 46, 24, 30, 40, 14 };
        int KodamaTravelTimes[] = { 7, 11, 20, 8, 12, 13, 13, 15, 15, 17, 17, 12, 15, 18, 20, 15 };
        int TravelTimesList[][] = { NozomiTravelTimes, HikariNoShizuokaTravelTimes, HikariStopsShizuokaTravelTimes,
                KodamaTravelTimes };

        // 各駅乗降人数定義({乗車人数,降車人数})
        int NozomiPassengers[][] = { { 1100, 0 }, { 300, 100 }, { 250, 150 }, { 200, 500 }, { 300, 300 }, { 0, 1000 } };
        int HikariNoShizuokaPassengers[][] = { { 800, 0 }, { 400, 100 }, { 250, 250 }, { 150, 200 }, { 350, 350 },
                { 150, 100 }, { 200, 150 }, { 500, 300 }, { 0, 700 } };
        int HikariStopsShizuokaPassengers[][] = { { 1000, 0 }, { 300, 100 }, { 250, 150 }, { 150, 150 }, { 150, 100 },
                { 250, 400 }, { 300, 200 }, { 0, 1000 } };
        int KodamaPassengers[][] = { { 900, 0 }, { 250, 100 }, { 200, 150 }, { 80, 80 }, { 80, 40 }, { 40, 40 },
                { 40, 40 }, { 120, 80 }, { 40, 40 }, { 120, 80 }, { 80, 120 }, { 40, 40 }, { 160, 240 }, { 80, 80 },
                { 120, 160 }, { 240, 400 }, { 0, 900 } };
        int PassengersList[][][] = { NozomiPassengers, HikariNoShizuokaPassengers, HikariStopsShizuokaPassengers,
                KodamaPassengers };

        // データをコンストラクタに当てはめ
        for (int i = 0; i < RouteList.length; i++) {
            DefineStops(RouteList[i], StopsList[i]);
            DefineTravelTimes(RouteList[i], TravelTimesList[i]);
            DefinePassengerFlows(RouteList[i], StopsList[i], PassengersList[i]);
        }
    }

    // 列車と駅を紐づけ
    public static void DefineStops(Route route, Station[] stops) {
        for (Station Stop : stops) {
            Stop.addRoute(route);
            route.addStation(Stop);
        }
    }

    // 駅間移動所要時間を代入
    public static void DefineTravelTimes(Route route, int[] travelTimes) {
        for (int i = 0; i < travelTimes.length; i++) {
            route.addTravelTime(route.getStations().get(i), route.getStations().get(i + 1), travelTimes[i]);
        }
    }

    // 各駅乗降者人数を代入
    public static void DefinePassengerFlows(Route route, Station[] stops, int[][] passengers) {
        for (int i = 0; i < passengers.length; i++) {
            route.addPassengerFlow(route.getStations().get(i),
                    new PassengerFlow(passengers[i][0], passengers[i][1]));
        }
    }
}