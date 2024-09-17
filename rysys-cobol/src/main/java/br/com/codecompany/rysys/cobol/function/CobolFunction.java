package br.com.codecompany.rysys.cobol.function;

import br.com.codecompany.rysys.api.executor.Protocol;
import br.com.codecompany.rysys.api.function.AbstractParameterFuncion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.function.CommandType;
import br.com.codecompany.rysys.api.function.Parameter;
import br.com.codecompany.rysys.cobol.executor.CobolProtocol;

import java.io.File;

import static br.com.codecompany.rysys.util.Constants.UNNAMED;

public class CobolFunction extends AbstractParameterFuncion {

    private static Logger log = LoggerFactory.getLogger(CobolFunction.class);
    public static final int STRING_TYPE = 4;
    private int commandType;
    private String moduleName;
    private Protocol protocol = new CobolProtocol();

    public CobolFunction(String path, String name) {
        super(name);
        log.info("Optional parameters ignored");

       /* if (path == null || path.trim().isEmpty()) {
            this.moduleName = "lib" + name + ".so";
        } else if (path.endsWith("/")) {
            this.moduleName = path + "lib" + name + ".so";
        } else {
            this.moduleName = path + "/" + "lib" + name + ".so";
        } */

        if (path == null || path.trim().isEmpty()) { this.moduleName =  "." + File.separator; }
        else if (path.endsWith("/")) { this.moduleName = path; }
        else { this.moduleName = path + File.separator; }

        log.info("Module name forced to: '{}'", moduleName);
        this.commandType = CommandType.FUNCTION_CALL;
    }

    public CobolFunction(String name) {
        this("", name);
    }

    public CobolFunction(String name, Object... optionalParams) {
        super(name);
        if (optionalParams != null && optionalParams.length > 0) {
            this.moduleName = String.valueOf(optionalParams[0]);
            log.info("Module name is '{}'", moduleName);
        }
        this.commandType = CommandType.FUNCTION_CALL;
    }

    public int getCommandType() {
        return commandType;
    }

    public String getModuleName() {
        return moduleName;
    }

    @Override
    public void addParameterValue(Object value) {
        String all = parametersAsString();
        String parameter = all + String.valueOf(value);
        parameters.clear();
        super.addParameter(new Parameter(parameter, UNNAMED, STRING_TYPE));
        log.info("Function's parameters updated: {}", parameter);
    }

    // considera a string como um unico parametro
    public void setParameters(Object paramters) {
        log.info("Single parameter added to function: '{}'", paramters);
        addParameterValue(paramters);
    }

    // concatena todos os parametros como uma unica string
    private String parametersAsString() {
        StringBuilder builder = new StringBuilder();
        for (Parameter parameter : parameters) {
            builder.append(String.valueOf(parameter.getValue()));
        }

        return builder.toString();
    }

    public Protocol getProtocol() {
        return protocol;
    }
}
