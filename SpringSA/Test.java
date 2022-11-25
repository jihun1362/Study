package SpringS.A;

public class Test {
    public static void main(String[] args) {
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();

        bus1.driveStart();
        bus2.driveStart();
        bus1.passengerBoarding(2);
        bus1.getOffABus(2);
        bus1.oil(-50);
        bus1.setCondtion("차고지행");
        bus1.oil(10);
        bus1.setCondtion("운행중");
        bus1.passengerBoarding(45);
        bus1.passengerBoarding(5);
        bus1.getOffABus(5);
        bus1.oil(-55);

        System.out.println("---------------------------------------------------------");

        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        taxi1.driveStart();
        taxi2.driveStart();
        taxi1.passengerBoarding(2,"서울역",2);
        taxi1.oil(-80);
        taxi1.getOffABus(2);
        taxi1.charge();
        taxi1.passengerBoarding(5);
        taxi1.passengerBoarding(3,"구로디지털단지",12);
        taxi1.oil(-20);
        taxi1.getOffABus(3);
        taxi1.charge();
    }
}
