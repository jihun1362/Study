package SpringS.A;

public class Taxi extends PublicTransportation{
    static int i=1;
    private String destination;
    private int distance;
    private int distanceExtraCost;
    private int totalCharge;

    public Taxi() {
        setCondtion("일반");
        setMaxPassenger(4);
        setCharge(3000);
        setCarNumber(i++);
        setDistanceExtraCost(1000);
        setDistance(1);
    }

    public int getTotalCharge() {
        return totalCharge;
    }
    public void setTotalCharge(int totalCharge) {
        this.totalCharge = totalCharge;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDistanceExtraCost() {
        return distanceExtraCost;
    }
    public void setDistanceExtraCost(int distanceExtraCost) {
        this.distanceExtraCost = distanceExtraCost;
    }

    @Override
    public void driveStart() {
        System.out.println(getCarNumber()+"번 택시 운행을 시작합니다.");
    }


    public void charge(){
        if (getOil()<10){
            setCondtion("운행불가");
            System.out.println("주유량 = " + getOil());
            System.out.println("상태 = "+getCondtion());
            System.out.println("누적 요금 = " + getTotalCharge());
            System.out.println("※주유 필요");
        }else {
            System.out.println("주유량 = " + getOil());
            System.out.println("누적 요금 = " + getTotalCharge());
        }
    }
    @Override
    public void oil(int oil) {
        setOil(oil);
    }

    @Override
    public void speedShift(int changeSpeed) {
        super.speedShift(changeSpeed);
    }

    public void passengerBoarding(int passenger, String destination, int distance) {
        setDestination(destination);
        if (passenger>getMaxPassenger()) {
            System.out.println("※최대 승객 수 초과");
        }else {
            setNowPassenger(passenger);
            if (getNowPassenger() > getMaxPassenger()) {
                System.out.println("※최대 승객 수 초과");
            } else {
                System.out.println("승객이 "+getCarNumber()+"번 택시에 탑승합니다.");
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = " + (getMaxPassenger() - getNowPassenger()));
                System.out.println("기본 요금 확인 = " + (getCharge()));
                System.out.println("목적지 = "+getDestination());
                System.out.println("목적지까지 거리 = "+distance+"km");
                System.out.println("지불할 요금 = "+(getCharge()+((distance-getDistance())*getDistanceExtraCost())));
                setCondtion("운행중");
                System.out.println("상태 = "+getCondtion());
                setTotalCharge((getCharge()+((distance-getDistance())*getDistanceExtraCost())));
            }
        }
    }

    @Override
    public void getOffABus(int passenger) {
        System.out.println("승객이 "+getCarNumber()+"번 택시에서 내립니다.");
        setNowPassenger(-passenger);
        System.out.println("잔여 승객 수 = " + (getMaxPassenger() - getNowPassenger()));
        setCondtion("일반");
        System.out.println("상태 = "+getCondtion());
    }
}
