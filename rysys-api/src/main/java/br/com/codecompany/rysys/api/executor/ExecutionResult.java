package br.com.codecompany.rysys.api.executor;

public interface ExecutionResult {
    public Object getResultAt(int index);
    public int size();
    public boolean isError();          
}
