package SpringS.A;

public class PublicTransportation {
    //요소
    private int carNumber;
    private int oil = 100;

    private int speed = 0;
    private int charge;
    private int maxPassenger;
    private int nowPassenger;
    private String condtion;


    //생성자
    public PublicTransportation() {
    }

    //현재승객
    public int getNowPassenger() {
        return nowPassenger;
    }

    public void setNowPassenger(int nowPassenger) {
        this.nowPassenger += nowPassenger;
    }

    //속도
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed += speed;
    }

    //주유량
    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil += oil;
    }

    //차량번호
    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    //최대 승객
    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    //탑승비용
    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }


    //주 기능
    //운행시작
    public void driveStart() {
        System.out.println("운행을 시작합니다.");
    }

    //상태변경
    public String getCondtion() {
        return condtion;
    }

    public void setCondtion(String condtion) {
        this.condtion = condtion;
    }

    //속도변경
    public void speedShift(int changeSpeed) {
        if (getOil() < 10) {
            System.out.println("주유량 = " + getOil());
            System.out.println("상태 = 운행불가");
        }else {
            setSpeed(changeSpeed);
        }

    }

    //오일변경
    public void oil(int oil) {
        setOil(oil);
        if (oil > 0) {
            System.out.println("상태 = " + getCondtion());
            System.out.println("주유량 = " + getOil());
        } else if (getOil() < 10) {
            System.out.println("주유량 = " + getOil());
            System.out.println("상태 = " + getCondtion());
            System.out.println("※주유 필요");
        } else {
            System.out.println("주유량 = " + getOil());
        }
    }


    //승객탑승
    public void passengerBoarding(int passenger) {
        if (passenger > getMaxPassenger()) {
            System.out.println("※최대 승객 수 초과");
        } else {
            setNowPassenger(passenger);
            if (getNowPassenger() > getMaxPassenger()) {
                System.out.println("※최대 승객 수 초과");
            } else {
                System.out.println("승객이 탑승합니다.");
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = " + (getMaxPassenger() - getNowPassenger()));
                System.out.println("요금은 = " + (getCharge() * passenger));
            }
        }
    }

    public void passengerBoarding(int passenger, String destination, int distance) {
    }

    //승객하차
    public void getOffABus(int passenger) {
        System.out.println("승객이 내립니다.");
        setNowPassenger(-passenger);
        System.out.println("잔여 승객 수 = " + (getMaxPassenger() - getNowPassenger()));
    }
}
