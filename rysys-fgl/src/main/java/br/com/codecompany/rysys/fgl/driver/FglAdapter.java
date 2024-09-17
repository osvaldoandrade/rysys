package br.com.codecompany.rysys.fgl.driver;

import java.io.Serializable;

import br.com.codecompany.rysys.api.function.CommandType;
import br.com.codecompany.rysys.core.driver.SshAdapter;

public class FglAdapter extends SshAdapter {
	
    private static final String FGL_BEGIN_TRANSACTION_COMMAND = 
    	String.valueOf(CommandType.BEGIN_TRANSACTION);
    
    private static final String FGL_COMMIT_COMMAND = 
    	String.valueOf(CommandType.COMMIT);
	
    private static final String FGL_ROLLBACK_COMMAND = 
    	String.valueOf(CommandType.ROLLBACK);

    // necessario declarar por causa dos aspectos
	@Override
    public Serializable execute(Serializable command) {
    	return super.execute(command);
    }
    
    public String getBeginTransactionCommand() {
        return FGL_BEGIN_TRANSACTION_COMMAND;
    }

    public String getCommitCommand() {
        return FGL_COMMIT_COMMAND;
    }

    public String getRollbackCommand() {
        return FGL_ROLLBACK_COMMAND;
    }

	@Override
	public void disconnect() {
		
	}
}
