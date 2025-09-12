public class Ex2_02_2_Janken {
	
	public static void main(String[] args) {
		
		String nameP1      = args[0] ; // プレイヤー1の名前
		String nameP2      = args[1] ; // プレイヤー2の名前
		String nameReferee = args[2] ; // 審判の名前
				
		Ex2_02_2_Player  p1      = new Ex2_02_2_Player(  nameP1 ) ;      // プレイヤー1をインスタンス化
		Ex2_02_2_Player  p2      = new Ex2_02_2_Player(  nameP2 ) ;      // プレイヤー2をインスタンス化
		Ex2_02_2_Referee ref     = new Ex2_02_2_Referee( nameReferee ) ; // 審判をインスタンス化
		
 		// 握らせる前に「じゃんけん・・・ぽん！！！！！」
		ref.startJanken();
		
		// それぞれのプレイヤーに手を握らせる
		p1.makeHandStatus();
		p2.makeHandStatus();
		
		// プレイヤーが何を出したか審判が言う
		ref.checkHand(p1);
		ref.checkHand(p2);
		
		
		// 結果
		ref.judgeJanken(p1,p2);
		
		
	}
}
