package br.com.codecompany.rysys.core.jca.eis.transaction;

import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import br.com.codecompany.rysys.core.driver.ConnectionException;

public interface TransactionCommand {
    void execute(ConnectionDriver conClient) throws ConnectionException;
}
