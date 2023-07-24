package strategy.GameWiningStartegy;

import modals.Board;
import modals.Cell;
import modals.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderOneWiningStarategy implements GameWiningStrategy {



    private List<HashMap<Character, Integer>> rowCheck = new ArrayList<>();
    private List<HashMap<Character, Integer>> colCheck = new ArrayList<>();

    private HashMap<Character, Integer> leftDigonal = new HashMap<>();

    private HashMap<Character, Integer> rightDigonal = new HashMap<>();

    public orderOneWiningStarategy(int dimension){


        for(int i = 0; i < dimension; i++){
            rowCheck.add(new HashMap<>());
            colCheck.add(new HashMap<>());
        }
    }

    private boolean isTopLeftDigonal(int row, int col, int dimension){

        return row == col;
    }

    private  boolean isTopRightDigonal(int row, int col, int dimension){

        return row + col - 1 == dimension;
    }
    @Override
    public boolean checkWinner(Board board, Player player, Cell cell) {

        char symbol = player.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();
        int dimension = board.getBoard().size();

        if(!rowCheck.get(row).containsKey(symbol)){
            rowCheck.get(row).put(symbol, 0);
        }

        rowCheck.get(row).put(symbol, rowCheck.get(row).get(symbol) + 1);

        if(!colCheck.get(col).containsKey(symbol)){
            colCheck.get(col).put(symbol, 0);
        }

        colCheck.get(col).put(symbol, colCheck.get(col).get(symbol) + 1);


        if(isTopLeftDigonal(row, col, dimension)){

            if(!leftDigonal.containsKey(symbol)){
                leftDigonal.put(symbol, 0);
            }
            leftDigonal.put(symbol, leftDigonal.get(symbol) + 1);
        }

        if(isTopRightDigonal(row, col, dimension)){

            if(!rightDigonal.containsKey(symbol)){
                rightDigonal.put(symbol, 0);
            }
            rightDigonal.put(symbol, rightDigonal.get(symbol) + 1);
        }

        if(rowCheck.get(row).get(symbol) == dimension || colCheck.get(col).get(symbol) == dimension){
            return  true;
        }

        if(isTopLeftDigonal(row, col, dimension) && leftDigonal.get(symbol) == dimension){
            return  true;
        }

        if(isTopRightDigonal(row, col, dimension) && rightDigonal.get(symbol) == dimension){
            return  true;
        }

        return false;
    }
}
