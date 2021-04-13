package bai7_clean_code;

public class TennisGame {

    public static String getScore(String playerName1, String playerName2, int playerScore1, int playerScore2) {
        String score = "";
        if (playerScore1 == playerScore2) {
            switch (playerScore1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (playerScore1 >= 4 || playerScore2 >= 4) {
            int minusResult = playerScore1 - playerScore2;
            if (minusResult == 1) score = "Advantage " + playerName1;
            else if (minusResult == -1) score = "Advantage " + playerName2;
            else if (minusResult >= 2) score = "Win for " + playerName1;
            else if (minusResult<=-2) score = "Win for " + playerName2;
            else score="";
        }
//        } else {
//            for (int i = 1; i < 3; i++) {
//                if (i == 1) tempScore = playerScore1;
//                else {
//                    score += "-";
//                    tempScore = playerScore2;
//                }
//                switch (tempScore) {
//                    case 0:
//                        score += "Love";
//                        break;
//                    case 1:
//                        score += "Fifteen";
//                        break;
//                    case 2:
//                        score += "Thirty";
//                        break;
//                    case 3:
//                        score += "Forty";
//                        break;
//                }
//            }
        return score;
}

    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        System.out.println(game.getScore("nhat", "chau", 5, 6));
    }
}
