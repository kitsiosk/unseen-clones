public class Clone63 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51725215
*  Stack Overflow answer #:51728810
*  And Stack Overflow answer#:51725343
*/
public void rollTheDiceAndMove () {
    int diceRoll = gameBoard.rollDice ();
    System.out.println ("Player: rolling the dice");
    PauseTransition pause = new PauseTransition (Duration.seconds (1));
    pause.setOnFinished (event -> {
        System.out.println ("1 second after rolling the dice");
        gameGUI.indicateDiceRoll (diceRoll);
        int newIndex = getPlayerIndexAfterRoll (diceRoll);
        playerMove (newIndex);
        if (checkWin (Player)) {
            System.out.println ("Player won!");
        } else {
            System.out.println ("change turns");
            swapTurns ();
            System.out.println (isComputerTurn ());
            gameGUI.updateCurrentTurnLabel ();
            computerRollDiceAndMove ();
        }
    });
    pause.play ();
}

public void rollTheDiceAndMove () {
    int diceRoll = gameBoard.rollDice ();
    ScheduledFuture < Void > scheduledFuture = Executors.newScheduledThreadPool (1).schedule (new Task < Void > () {
        @Override
        public Void call () {
            gameGUI.indicateDiceRoll (diceRoll);
            int newIndex = getPlayerIndexAfterRoll (diceRoll);
            ScheduledFuture < Void > moveScheduledFuture = move (newIndex);
            if (moveScheduledFuture != null) {
                moveScheduledFuture.get ();
            }
            System.out.println ("change turns");
            swapTurns ();
            System.out.println (isComputerTurn ());
            gameGUI.updateCurrentTurnLabel ();
            if (newIndex == GameBoard.WIN_POINT) {
                boolean restartGame = gameBoard.playAgainOrExit ();
                if (restartGame) {
                    Player winner = gameBoard.getCurrentPlayer ();
                    gameGUI.updateScore (winner);
                    gameGUI.playAgain ();
                } else {
                    System.exit (0);
                }
            }
            return null;
        }}
    , GameBoard.DICE_ROLL_DELAY, TimeUnit.SECONDS);
    scheduledFuture.get ();
}

}
