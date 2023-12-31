import java.time.LocalTime;

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

    public static Route RouteList[] = { Nozomi, HikariNoShizuoka, HikariStopsShizuoka, Kodama };

    public static Train[] trains;

    public static Station[] AllStations = { Tokyo, Shinagawa, ShinYokohama, Odawara, Atami, Mishima, ShinFuji, Shizuoka,
            Kakegawa, Hamamatsu, Toyohashi, MikawaAnjo, Nagoya, Gifuhashima, Maibara, Kyoto, ShinOsaka };

    public static void main(String[] args) {
        // 用意された列車データの格納
        DefineDatas();
        trains = defineTrains();
        // ユーザインターフェースの実行
        ConsoleOperator co = new ConsoleOperator();
        boolean continueIs = true;
        while(continueIs){
            continueIs = co.execute();
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