package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

import java.util.List;

@ComponentScan(basePackages = "sample") //sample 패키지 아래
@PropertySource({"classpath:game.properties"})
public class GameConfig {

//    @Bean
//    public Dice dice(@Value("${face}")int face) {
//        return new Dice(face);
//    }
    @Bean
    public Player kang(Dice d) {
        //Player player=new Player(d); 생성자 주입
        Player player = new Player();
        player.setDice(d);
        player.setName("Kang");
        return player;
    }

    @Bean
    public Player hwang(Dice d) {
        //Player player=new Player(d); 생성자 주입
        Player player = new Player();
        player.setDice(d);
        player.setName("hwang");
        return player;
    }
    @Bean
    public Player kim(Dice d) {
        //Player player=new Player(d); 생성자 주입
        Player player = new Player();
        player.setDice(d);
        player.setName("kim");
        return player;
    }

    @Bean
    public Game game(List<Player> players) {
        Game game = new Game();
        game.setList(players);
        return game;

    }

}
