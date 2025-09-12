class Ex2_02_1_Janken{
	public static void main( String[] args ){
        final String HAND_G = "グー";
        final String HAND_C = "チョキ";
        final String HAND_P = "パー";

        String nameP1 = args[0] ; // プレイヤー1
        String nameP2 = args[1] ; // プレイヤー2
            
            
        // インスタンス化
        Ex2_02_1_Player p1 = new Ex2_02_1_Player( nameP1 ) ;
        Ex2_02_1_Player p2 = new Ex2_02_1_Player( nameP2 ) ;
            
            
            System.out.println( "じゃんけん・・・ぽん！！！！！" );
            
            // プレイヤーに手を握らせる
            p1.makeHandStatus();
            p2.makeHandStatus();
            
            // それぞれのプレイヤーがどんな手を出したかを確認する
            System.out.println( p1.name + "さんの手 : " + p1.handStatus );
            System.out.println( p2.name + "さんの手 : " + p2.handStatus );
            
            
            // 勝敗を表示
            // はじめに「結果は・・・」というメッセージを画面に表示する
            System.out.println( "結果は・・・" );
            
            
            // 結果に応じたメッセージを表示する
            if( (p1.handStatus).equals( p2.handStatus )
              ){
                
                //あいこの場合
                System.out.println("あいこ！勝負つかず！");
                
            }else if(     (p1.handStatus.equals( HAND_G ) && p2.handStatus.equals( HAND_C ))
                    || (p1.handStatus.equals( HAND_C ) && p2.handStatus.equals( HAND_P ))
                    || (p1.handStatus.equals( HAND_P ) && p2.handStatus.equals( HAND_G ))  ) {
                
                //プレイヤー1の勝ち
                System.out.println(p1.name + "さんの勝利！");
                
            }else if(     (p2.handStatus.equals( HAND_G ) && p1.handStatus.equals( HAND_C ))
                    || (p2.handStatus.equals( HAND_C ) && p1.handStatus.equals( HAND_P ))
                    || (p2.handStatus.equals( HAND_P ) && p1.handStatus.equals( HAND_G ))  ) {
                
                // プレイヤー2の勝ち
                System.out.println(p2.name + "さんの勝利！");
                
            }else{
                
                // 不正のエラーメッセージ
                System.out.println("[ERROR]ジャンケンの判定が不正です。");
                
            }
        }
    }

