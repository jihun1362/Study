package SpringS.A;

public class Bus extends PublicTransportation {
    static int i = 1;

    public Bus() {
        setCondtion("운행중");
        setMaxPassenger(30);
        setCharge(1000);
        setCarNumber(i++);
    }


    @Override
    public void driveStart() {
        System.out.println(getCarNumber() + "번 버스 운행을 시작합니다.");
    }

    @Override
    public void oil(int oil) {
        setOil(oil);

        if (oil > 0) {
            System.out.println("상태 = " + getCondtion());
            System.out.println("주유량 = " + getOil());
        } else if (getOil() < 10) {
            setCondtion("차고지행");
            System.out.println("주유량 = " + getOil());
            System.out.println("상태 = " + getCondtion());
            System.out.println("※주유 필요");
        } else {
            System.out.println("주유량 = " + getOil());
        }
    }

    @Override
    public void speedShift(int changeSpeed) {
        super.speedShift(changeSpeed);
    }

    @Override
    public void passengerBoarding(int passenger) {
        if (passenger > getMaxPassenger()) {
            System.out.println("※최대 승객 수 초과");
        } else {
            setNowPassenger(passenger);
            if (getNowPassenger() > getMaxPassenger()) {
                System.out.println("※최대 승객 수 초과");
            } else {
                System.out.println("승객이 " + getCarNumber() + "번 버스에 탑승합니다.");
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = " + (getMaxPassenger() - getNowPassenger()));
                System.out.println("요금은 = " + (getCharge() * passenger));
            }
        }
    }

    @Override
    public void getOffABus(int passenger) {
        System.out.println("승객이 " + getCarNumber() + "번 버스에서 하차합니다.");
        setNowPassenger(-passenger);
        System.out.println("잔여 승객 수 = " + (getMaxPassenger() - getNowPassenger()));
    }
}
