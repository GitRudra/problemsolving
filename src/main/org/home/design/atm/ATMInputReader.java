package org.home.design.atm;

public class ATMInputReader {

    private ScreenInputReader screenInputReader;
    private KeyPadInputReader keyPadInputReader;
    private CardReader cardReader;

    public AuthenticationInputInfo readLoginInfo(){
        AuthenticationInputInfo authInfo = new AuthenticationInputInfo();
        authInfo.setCardNo(cardReader.read());
        authInfo.setPin(keyPadInputReader.read());
        return authInfo;
    }
}
