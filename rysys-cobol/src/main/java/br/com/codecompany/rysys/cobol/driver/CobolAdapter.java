package br.com.codecompany.rysys.cobol.driver;

import br.com.codecompany.rysys.core.driver.SshAdapter;
import java.io.Serializable;

public class CobolAdapter extends SshAdapter {

	// necessario declarar por causa dos aspectos
	@Override
	public Serializable execute(Serializable command) {
		return super.execute(command);
	}

	public String getBeginTransactionCommand() {
		return NO_BEGIN_TRANSACTION_COMMAND;
	}

	public String getCommitCommand() {
		return NO_COMMIT_COMMAND;
	}

	public String getRollbackCommand() {
		return NO_ROLLBACK_COMMAND;
	}
}
