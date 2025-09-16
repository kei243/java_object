package churimon;

class Hitokake extends Monster3{
    // コンストラクタ
    Hitokake(){
		super.setCharacter("ヒトカケ");
    }

    Hitokake(String tr, String nm){
        super(tr, nm);
        super.setCharacter("ヒトカケ");
    }

    Hitokake(String tr, String nm, int lv){
        super(tr, nm, lv);
        super.setCharacter("ヒトカケ");
    }


    public void levelUp(int up){
        setLv(getLv() + 1  * (up));   // レベル
        setHp(getHp() + 29 * (up));   // HP
        setAtk(getAtk() + 8  * (up)); // こうげき
        setDef(getDef() + 5  * (up)); // ぼうぎょ
        setSpd(getSpd() + 9  * (up)); // すばやさ 
        setHpMax(getHpMax());         // HP初期値 
    }
}
