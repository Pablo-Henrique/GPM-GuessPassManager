package com.happysy.gpc.service;

import com.happysy.gpc.repository.TickerPassRepositoryImpl;
import com.happysy.gpc.repository.TicketPassRepository;

public class TicketPassService {

    private static final int MAX_DIGIT_VALUE = 10;
    private static final int HUNDRED_DECIMAL_PLACE_VALUE = 0;
    private static final int TEN_DECIMAL_PLACE_VALUE = 1;
    private static final int UNIT_DECIMAL_PLACE_VALUE = 2;
    private final int[] decimalCount = {0, 0, 0};

    private final TicketPassRepository ticketPassRepository;

    public TicketPassService() {
        this.ticketPassRepository = new TickerPassRepositoryImpl();
    }

    public boolean isSyncPass(String senha) {
        return ticketPassRepository.findPassById(1).equals(senha);
    }

    public String syncPass() {
        return ticketPassRepository.findPassById(1);
    }

    public String generatePass() {
        incrementTicketPassValue(UNIT_DECIMAL_PLACE_VALUE);
        verifyDecimalValueInArrayToReset();
        ticketPassRepository.updatePassById(1, decimalCountToString());
        return ticketPassRepository.findPassById(1);
    }


    public void verifyDecimalValueInArrayToReset() {
        for (int i = 0; i < decimalCount.length; i++) {
            if (isTheNumberGreaterThanNine(decimalCount[i])) {
                incrementTicketPassValue(i - 1);
                resetValueToZeroByDecimalPosition(i);
            }
            if (isTheNumberGreaterThanNine(decimalCount[TEN_DECIMAL_PLACE_VALUE])) {
                incrementTicketPassValue(HUNDRED_DECIMAL_PLACE_VALUE);
                resetValueToZeroByDecimalPosition(TEN_DECIMAL_PLACE_VALUE);
            }

        }
    }

    public boolean isTheNumberGreaterThanNine(int value) {
        return value == MAX_DIGIT_VALUE;
    }

    public void resetValueToZeroByDecimalPosition(int index) {
        decimalCount[index] = 0;
    }

    public void decrementByDecimalPosition(int index) {
        decimalCount[index] -= 1;
    }

    public void incrementTicketPassValue(int index) {
        decimalCount[index] += 1;
    }

    public int getHundred() {
        return decimalCount[HUNDRED_DECIMAL_PLACE_VALUE];
    }

    public int getTen() {
        return decimalCount[TEN_DECIMAL_PLACE_VALUE];
    }

    public int getUnit() {
        return decimalCount[UNIT_DECIMAL_PLACE_VALUE];
    }

    public String decimalCountToString() {
        return String.format("%d%d%d", getHundred(), getTen(), getUnit());
    }

    public int[] decimalCountToInt() {
        return new int[]{getHundred(), getTen(), getUnit()};
    }

}