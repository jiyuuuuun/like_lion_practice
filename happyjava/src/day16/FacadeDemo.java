package happyjava.src.day16;

//홈시어터
class Projector{
    public void on(){
        System.out.println("프로젝터를 켭니다");
    }

    public void setInput(String source){
        System.out.println("프로젝터 입력을 "+ source + "로 설정합니다.");
    }
}
class 전동커튼{
    public void on(){
        System.out.println("전동커튼이 열립니다.");
    }
    public void off(){
        System.out.println("커튼을 닫습니다.");
    }
}
class Amplifier{
    public  void on(){
        System.out.println("앰프를 켭니다. ");
    }
    public void setVolume(int level){
        System.out.println("볼륨을 "+ level + "로 설정합니다. ");
    }
}

class MoviePlayer{
    public void on(){
        System.out.println("MoviePlayer를 켭니다.");
    }
    public void play(String movie){
        System.out.println("영화 "+ movie + " 를 재생합니다. ");
    }
}

class HomeTheaterFacade{
    private 전동커튼 electricCurtain;
    private MoviePlayer moviePlayer;
    private Amplifier amplifier;
    private Projector projector;

    public HomeTheaterFacade(전동커튼 electricCurtain, MoviePlayer moviePlayer, Amplifier amplifier, Projector projector) {
        this.electricCurtain=electricCurtain;
        this.moviePlayer=moviePlayer;
        this.amplifier=amplifier;
        this.projector=projector;
    }
    public void watchMovie(String movie){
        System.out.println("영화를 보기 위한 준비를 시작합니다");
        electricCurtain.off();
        projector.on();
        projector.setInput("넷플릭스");
        amplifier.on();
        amplifier.setVolume(5);
        moviePlayer.on();
        moviePlayer.play(movie);
        System.out.println("영화를 보기 위한 준비가 끝났습니다");
    }
    public void endMovie(){
        System.out.println("영화가 끝났습니다 ");
        System.out.println("장비를 모두 종료합니다");
        //종료 메서드
    }

}
public class FacadeDemo {
    public static void main(String[] args) {
       전동커튼 electricCurtain=new 전동커튼();
       MoviePlayer moviePlayer=new MoviePlayer();
       Amplifier amplifier=new Amplifier();
       Projector projector=new Projector();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(electricCurtain, moviePlayer, amplifier, projector);
        homeTheaterFacade.watchMovie("해리포터");
        homeTheaterFacade.endMovie();
    }
}