class Ex2_02_1_Player {

        final String HAND_G = "グー";
        final String HAND_C = "チョキ";
        final String HAND_P = "パー";

        // フィールド
        String name ; // プレイヤー名
        String handStatus; // ジャンケンの手

        // コンストラクタ
        Ex2_02_1_Player(String na){
            name = na;
        }

        // メソッド
        // ランダムにグー、チョキ、パーを出す
        void makeHandStatus(){
            int randomHand = 1 + (int)(Math.random() * 3);
            switch (randomHand) {
                case 1:
                    this.handStatus = HAND_G;
                    break;

                case 2:
                    this.handStatus = HAND_C;
                    break;

                case 3:
                    this.handStatus = HAND_P;
                    break;
            };
        }; 
    };
