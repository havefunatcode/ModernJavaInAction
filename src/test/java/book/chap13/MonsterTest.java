package book.chap13;

import org.junit.jupiter.api.Test;

public class MonsterTest {
    @Test
    void monsterTest() {
        Monster monster = new Monster();
        monster.rotateBy(180);
        monster.moveVertically(10);
    }
}
