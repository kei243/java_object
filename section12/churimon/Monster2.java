package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster2 {
        // フィールド
    String character; // 種族
    String trainer; // トレーナー
    String name; // なまえ
    int    lv;  // レベル
    int    hp;  // HP
    int    atk; // こうげき
    int    def; // ぼうぎょ
    int    spd; // すばやさ
    int    hpMax; // HP初期値
    String wazaNm; // わざ（なまえ）
    String wazaDmgRate; // わざ（ダメージ倍率）

	final String WAZA_DMG_RATE_REGEXP = "^[0-9]+\\.[0-9]$";  // 技セット時のバリデーションチェックで使用
	final String DMG_CORRECTION_120 = "120";                 // ダメージ計算の補正で使う数字
	final String DMG_CORRECTION_1   = "1";                   // ダメージ計算の補正で使う数字

    // コンストラクタ（初期化）
    Monster2(){
        String character = "(unknown)"; // 種族
        String trainer = "(wild)"; // トレーナー
        String name = "(noname)"; // なまえ
        int    lv = 1;    // レベル
        int    hp = 80;  // HP
        int    atk = 15; // こうげき
        int    def = 10; // ぼうぎょ
        int    spd = 10; // すばやさ
        int    hpMax = 80; // HP初期値
        String wazaNm = "たいあたり"; // わざ（なまえ）
        String wazaDmgRate = "1.0"; // わざ（ダメージ倍率）
    }

    Monster2(String tr, String nm){
        this();
        this.trainer = tr; // トレーナー
        this.name = nm; // なまえ
    }

    Monster2(String tr, String nm, int lv){
        this(tr, nm);
        if (lv > 1) {
            // levelUpでステータスを上げる
            levelUp(lv - 1);
        }
    }

    	// toStringメソッド
	// フィールドのすべての値を返す（動作確認用）
	public String toString(){
		// String status = "[ " +  name  + " lv" + lv  + " HP" + hp + "/" + hpMax
		//                 + " ] (status) character:" + character + " trainer:" + trainer
		//                 + " atk:" + atk + " def:" + def + " spd:" + spd + " wazaNm:"
		//                 + wazaNm + " wazaDmgRate:" + wazaDmgRate ;
		String status = "<フィールド確認> character:" +  character  + "/ trainer:" + trainer 
                        + "/ name:" + name +"/ lv" + lv  + "/ HP" + hp + " atk:" + atk
                        + " def:" + def + " spd:" + spd + "/ hpMax:" + hpMax  + "/ wazaNm:"
		                + wazaNm + " wazaDmgRate:" + wazaDmgRate ;
		return status;
	}

    // レベルアップメソッド
    // レベルアップ時のステータスを調整している
    void levelUp(int up){
        lv    = lv + 1 * up;
		hpMax = hpMax + 30 * up;
		atk   = atk + 5 * up;
		def   = def + 5 * up;
		spd   = spd + 5 * up;
		hp    = hpMax;
    }

    // 技をセットするメソッド
    void setWaza(String wnm, String wdmr){
		if(wdmr.matches(WAZA_DMG_RATE_REGEXP)){
			wazaNm  = wnm;
			wazaDmgRate = wdmr;
		}else{
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
    }

    // ステータスを取得するメソッド
    String getStatus(){
        String status = "[" + name + " lv" + lv + " HP" + hp + "/" + hpMax + "]";
        return status;
    }

    // 技を使用したとき、相手に与えるダメージを計算するメソッド
    int useWaza(){
        BigDecimal bdAtk  = new BigDecimal(atk);
		BigDecimal bdDmrt = new BigDecimal(wazaDmgRate);
        int damage = (bdAtk.multiply(bdDmrt)).intValue();
        return damage;
    }
    
    int damaged(int damage){

        BigDecimal temporaryDamage = new BigDecimal(damage);
		BigDecimal bdDmCr1         = new BigDecimal(DMG_CORRECTION_1);
		BigDecimal bdDmCr120       = new BigDecimal(DMG_CORRECTION_120);
		BigDecimal dmgDef          = new BigDecimal(def);

        // ダメージ減算率：1 / (1＋ぼうぎょ÷120)  ※小数第３位切り捨て
		BigDecimal dmRate = bdDmCr1.divide( bdDmCr1.add( dmgDef.divide(bdDmCr120, 2, RoundingMode.DOWN) ), 2, RoundingMode.DOWN );

		// 計算した値の小数点以下を切り捨て、int型に変換
		// 実際に受けるダメージ計算：受け取ったダメージ値×ダメージ減算率
		int dmg  = ( temporaryDamage.multiply( dmRate ) ).intValue();

        // ダメージを受けた後、残りHPを求める処理
        if(hp >= damage){
            int remainingHP = hp - damage;
        }else{  
            int remainingHP = 0;
        }
        return dmg;
    }
}
