package service.impl;

import service.Investigations;

public class InvestigationsImpl implements Investigations {
    @Override
    public int incrementInv(int attribute,int levelInv) {

        return (int) (attribute + (((double) levelInv / 100 )* attribute));
    }

}
