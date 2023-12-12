Requirement 
================

=> Players able to play this gave online 
=> Able to accept move from player 
=> Move should be defined as per standard 
=> System should maintain a log of all moves 
=> Player can undo a move within a window of few seconds 
=> Should we consider timer 




Component 
==========
Board
    int horizontalDiamentions
    int verticalDiamentions
    Box[][] boardStatus;  
    updateBoardAfteraValidMove(Piece, currentPosition, nextPosition);


Box
    Position boxPosition;
    Piece currentPiece
    String color
    
Player 
    Integer id
    String playerColor
    PlayerStats 
    Address 




Address
    Street 
    City 
    state 
    Country 


PlayerStats 
    playerId
    totalPlayedGame
    totalWin
    total loss
    rating

    

ChessGame
    Board board
    Player player1
    Player player2;
    GameStatus status;
    Result result;
    Player currentMove;

    makeMove(Player, Piece,  nextPosition);
    evaluateResult();

ChessController
        
    
    initializeGame
    
    
    

    
    
    
Position
    int horizontalDim;
    int verticalDim;



PieceMove
    getNextPossibleMove();

Piece
    String color

    king extend Piece, impliment PieceMove
        Position currentPosition
        
    Queen
        position
        


