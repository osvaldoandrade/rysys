package br.com.codecompany.rysys.core.jca.eis.transaction;

import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import br.com.codecompany.rysys.core.driver.ConnectionException;

public class BeginTransaction implements TransactionCommand {

    public void execute(ConnectionDriver conClient) throws ConnectionException {
        String command = conClient.getBeginTransactionCommand();
        if (command != null) {
            conClient.execute(command);
        }
    }
}
