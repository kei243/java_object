package churimon;

class Fushigiyade extends Monster3{
    
    // コンストラクタ
    Fushigiyade(){
		super.setCharacter("フシギヤデ");
    }

    Fushigiyade(String tr, String nm){
        super(tr, nm);
        super.setCharacter("フシギヤデ");
    }

    Fushigiyade(String tr, String nm, int lv){
        super(tr, nm, lv);
        super.setCharacter("フシギヤデ");
    }

    public void levelUp(int up){
        setLv(getLv() + 1  * (up));   // レベル
        setHp(getHp() + 31 * (up));   // HP
        setAtk(getAtk() + 6  * (up)); // こうげき
        setDef(getDef() + 7  * (up)); // ぼうぎょ
        setSpd(getSpd() + 8  * (up)); // すばやさ 
        setHpMax(getHpMax());         // HP初期値 
    }
}
