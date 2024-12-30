package happyjava.src.day15;

//기존 전자기기의 인터페이스
interface ElectronicDevice{
    void turnOn();

}
class OldDevice implements ElectronicDevice{
    @Override
    public void turnOn(){
        System.out.println("기존 전자기기가 켜집니다 ");
    }
}
//새로운 전자기기
class NewDevice {
    public void powerOn(){
        System.out.println("새로운 전자기기가 켜집니다");
    }

}

//Device 어댑터
class DeviceAdapter implements ElectronicDevice {
    NewDevice newDevice =new NewDevice();

    DeviceAdapter(NewDevice newDevice) {
        this.newDevice=newDevice;
    }
    @Override
    public void turnOn(){
        newDevice.powerOn();
    }

}


public class AdapterExam {
    public static void main(String[] args) {
        //기존 전자기기
        OldDevice oldDevice = new OldDevice();
        oldDevice.turnOn();

        System.out.println("=======================");
        NewDevice newDevice = new NewDevice();
        DeviceAdapter deviceAdapter=new DeviceAdapter(newDevice);
        deviceAdapter.turnOn();



    }
}
